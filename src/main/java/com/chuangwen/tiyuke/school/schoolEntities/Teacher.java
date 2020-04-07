package com.chuangwen.tiyuke.school.schoolEntities;

public class Teacher {
    private Integer teacherId;
    private String realName;
    private String specialty;
    private Integer gender;
    private String birthday;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Teacher() {
    }

    public Teacher(Integer teacherId, String realName,String specialty, Integer gender, String birthday) {
        this.teacherId = teacherId;
        this.realName = realName;
        this.specialty = specialty;
        this.gender = gender;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", realName='" + realName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + birthday +
                '}';
    }
}
