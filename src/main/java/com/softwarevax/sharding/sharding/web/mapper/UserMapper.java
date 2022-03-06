package com.softwarevax.sharding.sharding.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.softwarevax.sharding.sharding.web.entity.User;
import com.softwarevax.sharding.sharding.web.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> queryList();

    UserVO getUserOrderById(@Param("userId") Long userId);
}
