package com.chuangwen.tiyuke.dao;



import com.chuangwen.tiyuke.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

@Repository
public class UserDao {

    private static List<User> userlist = null;

//    static{
//        userMap = new HashMap<Integer, User>();
//
//        userMap.put(1001, new User("admin", "123456", "许晓峰", 0));
//        userMap.put(1002, new User("root", "123456", "夏传林", 1));
//        userMap.put(1003, new User("admin", "123456", "许晓峰", 0));
//        userMap.put(1004, new User("admin", "123456", "许晓峰", 0));
//        userMap.put(1005, new User("admi", "123456", "许晓峰", 0));
//
//    }

    static {
        userlist = new ArrayList<>();
        userlist.add(new User(1001,"许晓峰111", "123456", "许晓峰111", 0));
        userlist.add(new User(1002,"夏传林123", "123456", "许晓峰111", 1));
        userlist.add(new User(1003,"admin213", "123456", "许晓峰123", 0));
        userlist.add(new User(1004,"admin321", "123456", "许晓峰213", 1));
        userlist.add(new User(1005,"admin222", "123456", "许晓峰321", 0));
    }


    //添加、修改 用户名
    public void save(User user){
//            int count = 0;
//            for (int i = 0;i<userlist.size();i++) {
//                //判断修改值是否已存在
//                if (user.getUid().equals(userlist.get(i).getUid())){
//                    //修改
//                    userlist.set(i,user);
//                    //结束操作
//                    break;
//                }
//                //累计比对次数
//                count++;
//            }
//            //添加数据
//            if (count>userlist.size()){
//                userlist.add(user);
//            }
        //若uid为空则添加新用户
        if(user.getUid() == null){
            //获取最后一位用户得id号自增
            user.setUid(userlist.get(userlist.size()-1).getUid()+1);
            //添加新用户
            userlist.add(user);
        }else{//uid不为空 编辑用户信息
            for (int i = 0;i<userlist.size();i++) {
                //判断修改值是否已存在
                if (user.getUid().equals(userlist.get(i).getUid())){
                    //修改
                    userlist.set(i,user);
                    //结束操作
                    break;
                }
            }
        }
    }

    public Collection<User> getAll(){
        return userlist;
    }

    public Collection<User> getAll(String username){
        Collection<User> users = getAll();

        //不为空
        if( !StringUtils.isEmpty( username )) {
            int count = 0;
            for (User user: users) {
                //包含则存在
                if ( user.getUsername().toUpperCase().contains(  username.toUpperCase() ) ) {
                    count++;
                    //count>1 表示集合至少有一个存在的用户, 否则创建新的集合
                    users = count > 1 ? users : new ArrayList<User>();
                    users.add(user);
                }
            }
            if (count==0){
                //没有查询到，返回空集合
                users = new ArrayList<User>();
            }
        }

        return users;
    }

    //详情页面查看
    public User userView(String userName){

        User user = null;
        //list集合中查找元素下标
        for (int i=0;i<userlist.size();i++){
            if (userName.equals(userlist.get(i).getUsername())){
             //根据下标获取对象
             user = userlist.get(i);
            }
        }

        //返回查询到的数据
        return user;

    }

    //删除用户
    public void delete(Integer uid){
        //遍历User数组
        for (int i = 0;i<userlist.size();i++) {
            //判断需要删除得用户数据下标
            if (uid.equals(userlist.get(i).getUid())){
                //删除数据
                userlist.remove(i);
            }


        }
    }


}
