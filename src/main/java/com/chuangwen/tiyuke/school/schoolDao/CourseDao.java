package com.chuangwen.tiyuke.school.schoolDao;

import com.chuangwen.tiyuke.school.schoolEntities.Course;
import com.chuangwen.tiyuke.school.schoolEntities.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CourseDao {

    private static List<Course> courseList = null;


    static {
        courseList = new ArrayList<>();
        courseList.add(new Course(1001,"太极", "夏传林"));
        courseList.add(new Course(1002,"游泳", "夏传林"));
        courseList.add(new Course(1003,"羽毛球", "夏传林"));
        courseList.add(new Course(1004,"花式篮球", "夏传林"));

    }
    //详情页面查看
    public Course courseView(String courseName){

        Course course = null;
        //list集合中查找元素下标
        for (int i=0;i<courseList.size();i++){
            if (courseName.equals(courseList.get(i).getCourseName())){
                //根据下标获取对象
                course = courseList.get(i);
            }
        }

        //返回查询到的数据
        return course;

    }

    //添加、修改 用户名
    public void save(Course course){

        //若uid为空则添加新用户
        if(course.getCourseId() == null){
            //获取最后一位用户得id号自增
            course.setCourseId(courseList.get(courseList.size()-1).getCourseId()+1);
            //添加新用户
            courseList.add(course);
        }else{//uid不为空 编辑用户信息
            for (int i = 0;i<courseList.size();i++) {
                //判断修改值是否已存在
                if (course.getCourseId().equals(courseList.get(i).getCourseId())){
                    //修改
                    courseList.set(i,course);
                    //结束操作
                    break;
                }
            }
        }
    }

    public Collection<Course> getAll(){
        return courseList;
    }

    public Collection<Course> getAll(String courseName){
        Collection<Course> courses = getAll();

        //不为空
        if( !StringUtils.isEmpty( courseName )) {
            int count = 0;
            for (Course course: courses) {
                //包含则存在
                if ( course.getCourseName().toUpperCase().contains(  courseName.toUpperCase() ) ) {
                    count++;
                    //count>1 表示集合至少有一个存在的用户, 否则创建新的集合
                    courses = count > 1 ? courses : new ArrayList<Course>();
                    courses.add(course);
                }
            }
            if (count==0){
                //没有查询到，返回空集合
                courses = new ArrayList<Course>();
            }
        }

        return courses;
    }



    //删除用户
    public void delete(Integer teacherId){
        //遍历User数组
        for (int i = 0;i<courseList.size();i++) {
            //判断需要删除得用户数据下标
            if (teacherId.equals(courseList.get(i).getCourseId())){
                //删除数据
                courseList.remove(i);
            }


        }
    }

}
