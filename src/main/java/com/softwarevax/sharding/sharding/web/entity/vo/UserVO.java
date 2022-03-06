package com.softwarevax.sharding.sharding.web.entity.vo;

import com.softwarevax.sharding.sharding.web.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserVO extends User {

    private List<OrderVO> orders;
}
