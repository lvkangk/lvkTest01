package com.lvk.constant;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: kangkang.lv
 * @date: 16-12-12 下午6:44
 */
public final class CustomCorpConstans {

    public static final long dajieceshiCorpId = 9100102800000000001l;   //dajieceshi
    //public static final long wmsjCorpId = 9104102800000000468l; //改为完美世界
    public static final long wmsjCorpId = 2100102800000000002l; //完美世界沙盒
    public static final long CWF2017CorpId = 9104102800000000372l;  //埃森哲(CWF2017)


    public static final Map<String, String> wmsjJobCodeMap = new LinkedHashMap<String, String>();
    static {
        wmsjJobCodeMap.put("JOB001","运营类");
        wmsjJobCodeMap.put("JOB002","设计类");
        wmsjJobCodeMap.put("JOB003","策划类");
        wmsjJobCodeMap.put("JOB004","媒体类");
        wmsjJobCodeMap.put("JOB005","技术类");
        wmsjJobCodeMap.put("JOB006","产品类");
        wmsjJobCodeMap.put("JOB007","测试类");
        wmsjJobCodeMap.put("JOB008","编导类");
        wmsjJobCodeMap.put("JOB009","职能类");
    }

    //完美世界其他信息页职位编号对应要隐藏的项
    public static final Map<String, String> wmsjOtherFreeHide = new LinkedHashMap<String, String>();

    static {
        wmsjOtherFreeHide.put("JOB001","|FREE4|FREE5|");
        wmsjOtherFreeHide.put("JOB002","|FREE1|FREE2|FREE5|");
        wmsjOtherFreeHide.put("JOB003","|FREE1|FREE2|FREE4|");
        wmsjOtherFreeHide.put("JOB004","|FREE1|FREE2|FREE4|FREE5|");
        wmsjOtherFreeHide.put("JOB005","|FREE1|FREE2|FREE4|");
        wmsjOtherFreeHide.put("JOB006","|FREE1|FREE2|FREE4|FREE5|");
        wmsjOtherFreeHide.put("JOB007","|FREE1|FREE2|FREE4|");
        wmsjOtherFreeHide.put("JOB008","|FREE1|FREE2|FREE4|FREE5|");
        wmsjOtherFreeHide.put("JOB009","|FREE1|FREE2|FREE3|FREE4|FREE5|");
    }

    //完美世界其他信息页职位编号对应要隐藏的面试城市的选项
    public static final Map<String, List<String>> wmsjOtherFreeCityHide = new LinkedHashMap<String, List<String>>();

    static {
        wmsjOtherFreeCityHide.put("JOB001",Arrays.asList("2","4","5","6","7","8","9","10","11","12","13"));
        wmsjOtherFreeCityHide.put("JOB002",Arrays.asList("2","3","9","10","11","12","13"));
        wmsjOtherFreeCityHide.put("JOB003",Arrays.asList("3","4","5","6","8","12","13"));
        wmsjOtherFreeCityHide.put("JOB004",Arrays.asList("2","3","4","5","6","7","9","10","11","12","13"));
        wmsjOtherFreeCityHide.put("JOB005",Arrays.asList("3","4","5","6","8","12","13"));
        wmsjOtherFreeCityHide.put("JOB006",Arrays.asList("3","4","5","6","7","8","9","10","11"));
        wmsjOtherFreeCityHide.put("JOB007",Arrays.asList("2","3","4","5","6","7","8","11","12","13"));
        wmsjOtherFreeCityHide.put("JOB008",Arrays.asList("2","3","4","5","6","7","8","9","10","11","12"));
    }

}
