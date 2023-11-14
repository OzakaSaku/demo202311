package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {
	
	@TableId
    private String userId;
	
    private String userName;
	
    private String password;
	
    private String delFlg;
    
    private String createDate;
    
    private String createUser;
    
    private String updateDate;
    
    private String updateUser;

    
}