/*
package dajie;

import com.beisen.sdk.BeisenException;
import com.beisen.sdk.assessment.Assessment;
import com.beisen.sdk.assessment.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @author: kangkang.lv
 * @date: 17-8-11 上午11:25
 *//*

public class BeisenAssessmentUtil {




    static Map<String,Integer> corpMap = new HashMap<String, Integer>(){{
        put("9100102800000000001",1);   //一个网申对应一个租户
        put("9100102800000000024",2);   //一个网申对应大街租户的多个活动
    }};

    //网申对应多个活动的corp
    static Map<String,Integer[]> corpActivityMap = new HashMap<String, Integer[]>(){{
        put("9100102800000000024",new Integer[]{123,234});
    }};


    public static List<CrAssessmentSubjectVo> getAssessmentSubject(String corpId, int page, int size) {

        return null;
    }

    public static String getTestURLByCorpIdAndWishId(String corpId,Integer activityId,String wishId,String userName){
        Assessment assess = new Assessment();
        AccountToken token = new AccountToken("150200","08a9a55a2d374cdba9bfee237932af46","21cf5bf96557463fbdb79b4e47ac2f6f","yixun@beisen.com");
        TesteeInfoParameterList userList = new TesteeInfoParameterList();
        TesteeInfoParameter p = new TesteeInfoParameter();
        p.name = userName;
        p.email = wishId;
        p.mobile = "";
        p.department = "";
        userList.add(p);

        try {


            ActivityInfo activity = assess.getActivityDetail(token, activityId);


            SimpleDateFormat f =new SimpleDateFormat("yyyy-MM-dd%20hh:mm:ss");
            Date d = new Date();
            Date d1 = new Date(d.getYear(),d.getMonth(),d.getDay(),d.getHours(),d.getMinutes(),d.getSeconds());
            Date d2 = new Date(d.getYear(),d.getMonth(),d.getDay()+7,d.getHours(),d.getMinutes(),d.getSeconds());
            TesteeResult inviteTesteeResult = assess.inviteTestee(token, 359859, f.format(d1), f.format(d2), userList);
            System.out.println(inviteTesteeResult.testee_invite_result_list.size());
            System.out.println(inviteTesteeResult.testee_invite_result_list.get(0).test_url);





        } catch (BeisenException e) {
            e.printStackTrace();
        }



        return null;
    }



}
*/
