package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Stock;
import com.example.req.StoReq;
import com.example.vo.StocksVo;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface StockMapper extends BaseMapper<Stock> {
	List<StocksVo> getStoList(StoReq stoReq);

	@Insert("insert into t_stock(stock_id,name,unit_id,remarks) " +
			"values(#{stockId},#{name},#{unitId},#{remarks}) ")
	void addStoList(Stock stock);

	@Update("update t_stock set name = #{name},unitId = #{unit_id},remarks = #{remarks}")
	void updateSto(Stock stock);
}