package com.softwarevax.sharding.sharding.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarevax.sharding.sharding.web.entity.Order;
import com.softwarevax.sharding.sharding.web.mapper.OrderMapper;
import com.softwarevax.sharding.sharding.web.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
