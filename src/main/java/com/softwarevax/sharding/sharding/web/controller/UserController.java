package com.softwarevax.sharding.sharding.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softwarevax.sharding.sharding.config.DataUtils;
import com.softwarevax.sharding.sharding.config.DateUtils;
import com.softwarevax.sharding.sharding.config.SnowflakeIdWorker;
import com.softwarevax.sharding.sharding.config.SqlEntity;
import com.softwarevax.sharding.sharding.web.entity.Order;
import com.softwarevax.sharding.sharding.web.entity.OrderItem;
import com.softwarevax.sharding.sharding.web.entity.User;
import com.softwarevax.sharding.sharding.web.service.IOrderItemService;
import com.softwarevax.sharding.sharding.web.service.IOrderService;
import com.softwarevax.sharding.sharding.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderItemService orderItemService;

    @Autowired
    private IOrderService orderService;

    ExecutorService service = Executors.newFixedThreadPool(16);

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/save")
    public String save() {
        for (int i = 0; i < 1500; i++) {
            Map<SqlEntity, List> map = new HashMap<>();
            /*List<User> users = new ArrayList<>();
            List<Order> orders = new ArrayList<>();
            List<OrderItem> items = new ArrayList<>();*/
            for (int j = 0; j < 10000; j++) {
                Long userId = idWorker.nextId();
                User user = new User();
                user.setId(userId);
                user.setNickName("用户昵称" + ((i + 1) * (j + 1)));
                user.setPassWord("用户密码" + ((i + 1) * (j + 1)));
                user.setUserName("用户名" + ((i + 1) * (j + 1)));
                //users.add(user);
                SqlEntity userSql = DataUtils.getSqlEntity("t_user", "id", userId);
                DataUtils.put(map, userSql, user);
                Order order = new Order();
                order.setId(idWorker.nextId());
                order.setUserId(userId);
                order.setPrice(Math.random() * 100);
                order.setSignTime(DateUtils.format(DateUtils.randomDate("1970-01-01 00:00:00", "2022-03-06 00:00:00")));
                //orders.add(order);
                SqlEntity orderSql = DataUtils.getSqlEntity("t_order", "user_id", userId);
                DataUtils.put(map, orderSql, order);
                OrderItem item = new OrderItem();
                item.setId(idWorker.nextId());
                item.setUserId(userId);
                item.setPrice((Math.random() * 100));
                item.setOrderId(order.getId());
                item.setItemName("物品" + ((i + 1) * (j + 1)));
                //items.add(item);
                SqlEntity itemSql = DataUtils.getSqlEntity("t_order_item", "user_id", userId);
                DataUtils.put(map, itemSql, item);
            }
            //service.submit(() -> DataUtils.insert(dataSource, map));
        }
        return "success";
    }

    @RequestMapping("/queryList")
    public PageInfo queryList(int pageSize, int pageNo) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(userService.queryList());
    }

    @RequestMapping("/getById")
    public User getById(long id) {
        return userService.getById(id);
    }

    @RequestMapping("/getUserOrderById")
    public User getUserOrderById(Long userId) {
        return userService.getUserOrderById(userId);
    }
}