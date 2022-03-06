package com.softwarevax.sharding.sharding.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarevax.sharding.sharding.web.entity.OrderItem;
import com.softwarevax.sharding.sharding.web.mapper.OrderItemMapper;
import com.softwarevax.sharding.sharding.web.service.IOrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {
}
