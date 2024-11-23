package com.example.test11_14.erIntercepto;

import com.example.test11_14.contains.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginerIntercepto implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进行进一步的校验
        log.info("登录拦截...");
        HttpSession session = request.getSession(false);
        if (session==null || session.getAttribute(Constants.SESSION_USER_KEY)==null ||
                !StringUtils.hasLength((String)session.getAttribute(Constants.SESSION_USER_KEY))){
            //用户未登录
            log.error("用户未登录, 进行拦截");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getOutputStream().write("{\"ok\": false}".getBytes());
            response.setContentType("application/json;charset=utf-8");
            return false;
        }
        log.info("用户登录校验通过..");
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}
