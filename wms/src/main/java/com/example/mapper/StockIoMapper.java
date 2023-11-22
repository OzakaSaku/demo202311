package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.StockIo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockIoMapper extends BaseMapper<StockIo> {

    List<StockIo> selectList(StockIo stockIo);
}
