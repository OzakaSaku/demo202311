package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.StockIo;
import com.example.mapper.StockIoMapper;
import com.example.service.StockIoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StockIoServiceImpl extends ServiceImpl<StockIoMapper, StockIo> implements StockIoService {
    @Resource
    private StockIoMapper stockIoMapper;

    @Override
    public List<StockIo> selectList(StockIo stockIo) {

        return stockIoMapper.selectList(stockIo);
    }

}
