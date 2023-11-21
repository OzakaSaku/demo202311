package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Stock;
import com.example.req.StoReq;
import com.example.vo.StocksVo;


@Mapper
public interface StockMapper extends BaseMapper<Stock> {
	List<StocksVo> getStoList(StoReq stoReq);

}