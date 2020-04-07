package com.chuangwen.tiyuke.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (!StringUtils.isEmpty(loginUser)){
            //已经登陆过,放行
            return true;
        }
        //没有登陆，返回登陆界面
        request.setAttribute("msg","没有权限，请先登陆");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
}
