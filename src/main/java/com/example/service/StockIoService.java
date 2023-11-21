package com.example.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Stock;
import com.example.entity.StockIo;
import com.example.entity.StockIoAddDTO;

@Service
public interface StockIoService extends IService<StockIo>  {

	StockIoAddDTO getStockIoById(String id);
	
	int insertStockIo(StockIo stockIo);
	
}
