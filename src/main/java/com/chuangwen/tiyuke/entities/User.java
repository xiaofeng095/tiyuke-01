package com.chuangwen.tiyuke.entities;

import java.util.Date;

/**
 * 用户实体类
 * @Title: Provider
 * @Description: com.mengxuegu.springboot.entities
 * @Auther: www.mengxuegu.com
 * @Version: 1.0
 */
public class User {
    //用户识别号
    private Integer uid;
    //用户名
	private String username;
    //用户密码
    private String password;
    //真是姓名
    private String realname;
    //属性
    private Integer attribute;

    public User(Integer uid,String username, String password, String realname, Integer attribute) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.attribute = attribute;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", attribute=" + attribute +
                '}';
    }
}
