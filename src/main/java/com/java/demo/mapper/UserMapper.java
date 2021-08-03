package com.java.demo.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.demo.model.entity.User;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
