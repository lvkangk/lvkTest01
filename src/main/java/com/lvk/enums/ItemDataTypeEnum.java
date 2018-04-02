package com.lvk.enums;

/**
 * Created by jiangxu.qiu on 2015/1/19.
 */
public enum ItemDataTypeEnum {
    /**单行文本*/
    TEXT(1),
    /**多行文本*/
    TEXT_AREA(2),
    /**单选框*/
    RADIO(3),
    /**多选框*/
    CHECK_BOX(4),
    /**下拉框*/
    SELECT(5),
    /**日期*/
    DATE(6),
    /**城市*/
    CITY(7),
    /**学校*/
    SCHOOL(8),
    /**专业*/
    MAJOR(9),
    /**行业*/
    INDUSTRY(10),
    /**上传文件*/
    UPLOAD(11);


    private final int code;

    private ItemDataTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ItemDataTypeEnum parse(int code) {
        for (ItemDataTypeEnum type : ItemDataTypeEnum.values()) {
            if (code == type.getCode()) {
                return type;
            }
        }
        return null;
    }
}
