package com.softwarevax.sharding.sharding.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.softwarevax.sharding.sharding.web.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
