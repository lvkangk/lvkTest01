import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: kangkang.lv
 * @date: 17-1-10 下午5:49
 */
public class CalendarTest {

    @Test
    public void test08() throws ParseException {
        Date date1 = new Date();
        long time1 = date1.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = sdf.parse("2017-12-11");
        long time2 = date2.getTime();
        System.out.println((time1-time2)/(1000*60*60*24)+1);
    }

    @Test
    public void test07() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //sdf.format(new Date());
        System.out.println(sdf.parse(sdf.format(new Date())));
    }

    /**
     * 获取今天周几
     */
    @Test
    public void test06() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2017-11-11");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(i);
    }

    @Test
    public void test05() throws Exception{
        String startTime = "2016-10-12";
        String endTimes = "2016-12-01";
        String targetTime = "2016-10-31";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        /*Date startDate = sdf.parse(startTime);
        Date endDate = sdf.parse(endTime);
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startDate);
        end.setTime(endDate);
        System.out.println(start.compareTo(end));*/



        Date beginTime = sdf.parse(startTime);
        Date endTime = sdf.parse(endTimes);
        Date lastDate = sdf.parse(targetTime);
        if(endTime.after(lastDate)){
            System.out.println("用targetTime");
            endTime = lastDate;
        }

        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.setTime(beginTime);
        calendar_1.add(Calendar.MONTH,1);
        Calendar calendar_3 = Calendar.getInstance();
        calendar_3.setTime(beginTime);
        calendar_3.add(Calendar.MONTH,3);
        Calendar calendar_end = Calendar.getInstance();
        calendar_end.setTime(endTime);
        if(calendar_end.compareTo(calendar_1) < 0){
            System.out.println("小于1");
        }else if(calendar_end.compareTo(calendar_3) > 0){
            System.out.println("大于3");
        }else {
            System.out.println("1-3");
        }
    }

    @Test
    public void test04() throws Exception{
        String startTime = "2015-10-12";
        String endTimes = "2016-12-01";
        String targetTime = "2016-10-31";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        /*Date startDate = sdf.parse(startTime);
        Date endDate = sdf.parse(endTime);
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startDate);
        end.setTime(endDate);
        System.out.println(start.compareTo(end));*/



        long beginTime = sdf.parse(startTime).getTime();
        long endTime = sdf.parse(endTimes).getTime();
        long lastDate = sdf.parse(targetTime).getTime();
        if(endTime > lastDate){
            System.out.println("用targetTime");
            endTime = lastDate;
        }

        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.setTimeInMillis(beginTime);
        calendar_1.add(Calendar.MONTH,1);
        Calendar calendar_3 = Calendar.getInstance();
        calendar_3.setTimeInMillis(beginTime);
        calendar_3.add(Calendar.MONTH,3);
        Calendar calendar_end = Calendar.getInstance();
        calendar_end.setTimeInMillis(endTime);
        if(calendar_end.compareTo(calendar_1) < 0){
            System.out.println("小于1");
        }else if(calendar_end.compareTo(calendar_3) > 0){
            System.out.println("大于3");
        }else {
            System.out.println("1-3");
        }




    }

    @Test
    //时间加3个月
    public void test03(){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.MONTH,calendar.get(calendar.MONTH) + 3);
        System.out.println(df.format(calendar.getTime()));
    }

    @Test
    public void test02(){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = df.format(date);
        System.out.println("today is : "+today);
        String lastDay = df.format(new Date(date.getTime()-1000*60*60*24));
        System.out.println("lastDay is : "+lastDay);
    }


    @Test
    //获取上一年
    public void test01(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int lastYear = calendar.get(Calendar.YEAR)-1;
        System.out.println("lastYear is : "+lastYear);
    }
}
