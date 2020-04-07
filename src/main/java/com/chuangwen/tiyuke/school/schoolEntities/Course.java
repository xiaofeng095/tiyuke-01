package com.chuangwen.tiyuke.school.schoolEntities;

public class Course {
    private Integer courseId;
    private String courseName;
    private String teacherName;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Course() {
    }

    public Course(Integer courseId, String courseName, String teacherName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
