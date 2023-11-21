package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Stock;
import com.example.req.StoReq;
import com.example.vo.StocksVo;


@Service
public interface StockService extends IService<Stock>  {
	List<StocksVo> getList(StoReq stoReq);

}
