package com.lvk.Model;


import com.lvk.enums.ItemDataTypeEnum;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangxu.qiu on 2015/1/19.
 */
public class CrAppFormItem implements Serializable {

    private static final long serialVersionUID = -5457150295907231843L;
    private Long id;
    private Long bigItemId;
    private String itemName;
    private String remark;
    private ItemDataTypeEnum itemDataType;
    private String itemContent;
    private boolean isCheck;
    private Integer textNum;
    private int orderNo;
    private String showName;
    private String fieldName;
    private boolean isShow;
    private Date createTime;
    private String code;
    private Date modifyDate;
    private String modifyIp;
    private Long modifyUserId;
    private String fieldNameCode;
    private boolean isCustom;
    private boolean isModify;
    private Date ts;
    /**
     * 1 置顶 0 不置顶 默认0*
     */
    private boolean isTop;

    public CrAppFormItem() {
    }

    public boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(boolean isTop) {
        this.isTop = isTop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBigItemId() {
        return bigItemId;
    }

    public void setBigItemId(Long bigItemId) {
        this.bigItemId = bigItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ItemDataTypeEnum getItemDataType() {
        return itemDataType;
    }

    public void setItemDataType(ItemDataTypeEnum itemDataType) {
        this.itemDataType = itemDataType;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getTextNum() {
        return textNum;
    }

    public void setTextNum(Integer textNum) {
        this.textNum = textNum;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
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

    public String getCreateTimeStr() {
        if (createTime == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(createTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyIp() {
        return modifyIp;
    }

    public void setModifyIp(String modifyIp) {
        this.modifyIp = modifyIp;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getFieldNameCode() {
        return fieldNameCode;
    }

    public void setFieldNameCode(String fieldNameCode) {
        this.fieldNameCode = fieldNameCode;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean isCustom) {
        this.isCustom = isCustom;
    }

    public boolean isModify() {
        return isModify;
    }

    public void setModify(boolean isModify) {
        this.isModify = isModify;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CrAppFormItem{");
        sb.append("id=").append(id);
        sb.append(", bigItemId=").append(bigItemId);
        sb.append(", itemName='").append(itemName).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", itemDataType=").append(itemDataType);
        sb.append(", itemContent='").append(itemContent).append('\'');
        sb.append(", isCheck=").append(isCheck);
        sb.append(", textNum=").append(textNum);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", showName='").append(showName).append('\'');
        sb.append(", fieldName='").append(fieldName).append('\'');
        sb.append(", isShow=").append(isShow);
        sb.append(", createTime=").append(createTime);
        sb.append(", code='").append(code).append('\'');
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyIp='").append(modifyIp).append('\'');
        sb.append(", modifyUserId=").append(modifyUserId);
        sb.append(", fieldNameCode='").append(fieldNameCode).append('\'');
        sb.append(", isCustom=").append(isCustom);
        sb.append(", isModify=").append(isModify);
        sb.append(", ts=").append(ts);
        sb.append('}');
        return sb.toString();
    }
}
