package com.chuangwen.tiyuke.school.schoolController;

import com.chuangwen.tiyuke.entities.User;
import com.chuangwen.tiyuke.school.schoolDao.TeacherDao;
import com.chuangwen.tiyuke.school.schoolEntities.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class TeacherController {
    Logger logger = LoggerFactory.getLogger(getClass());

        @Autowired
        TeacherDao teacherDao;

    @GetMapping("/teacher_list")
    public String getUserList(Map<String,Object> map, @RequestParam(value = "realName",required = false)String realName){

        logger.info("供应商查询。。。"+realName);

        Collection<Teacher> teacherList = teacherDao.getAll(realName);
        map.put("teacherList",teacherList);
        map.put("teacherSearch",realName);
        return "school/manteacher/list.html";
    }
    @GetMapping("/teacher_view/{realName}")
    public String getUserView(@PathVariable("realName") String realName,
                              @RequestParam(value = "type",defaultValue = "view")String type,Map<String,Object> map){
        logger.info("查看"+realName+"详情");

        Teacher teacher = teacherDao.teacherView(realName);

        map.put("teacherInfo",teacher);
        return "school/manteacher/"+type;

    }

    @GetMapping("/teacher_add")
    public String toAddUserPage(){

        return "school/manteacher/add.html";
    }

    @PostMapping("/teacher_add")
    public String addUser(Teacher teacher){
        logger.info("添加"+teacher+"数据");
        teacherDao.save(teacher);
        return "redirect:/teacher_list";
    }

    @PutMapping("/teacher_update")
    public String userUpdate(Teacher teacher){

        logger.info("修改"+teacher+"信息");

        teacherDao.save(teacher);
        return "redirect:/teacher_list";
    }

    @DeleteMapping("/teacher_delete/{teacherId}")
    public String deleteUser(@PathVariable("teacherId")Integer teacherId){
        logger.info("删除"+teacherId);
        teacherDao.delete(teacherId);
        return "redirect:/teacher_list";
    }
}
