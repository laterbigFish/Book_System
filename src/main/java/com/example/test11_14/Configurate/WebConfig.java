package com.example.test11_14.Configurate;

import com.example.test11_14.erIntercepto.LoginerIntercepto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private com.example.test11_14.erIntercepto.LoginerIntercepto LoginerIntercepto;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginerIntercepto())
                .addPathPatterns("/book/**"); //在book路径下的所有文件

    }
}
