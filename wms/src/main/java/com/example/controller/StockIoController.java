package com.example.controller;

import com.example.common.R;
import com.example.entity.StockIo;
import com.example.service.impl.StockIoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;


@RestController
@RequestMapping("/stockIo")
public class StockIoController {

    @Resource
    StockIoServiceImpl stockIoService;


    @GetMapping("/list")
    public R<List<StockIo>> selectList(StockIo stockIo ){

        List<StockIo> stockIoList = stockIoService.selectList(stockIo);

        return R.success(stockIoList);
    }

}
