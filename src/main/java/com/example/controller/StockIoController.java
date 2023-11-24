package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.R;
import com.example.entity.Stock;
import com.example.entity.StockIo;
import com.example.entity.StockIoAddDTO;
import com.example.service.StockIoService;
import com.example.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StockIoController {
	
	@Autowired
	private StockIoService stockIoService;
	
	
	
    @GetMapping("/list")
    public R<List<StockIo>> selectList(StockIo stockIo ){

        List<StockIo> stockIoList = stockIoService.selectList(stockIo);

        return R.success(stockIoList);
    }
	
	
	
	
	@Autowired
	private StockService stockService;
	
	@GetMapping({"/api/stockioadd/{id}" })
    public R<StockIoAddDTO> one(@PathVariable("id") String id) {
		
		StockIoAddDTO s = stockIoService.getStockIoById(id);
		
		log.info(s.toString());

		return R.success(s);
    }
	
	@PostMapping({"/api/stockio" })
    public R<String> insertStockIo(@RequestBody StockIo stockIo) {
		
		QueryWrapper<StockIo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id", stockIo.getId());
		
		Long inout = stockIoService.count(queryWrapper);
		Integer inoutInteger = inout.intValue();
		inoutInteger ++;
		
		log.info(inout.toString());
		
		stockIo.setInOutNo(inoutInteger);
		log.info(stockIo.toString());
		Integer success = stockIoService.insertStockIo(stockIo);
		log.info(success.toString());
		
		if (success > 0) {
			
			Stock sss = stockService.getById(stockIo.getId());
			
			log.info("sss.getStockNum()--->" + sss.getStockNum());
			log.info("stockIo.getIoNum()--->" + stockIo.getIoNum());
			
			// 更新库存
			if (stockIo.getIoType() == 1) {

				sss.setStockNum(sss.getStockNum() + stockIo.getIoNum());
				log.info("stockIo.getIoNum()--->" + stockIo.getIoNum());
				log.info("sss.getStockNum()--->" + sss.getStockNum());
				Boolean succ = stockService.updateById(sss);
				
				if (succ) {
					return R.ok();
				}else {
					return R.error("添加失败");
				}
			}else {
				sss.setStockNum(sss.getStockNum() - stockIo.getIoNum());
				
				log.info("sss.getStockNum()--->" + sss.getStockNum());
				
				if (sss.getStockNum() < 0) {
					return R.error("添加失败");
				}
				
				Boolean succ = stockService.updateById(sss);
				
				if (succ) {
					return R.ok();
				}else {
					return R.error("添加失败");
				}
			}
			
			
			
		} else {
			return R.error("添加失败");
		}

		
    }
	
	
}
