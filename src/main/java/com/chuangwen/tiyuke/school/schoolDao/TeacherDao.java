package com.chuangwen.tiyuke.school.schoolDao;

import com.chuangwen.tiyuke.entities.User;
import com.chuangwen.tiyuke.school.schoolEntities.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class TeacherDao {
    private static List<Teacher> teacherList = null;


    static {
        teacherList = new ArrayList<>();
        teacherList.add(new Teacher(1001,"许晓峰","英语", 0, "2000-07-12"));
        teacherList.add(new Teacher(1002,"夏传林","体育", 1, "2000-07-12"));
        teacherList.add(new Teacher(1003,"许晓峰","数学", 0, "2000-07-12"));
        teacherList.add(new Teacher(1004,"夏传林","自然", 1, "2000-07-12"));
        teacherList.add(new Teacher(1005,"夏传林","地理", 1, "2000-07-12"));

    }

    //详情页面查看
    public Teacher teacherView(String realName){

        Teacher teacher = null;
        //list集合中查找元素下标
        for (int i=0;i<teacherList.size();i++){
            if (realName.equals(teacherList.get(i).getRealName())){
                //根据下标获取对象
                teacher = teacherList.get(i);
            }
        }

        //返回查询到的数据
        return teacher;

    }

    //添加、修改 用户名
    public void save(Teacher teacher){

        //若uid为空则添加新用户
        if(teacher.getTeacherId() == null){
            //获取最后一位用户得id号自增
            teacher.setTeacherId(teacherList.get(teacherList.size()-1).getTeacherId()+1);
            //添加新用户
            teacherList.add(teacher);
        }else{//uid不为空 编辑用户信息
            for (int i = 0;i<teacherList.size();i++) {
                //判断修改值是否已存在
                if (teacher.getTeacherId().equals(teacherList.get(i).getTeacherId())){
                    //修改
                    teacherList.set(i,teacher);
                    //结束操作
                    break;
                }
            }
        }
    }

    public Collection<Teacher> getAll(){
        return teacherList;
    }

    public Collection<Teacher> getAll(String username){
        Collection<Teacher> teachers = getAll();

        //不为空
        if( !StringUtils.isEmpty( username )) {
            int count = 0;
            for (Teacher teacher: teachers) {
                //包含则存在
                if ( teacher.getRealName().toUpperCase().contains(  username.toUpperCase() ) ) {
                    count++;
                    //count>1 表示集合至少有一个存在的用户, 否则创建新的集合
                    teachers = count > 1 ? teachers : new ArrayList<Teacher>();
                    teachers.add(teacher);
                }
            }
            if (count==0){
                //没有查询到，返回空集合
                teachers = new ArrayList<Teacher>();
            }
        }

        return teachers;
    }



    //删除用户
    public void delete(Integer teacherId){
        //遍历User数组
        for (int i = 0;i<teacherList.size();i++) {
            //判断需要删除得用户数据下标
            if (teacherId.equals(teacherList.get(i).getTeacherId())){
                //删除数据
                teacherList.remove(i);
            }


        }
    }


    //教师列表

    public List<String> getTeacherName(){
        List<String> teacherName = new ArrayList<>();
        for (int i=0;i<teacherList.size();i++){
            teacherName.add(teacherList.get(i).getRealName());
        }

        return teacherName;
    }


}
