package com.chuangwen.tiyuke.mapper;

import com.chuangwen.tiyuke.entities.Provider;
import com.chuangwen.tiyuke.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    //   获取所有供应商
    List<User> getAllProviders(User user);

    //    根据供应商名称查询
    User getUserById(Integer uid);

    //    添加供应商
    int addUser(User user);

    //    删除供应商
    int deleteUserById(Integer uid);

    //    更新供应商信息
    int updateUser(User user);

}
