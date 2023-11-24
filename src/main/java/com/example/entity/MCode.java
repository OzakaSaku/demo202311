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
@TableName("m_code")
public class MCode {
	@TableId
    private int codeId;
    private String name;
    private int delFlg;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
    private int version;
}
