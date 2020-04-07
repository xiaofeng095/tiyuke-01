package com.chuangwen.tiyuke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //登陆
    @PostMapping("/login")
    public String login(HttpSession session,String username, String password, Map<String,Object> map){
        //判断用户账号与密码

        //登陆成功
        if (!StringUtils.isEmpty(username) &&"123456".equals(password)){

            session.setAttribute("loginUser",username);
            //重定向到首页
            return "redirect:index";

        }else{//登陆失败

            //设置错误信息
            map.put("msg","用户名或密码错误");
            //返回登陆界面
            return "main/login";

        }


    }

    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){

        //销毁session loginUser
        session.removeAttribute("loginUser");
        //注销session
        session.invalidate();
        //退出到登陆界面
        return "redirect:";
    }



}
