package com.softwarevax.sharding.sharding.config;

import com.google.common.collect.Range;
import com.softwarevax.sharding.sharding.web.entity.Order;
import com.softwarevax.sharding.sharding.web.entity.OrderItem;
import com.softwarevax.sharding.sharding.web.entity.User;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.*;

public class DataUtils {

    private static SnoWalkerComplexShardingDB db = new SnoWalkerComplexShardingDB();

    private static SnoWalkerComplexShardingTB tb = new SnoWalkerComplexShardingTB();

    private static Map<String, Range<Long>> columnNameAndRangeValuesMap = new HashMap<>();

    private static Map<String, JdbcTemplate> jdbcMap = new HashMap<>();

    private static Map<String, String> sqlMap = new HashMap<>();

    private static List<String> dbList = new ArrayList<>();

    private static Collection<Long> userIds = new ArrayList<>();

    private static Map<String, Collection<Long>> columnNameAndShardingValuesMap = new HashMap<>();

    static {
        for (int i = 0; i < 5; i++) {
            dbList.add("ds0");
            dbList.add("ds1");
        }

        sqlMap.put("t_user", "insert into %s values(%s, %s, %s, %s);");
        sqlMap.put("t_order", "insert into %s values(%s, %s, %s, %s);");
        sqlMap.put("t_order_item", "insert into %s values(%s, %s, %s, %s, %s);");
    }

    public DataUtils() {

    }

    public static SqlEntity getSqlEntity(String logicName, String shardingColumn, Long userId) {
        userIds.clear();
        userIds.add(userId);
        columnNameAndShardingValuesMap.clear();
        columnNameAndShardingValuesMap.put(shardingColumn, userIds);
        ComplexKeysShardingValue csv = new ComplexKeysShardingValue(logicName, columnNameAndShardingValuesMap, columnNameAndRangeValuesMap);
        List<String> tbList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tbList.add(logicName + "_" + i);
        }
        Collection<String> tbColl = tb.doSharding(tbList, csv);
        String tableName = tbColl.iterator().next();
        Collection<String> dbColl = db.doSharding(dbList, csv);
        String dbName = dbColl.iterator().next();
        return new SqlEntity(dbName, tableName);
    }

    public static void put(Map<SqlEntity, List> map, SqlEntity sqlEntity, Object obj) {
        List list = map.get(sqlEntity);
        if(list == null) {
            list = new ArrayList();
        }
        list.add(obj);
        map.put(sqlEntity, list);
    }

    public static void insert(DataSource ds, Map<SqlEntity, List> map) {
        Map<String, DataSource> dataSourceMap = ((ShardingDataSource) ds).getDataSourceMap();
        jdbcMap.put("ds0", new JdbcTemplate(dataSourceMap.get("ds0")));
        jdbcMap.put("ds1", new JdbcTemplate(dataSourceMap.get("ds1")));

        Iterator<Map.Entry<SqlEntity, List>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<SqlEntity, List> next = iterator.next();
            SqlEntity key = next.getKey();
            List value = next.getValue();
            JdbcTemplate jdbcTemplate = jdbcMap.get(key.getDs());
            String table = key.getTable();
            String tablePrefix = table.substring(0, table.lastIndexOf("_"));
            StringBuilder sb = new StringBuilder();
            for (Object obj : value) {
                String sql = null;
                if(obj instanceof OrderItem) {
                    OrderItem objItem = (OrderItem) obj;
                    sql = String.format(sqlMap.get(tablePrefix), table, objItem.getId(), objItem.getUserId(), objItem.getOrderId(), "'" + objItem.getItemName() + "'", objItem.getPrice());
                } else if(obj instanceof User) {
                    User user = (User) obj;
                    sql = String.format(sqlMap.get(tablePrefix), table, user.getId(), "'" + user.getUserName() + "'", "'" + user.getPassWord() + "'", "'" + user.getNickName() + "'");
                } else if(obj instanceof Order) {
                    Order order = (Order) obj;
                    sql = String.format(sqlMap.get(tablePrefix), table, order.getId(), order.getUserId(), order.getPrice(), "'" + order.getSignTime() + "'");
                }
                sb.append(sql);
            }
            jdbcTemplate.execute(sb.toString());
        }
    }
}
