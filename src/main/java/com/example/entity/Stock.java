package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.entity.Stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_stock")
public class Stock {
	@TableId
    private String stockId;
    private String name;
    private int unitId;
    private int stockNum;
    private String remarks;
    private boolean delFlg;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
    private int version;
}
