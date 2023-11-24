package com.example.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data

public class StockIoDTO {

    private String name;
    private int ioNum;
    private String remarks;
    private LocalDateTime updateDate;
    private String updateUser;
    private int codeId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDateFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDateTo;

}
