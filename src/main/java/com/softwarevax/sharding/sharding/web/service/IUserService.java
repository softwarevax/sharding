package com.softwarevax.sharding.sharding.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softwarevax.sharding.sharding.web.entity.User;
import com.softwarevax.sharding.sharding.web.entity.vo.UserVO;

import java.util.List;

public interface IUserService extends IService<User> {

    List<User> queryList();

    UserVO getUserOrderById(Long userId);
}
