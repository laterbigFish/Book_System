package com.example.test11_14.Service;

import com.example.test11_14.Mapper.UserMapper;
import com.example.test11_14.Model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class Judege {
    @Autowired
    private UserMapper userMapper;

    public boolean UserNameAndPassword(String userName, String password, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();

        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) return false;

        UserInfo userInfo = userMapper.selectPasswordAndUserName(userName);

        if(userInfo.getPassword().equals(password)){

            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }
}
