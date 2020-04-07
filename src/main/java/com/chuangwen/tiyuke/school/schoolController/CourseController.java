package com.chuangwen.tiyuke.school.schoolController;

import com.chuangwen.tiyuke.school.schoolDao.CourseDao;
import com.chuangwen.tiyuke.school.schoolDao.TeacherDao;
import com.chuangwen.tiyuke.school.schoolEntities.Course;
import com.chuangwen.tiyuke.school.schoolEntities.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CourseDao courseDao;

    @Autowired
    TeacherDao teacherDao;

    @GetMapping("/course_list")
    public String getUserList(Map<String,Object> map, @RequestParam(value = "courseName",required = false)String courseName){

        logger.info("供应商查询。。。"+courseName);

        Collection<Course> courseList = courseDao.getAll(courseName);
        map.put("courseList",courseList);
        map.put("courseSearch",courseName);
        return "school/mancourse/list.html";
    }
    @GetMapping("/course_view/{courseName}")
    public String getUserView(@PathVariable("courseName") String courseName,
                              @RequestParam(value = "type",defaultValue = "view")String type,Map<String,Object> map){
        logger.info("查看"+courseName+"详情");

        Course course = courseDao.courseView(courseName);

        map.put("courseInfo",course);

        Collection<Teacher> teacherName = teacherDao.getAll();
        map.put("teacherName",teacherName);

        return "school/mancourse/"+type;

    }

    @GetMapping("/course_add")
    public String toAddUserPage(Map<String,Object> map){

        Collection<Teacher> teacherName = teacherDao.getAll();
        map.put("teacherName",teacherName);
        return "school/mancourse/add.html";
    }

    @PostMapping("/course_add")
    public String addCourse(Course course){
        logger.info("添加"+course+"数据");
        courseDao.save(course);
        return "redirect:/course_list";
    }

    @PutMapping("/course_update")
    public String UpdateCourse(Course course){

        logger.info("修改"+course+"信息");

        courseDao.save(course);
        return "redirect:/course_list";
    }

    @DeleteMapping("/course_delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId")Integer courseId){
        logger.info("删除"+courseId);
        courseDao.delete(courseId);
        return "redirect:/course_list";
    }
}
