package com.example.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Stock;
import com.example.mapper.StockMapper;
import com.example.service.StockService;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

}