package com.example.test11_14.Model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
