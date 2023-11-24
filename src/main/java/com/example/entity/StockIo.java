package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_stock_io")
public class StockIo {
    @TableId
    private String id;
    private Integer inOutNo;
    private Integer ioType;
    private Integer ioNum;
    private String remarks;
    private Integer delFlg;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
    private Integer version;
}
