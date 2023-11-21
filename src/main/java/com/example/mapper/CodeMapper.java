package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Code;
import com.example.entity.Unit;

@Mapper
public interface CodeMapper extends BaseMapper<Code>  {

}
