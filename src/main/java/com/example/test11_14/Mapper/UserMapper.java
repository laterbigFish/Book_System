package com.example.test11_14.Mapper;

import com.example.test11_14.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user_info where user_name = #{userName}")
    UserInfo selectPasswordAndUserName(String userName);

}
