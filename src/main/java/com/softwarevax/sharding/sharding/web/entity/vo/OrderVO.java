package com.softwarevax.sharding.sharding.web.entity.vo;

import com.softwarevax.sharding.sharding.web.entity.Order;
import com.softwarevax.sharding.sharding.web.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderVO extends Order {

    private List<OrderItem> items;
}
