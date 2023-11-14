package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}