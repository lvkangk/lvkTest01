package com.lvk.util;

import java.util.Date;

/**
 * Created by lvkang on 16-5-9.
 */
public class DateUtil {
    public static long getDaySpan(Date startDate, Date endDate) {
        return startDate != null && endDate != null?(endDate.getTime() - startDate.getTime()) / 86400000L:0L;
    }

    public static long getSecSpan(Date startDate, Date endDate) {
        return startDate != null && endDate != null?(endDate.getTime() - startDate.getTime())/1000 :0L;
    }
}
