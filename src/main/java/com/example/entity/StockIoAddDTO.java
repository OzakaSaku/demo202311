package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockIoAddDTO {

	@TableId
    private String id;
    private String stockName;
    private String unitName;
    private Integer stockNum;
    private Integer ioType;
    private Integer ioNum;
    private String remarks;
	
	
}
