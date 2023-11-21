package com.example.vo;

import java.sql.Date;



import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data

public class  StocksVo {
	
	/**
	 * 逻辑删除： 0：显示  1：隐藏
	 */
	private int delFlg;
	private String stockId;
	private String tName;
	private int unitId;
	private String mName;
	private int stockNum;
	private String remarks;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;
	private String createUser;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;
	private String updateUser;
	private int version;
	
	

}
