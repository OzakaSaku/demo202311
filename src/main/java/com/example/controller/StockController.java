package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.R;
import com.example.entity.Stock;
import com.example.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping({"/api/stock/list" })
    public R<List<Stock>> index( ) {

		log.info("请求/api/stock/list");
		List<Stock> stocks = stockService.list();  
		
		return R.success(stocks);
    }
}
