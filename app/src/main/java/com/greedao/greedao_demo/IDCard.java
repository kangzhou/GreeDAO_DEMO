package com.greedao.greedao_demo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * by zhouk
 */
@Entity
public class IDCard {
    @Id
    Long id;//主键
    String name;//姓名
    @Unique
    String employeeNo;//工号
    @Generated(hash = 1031286940)
    public IDCard(Long id, String name, String employeeNo) {
        this.id = id;
        this.name = name;
        this.employeeNo = employeeNo;
    }
    @Generated(hash = 1276747893)
    public IDCard() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmployeeNo() {
        return this.employeeNo;
    }
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }
    }
