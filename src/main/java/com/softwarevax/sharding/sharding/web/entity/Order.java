package com.softwarevax.sharding.sharding.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("t_order")
public class Order extends Model<Order> {

    @TableId(value = "id")
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("price")
    private Double price;

    @TableField("sign_time")
    private String signTime;
}
