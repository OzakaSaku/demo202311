package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.R;
import com.example.entity.StoReq;
import com.example.entity.Stock;
import com.example.entity.StocksVo;
import com.example.service.StockService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping({"/api/stock/list" })
    public R<List<StocksVo>> getAllStocks(StoReq stoReq) {
		log.info("请求/api/stock/list");
		List<StocksVo> stocks = stockService.getList(stoReq); 
		
		return R.success(stocks);
    }
	
	@RequestMapping("/api/stock/deleteSto")
	@ResponseBody
	public R<Stock> delectSto(@RequestParam("idList") List<String> idList){
		stockService.removeBatchByIds(idList);
		return R.ok();
	}

	@RequestMapping("/api/stock/addSto")
	@ResponseBody
	public R<String> addSto(@RequestParam Stock stock){
		//stock.setStockId(String.valueOf(UUID.randomUUID()));
		try {
			stockService.addSto(stock);
			return R.ok();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@RequestMapping("api/stock/updateSto")
	@ResponseBody
	public R<String> updateSto(@RequestParam Stock stock){
		try {
			stockService.update(stock);
			return R.ok();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
