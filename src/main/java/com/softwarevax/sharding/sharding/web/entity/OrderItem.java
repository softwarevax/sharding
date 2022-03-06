package com.softwarevax.sharding.sharding.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("t_order_item")
public class OrderItem extends Model<OrderItem> {

    @TableId(value = "id")
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("order_id")
    private Long orderId;

    @TableField("item_name")
    private String itemName;

    @TableField("price")
    private Double price;
}
