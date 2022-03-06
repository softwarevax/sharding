package com.softwarevax.sharding.sharding.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarevax.sharding.sharding.web.entity.User;
import com.softwarevax.sharding.sharding.web.entity.vo.UserVO;
import com.softwarevax.sharding.sharding.web.mapper.UserMapper;
import com.softwarevax.sharding.sharding.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryList() {
        return userMapper.queryList();
    }

    @Override
    public UserVO getUserOrderById(Long userId) {
        return userMapper.getUserOrderById(userId);
    }
}
