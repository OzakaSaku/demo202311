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
@TableName("m_unit")
public class Unit {
	@TableId
    private Integer unitId;
    
    private String name;
    
    private Integer delFlg;
    
    private Date createDate;
    
    private String createUser;
    
    private Date updateDate;
    
    private String updateUser;

}
