package com.lvk.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by jiangxu.qiu on 2015/1/19.
 */
public class CrAppFormBigItem implements Serializable {

    private static final long serialVersionUID = -5284601976092668578L;
    private Long id;
    private String itemName;
    private boolean isMust;
    private int iOrder;
    private Long corpId;
    private String tableName;
    private boolean isShow;
    private Date createTime;
    private String showName;
    private String remark;
    private Date ts;
    private List<CrAppFormItem> subList;

    public CrAppFormBigItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isMust() {
        return isMust;
    }

    public void setMust(boolean isMust) {
        this.isMust = isMust;
    }

    public int getiOrder() {
        return iOrder;
    }

    public void setiOrder(int iOrder) {
        this.iOrder = iOrder;
    }

    public Long getCorpId() {
        return corpId;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public List<CrAppFormItem> getSubList() {
        return subList;
    }

    public void setSubList(List<CrAppFormItem> subList) {
        this.subList = subList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CrAppFormBigItem{");
        sb.append("id=").append(id);
        sb.append(", itemName='").append(itemName).append('\'');
        sb.append(", isMust=").append(isMust);
        sb.append(", iOrder=").append(iOrder);
        sb.append(", corpId=").append(corpId);
        sb.append(", tableName='").append(tableName).append('\'');
        sb.append(", isShow=").append(isShow);
        sb.append(", createTime=").append(createTime);
        sb.append(", showName='").append(showName).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", ts=").append(ts);
        sb.append('}');
        return sb.toString();
    }
}
