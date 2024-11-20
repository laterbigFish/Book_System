package com.example.test11_14.enums;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum BookEnum {
    DELETED(0,"删除"),
    NORMAL(1,"可借阅"),
    FORBIDDEN(2,"不可借阅");

    private Integer code;
    private String desc;

    BookEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static BookEnum getStatusByCode(Integer code){
        //使用lamda表达式
        Optional<BookEnum> first = Arrays.stream(BookEnum.values()).filter(x -> x.getCode() == code).findFirst();
        return first.get();
    }
}
