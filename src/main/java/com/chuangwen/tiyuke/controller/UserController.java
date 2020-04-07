package com.chuangwen.tiyuke.controller;

import com.chuangwen.tiyuke.dao.UserDao;
import com.chuangwen.tiyuke.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDao userDao;

    @GetMapping("/user_list")
    public String getUserList(Map<String,Object> map,@RequestParam(value = "userName",required = false)String userName){

        logger.info("供应商查询。。。"+userName);

        Collection<User> userList = userDao.getAll(userName);
        map.put("userList",userList);
        map.put("userSearch",userName);
        return "user/list.html";
    }

    /**
     * 查看与修改共用，根据type值判断返回view或update页面
     * @param userName 查询 用户名
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/user_view/{userName}")
    public String getUserView(@PathVariable("userName") String userName,
                            @RequestParam(value = "type",defaultValue = "view")String type,Map<String,Object> map){
        logger.info("查看"+userName+"详情");

        User user = userDao.userView(userName);

        map.put("userInfo",user);
        return "user/"+type;

    }

    @PutMapping("/user_update")
    public String userUpdate(User user){

        logger.info("修改"+user+"信息");

        userDao.save(user);
        return "redirect:/user_list";
    }

    @GetMapping("/user_add")
    public String toAddUserPage(){

        return "user/add.html";
    }

    @PostMapping("/user_add")
    public String addUser(User user){
        logger.info("添加"+user+"数据");
        userDao.save(user);
        return "redirect:/user_list";
    }

    @DeleteMapping("/user_delete/{uid}")
    public String deleteUser(@PathVariable("uid")Integer uid){
        logger.info("删除"+uid);
        userDao.delete(uid);
        return "redirect:/user_list";
    }

}
