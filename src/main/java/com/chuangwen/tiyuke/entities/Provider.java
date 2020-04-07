package com.chuangwen.tiyuke.entities;

import java.util.Date;

/**
 * 供应商实体类
 * @Title: Provider
 * @Description: com.mengxuegu.springboot.entities
 * @Auther: www.mengxuegu.com
 * @Version: 1.0
 */

public class Provider {
    private Integer pid;
    //供应商编码
    private String providerCode;
    //供应商名称
    private String providerName;
    //地区
    private String providerDistrict;
    //城市
    private String providerCity;
    //联系人
    private String people;
    //联系电话
    private String phone;
    //联系地址
    private String address;
    //传真
    private String fax;
    //描述
    private String describe;
    // 创建时间
    private Date createDate;

    public Provider() {
    }

    public Provider(Integer pid, String providerCode, String providerName,String providerDistrict,String providerCity, String people, String phone, String address, String fax, String describe) {
        this.pid = pid;
        this.providerCode = providerCode;
        this.providerName = providerName;
        this.providerDistrict = providerDistrict;
        this.providerCity = providerCity;
        this.people = people;
        this.phone = phone;
        this.address = address;
        this.fax = fax;
        this.describe = describe;
        this.createDate = new Date();
    }


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderDistrict() {
        return providerDistrict;
    }

    public void setProviderDistrict(String providerDistrict) {
        this.providerDistrict = providerDistrict;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date date) {
        this.createDate = date;
    }


    public String getProviderCity() {
        return providerCity;
    }

    public void setProviderCity(String providerCity) {
        this.providerCity = providerCity;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "pid=" + pid +
                ", providerCode='" + providerCode + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerDistrict='" + providerDistrict + '\'' +
                ", providerCity='" + providerCity + '\'' +
                ", people='" + people + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                ", describe='" + describe + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
