package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.StockIo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface    StockIoService extends IService<StockIo> {
    List<StockIo> selectList(StockIo stockIo);

}
