package com.chuangwen.tiyuke.config;

import com.chuangwen.tiyuke.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyBootController {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                //后台管理系统登陆地址
                registry.addViewController("/").setViewName("main/login.html");
                registry.addViewController("/login").setViewName("main/login.html");

                //后台管理系统首页
                registry.addViewController("/index").setViewName("main/index.html");

                //订单管理
                registry.addViewController("/bill_add").setViewName("bill/add.html");
                registry.addViewController("/bill_list").setViewName("bill/list.html");
                registry.addViewController("/bill_update").setViewName("bill/update.html");
                registry.addViewController("/bill_view").setViewName("bill/view.html");


                //用户管理
                //registry.addViewController("/user_add").setViewName("user/add.html");
                registry.addViewController("/userlist").setViewName("user/list.html");
                //registry.addViewController("/user_update").setViewName("user/update.html");
                //registry.addViewController("/user_view").setViewName("user/view.html");

                //供应商管理
//                registry.addViewController("/provider_add").setViewName("provider/add.html");
               registry.addViewController("/provider_list").setViewName("provider/list.html");
//                registry.addViewController("/provider_update").setViewName("provider/update.html");
//                registry.addViewController("/provider_view").setViewName("provider/view.html");

                //登陆密码修改
                registry.addViewController("/main_password").setViewName("main/password.html");
                //返回登陆界面
                registry.addViewController("/main_login").setViewName("main/login.html");


                //学校界面
                registry.addViewController("/schoolIndex").setViewName("school/main/public.html");
                registry.addViewController("/school_password").setViewName("school/main/password.html");
                registry.addViewController("/schedule_list").setViewName("school/manschedule/list.html");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        //拦截所有请求
                        .addPathPatterns("/**")
                        //放行登陆界面
                        .excludePathPatterns("/","/login","/schoolIndex","/teacher_list")
                        .excludePathPatterns("/teacher_update","/teacher_view/*","/teacher_delete/*",
                                "/teacher_add","/school_password","/course_list","/course_view/*",
                                "/course_update","/course_add","/course_delete/*","/schedule_list")
                        //放行静态资源
                        .excludePathPatterns("/css/*","/img/*","/js/*","/webjars/**");
            }
        };
    }
}