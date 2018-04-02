/*
 * 系统名称:单表模板 --> rc.campus
 * 
 * 文件名称: com.dajie.cts.cr.corp.crcorp.util --> ICrCorpConstants.java
 * 
 * 功能描述:
 * 
 * 版本历史: 2012-05-29 01:27:33 创建1.0.0版 (李美丰)
 *  
 */

package com.lvk.constant;

/**
 * 
 * @author lingjun.xiong
 * @version 1.0.0
 * @since 1.0.0
 */

public interface CrCorpConstants {


    //申请表大项对应表名
    public static String[] BIG_ITEM_TABLE_NAMES={"CR_R_PERSONAL_INFO",
    	"CR_R_EDUCATION",
    	"CR_R_LANGUAGE",
    	"CR_R_REWARD",
    	"CR_R_INTERNSHIP",
    	"CR_R_PROJECT",
    	"CR_R_FAMILY",
    	"CR_R_OTHERS",
    	"CR_R_ACCESSORY"};

	public static enum BIG_ITEM_TABLE_NAMES_ENUM {
		CR_R_EDUCATION,CR_R_LANGUAGE,CR_R_REWARD,CR_R_INTERNSHIP,
		CR_R_PROJECT,CR_R_FAMILY,CR_R_OTHERS,CR_R_ACCESSORY
	}

	public static enum TABLE_FREE_ENUM {
		tb_free_1,tb_free_2,tb_free_3,tb_free_4
	}




}