package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Stock;

@Mapper
public interface StockMapper extends BaseMapper<Stock> {

}