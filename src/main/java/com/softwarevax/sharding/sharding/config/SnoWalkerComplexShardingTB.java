package com.softwarevax.sharding.sharding.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
public class SnoWalkerComplexShardingTB implements ComplexKeysShardingAlgorithm {

    /**
     *
     * @param availableTargetNames 配置的数据源(ds0,ds1)
     * @param shardingValue 分片的字段，及字段对应的值
     * @return 数据要插入的数据库对应数据源的集合ds0,ds1
     */
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        Map<String, Collection> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        //System.out.println("所有的sharding列的值为" + columnNameAndShardingValuesMap);
        Set<String> result = new HashSet<>();
        String key = columnNameAndShardingValuesMap.keySet().iterator().next();
        Collection idColl = columnNameAndShardingValuesMap.get(key);
        for (Object idObj: idColl) {
            if (idObj instanceof Integer || idObj instanceof Long) {
                long idTemp = Long.parseLong(idObj.toString());
                String idStr = String.valueOf(idTemp);
                String a = idStr.substring(idStr.length() - 2, idStr.length() - 1);
                Integer num = Integer.valueOf(a);
                String endWith = String.valueOf(num % 2 == 1 ? (num - 1) / 2 : num / 2);
                for (Object targetNames : availableTargetNames) {
                    if (targetNames.toString().endsWith(endWith + "")) {
                        result.add(targetNames.toString());
                    }
                }
            }
        }
        //log.info("表分片 = {}, size = {}", result, result.size());
        return result;
    }
}
