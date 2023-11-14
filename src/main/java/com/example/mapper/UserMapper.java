package com.example.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;

@Repository
public interface UserMapper extends BaseMapper<User> {

}