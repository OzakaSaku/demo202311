package com.example.entity;

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

  private String id;
  private String inOutNo;
  private String ioType;
  private String ioNum;
  private String remarks;
  private String delFlg;
  private String createDate;
  private String createUser;
  private String updateDate;
  private String updateUser;
  private String version;

}
