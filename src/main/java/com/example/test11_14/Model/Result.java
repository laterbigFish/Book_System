package com.example.test11_14.Model;


import com.example.test11_14.contains.Constants;
import lombok.Data;

@Data
public class Result<T> {
    private int code; //200-成功  -1 用户未登录  -2 程序出错   业务状态码, 非http状态码
    private String errMsg;
    private T data;

    public static <T> Result success(T data){
        Result result = new Result();
        result.setCode(Constants.SUCCESS_CODE);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result unlogin(){
        Result result = new Result();
        result.setCode(Constants.UNLOGIN_CODE);
        result.setErrMsg("用户未登录");
        return result;
    }

    public static <T> Result fail(T data){
        Result result = new Result();
        result.setCode(Constants.FAIL_CODE);
        result.setErrMsg("程序发生错误!");
        return result;
    }
    public static <T> Result fail(){
        Result result = new Result();
        result.setCode(Constants.FAIL_CODE);
        result.setErrMsg("程序发生错误!");
        return result;
    }
}