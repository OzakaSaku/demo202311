package com.example.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Unit;
import com.example.entity.User;
import com.example.mapper.UnitMapper;
import com.example.mapper.UserMapper;
import com.example.service.UnitService;
import com.example.service.UserService;

@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements UnitService {

}