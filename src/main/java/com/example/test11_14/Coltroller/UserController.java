package com.example.test11_14.Coltroller;

import com.example.test11_14.Mapper.UserMapper;
import com.example.test11_14.Service.Judege;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
///user/login
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Judege judege;
    @RequestMapping("/login")
    public boolean judegeUser(String userName,String password,HttpServletRequest httpServletRequest){
        //次数需要是否已经登录过

        boolean b = judege.UserNameAndPassword(userName, password, httpServletRequest);
        return b;
    }
}
