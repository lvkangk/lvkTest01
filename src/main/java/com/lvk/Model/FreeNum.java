package com.lvk.Model;

import java.util.Date;

public class FreeNum {
    private Integer id;

    private Integer tableCode;

    private String tableName;

    private Integer num;

    private Date createTime;

    private Date updateTime;

    public Integer getTableCode() {
        return tableCode;
    }

    public void setTableCode(Integer tableCode) {
        this.tableCode = tableCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FreeNum{" +
                "id=" + id +
                ", tableCode=" + tableCode +
                ", tableName='" + tableName + '\'' +
                ", num=" + num +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}