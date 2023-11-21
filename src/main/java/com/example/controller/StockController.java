package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.R;
import com.example.entity.Stock;
import com.example.req.StoReq;
import com.example.service.StockService;
import com.example.vo.StocksVo;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping({"/api/stock/list" })
    public R<List<StocksVo>> index(StoReq stoReq ) {

		log.info("请求/api/stock/list");
		List<StocksVo> stocks = stockService.getList(stoReq); 
		
		return R.success(stocks);
    }
	
	@RequestMapping("/api/stock/deleteSto")
	@ResponseBody
	public R<Stock> delectSto(@RequestParam("idList") List<Integer> idList){
		stockService.removeBatchByIds(idList);
		return R.ok();
	}
}
