package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Stock;
import com.example.entity.StockIo;
import com.example.entity.StockIoAddDTO;

@Mapper
public interface StockIoMapper extends BaseMapper<StockIo> {

    @Select("SELECT t_stock_io.id, t_stock.name as stock_name, m_unit.name as unit_name, t_stock.stock_num, t_stock_io.io_type, t_stock_io.io_num, t_stock.remarks " +
            "FROM t_stock_io " +
            "JOIN t_stock ON t_stock_io.id = t_stock.stock_id " +
            "JOIN m_unit ON t_stock.unit_id = m_unit.unit_id " +
            "WHERE t_stock_io.id = #{id}" +
    		"LIMIT 1")
    StockIoAddDTO selectStockIo(String id);
	
//    @Insert("INSERT INTO t_stock_io (id, in_out_no, io_type, io_num, remarks, del_flg, create_date, create_user, update_date, update_user, version) " +
//            "VALUES (#{id}, #{inOutNo}, #{ioType}, #{ioNum}, #{remarks}, #{delFlg}, #{createDate}, #{createUser}, #{updateDate}, #{updateUser}, #{version})")
//    int insertStockIo(StockIo stockIo);
    
    
}