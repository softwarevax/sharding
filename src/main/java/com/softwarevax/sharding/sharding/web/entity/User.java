package com.softwarevax.sharding.sharding.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("t_user")
public class User extends Model<User>  {

    @TableId(value = "id")
    private Long id;

    @TableField("user_name")
    private String userName;

    @TableField("pass_word")
    private String passWord;

    @TableField("nick_name")
    private String nickName;
}
