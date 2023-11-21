package com.example.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Stock;
import com.example.mapper.StockMapper;
import com.example.req.StoReq;
import com.example.service.StockService;
import com.example.vo.StocksVo;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {
	
	@Autowired
	StockMapper stockMapper;

	@Override
	public List<StocksVo> getList(StoReq stoReq) {
		
		List<StocksVo> list = stockMapper.getStoList(stoReq);
		list.forEach(System.out::println);
		return list;
	}

}