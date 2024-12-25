package com.bli.my_bli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication  //支持SpringBoot 功能的应用程序
public class my_bliApp implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(my_bliApp.class,args); // 运行springboot 程序
    }
    // 作用:把url路径和磁盘路径做一个映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/play/**").addResourceLocations("file:C:\\Users\\25433\\Desktop\\my_bli\\src\\main\\resources\\static\\img\\");
        //registry.addResourceHandler("/img/**").addResourceLocations("file:d:\\img\\");
    }

    @Value("{video-path}")
    private String videoPath;
}
