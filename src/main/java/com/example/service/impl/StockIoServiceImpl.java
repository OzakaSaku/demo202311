package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Stock;
import com.example.entity.StockIo;
import com.example.entity.StockIoAddDTO;
import com.example.mapper.StockIoMapper;
import com.example.mapper.StockMapper;
import com.example.service.StockIoService;
import com.example.service.StockService;

@Service
public class StockIoServiceImpl extends ServiceImpl<StockIoMapper, StockIo> implements StockIoService {
	
	@Autowired
	private StockIoMapper stockIoMapper;

    public StockIoAddDTO getStockIoById(String id) {
        return stockIoMapper.selectStockIo(id);
    }

	public int insertStockIo(StockIo stockIo) {
		
		return stockIoMapper.insert(stockIo);
	}
	
	
}