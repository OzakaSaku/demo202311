package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("m_code")
public class MCode {

  private int codeId;
  private String name;
  private int delFlg;
  private Date createDate;
  private String createUser;
  private Date updateDate;
  private String updateUser;
  private int version;


}
