import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lvk.constant.CustomCorpConstans;
import com.lvk.util.RmDateHelper;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.utils.HttpClientUtils;
import org.junit.Test;
import com.lvk.util.DateUtil;
import org.springframework.web.util.HtmlUtils;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by lvkang on 16-5-5.
 */
public class MyTest {




    public static void main(String[] args) {

    }

    @Test
    public void test61(){
    }


    @Test
    public void test60(){
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            //String str = iterator.next();
            //System.out.println(str);
            //if (str.equals("bb"))iterator.remove();
            if (iterator.next().equals("bb"))iterator.remove();
        }
        System.out.println(list.size());


    }

    @Test
    public void test59(){
        List<String> list1 = new ArrayList<String>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        List<String> list2 = new ArrayList<String>();
        list2.add("cc");
        list2.add("dd");
        list1.retainAll(list2);
        for (String l : list1){
            System.out.println(l);
        }
    }

    @Test
    public void test58(){
        Integer aa = 1;
        Integer bb = 2;
        swap(aa,bb);
        System.out.println("aa: "+aa+" ,bb: "+bb);

    }

    public void swap(Integer a,Integer b){
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

    @Test
    public void test57() throws UnsupportedEncodingException {
        Stu s1 = new Stu();
        s1.setName("a");
        List<Stu> l1 = new ArrayList<Stu>();
        l1.add(s1);
        System.out.println(JSONObject.toJSONString(l1));
        System.out.println(JSONObject.toJSONString(s1));
    }

    @Test
    public void test56(){
        StringBuffer sb = new StringBuffer("122n,344,");
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    @Test
    public void test55() throws UnsupportedEncodingException {
        String email = "215643269@qq.com";
        System.out.println(URLEncoder.encode(email,"UTF-8"));
    }

    @Test
    public void test54(){
        String a = "|SCHOLARSHIP\r|LE\rVEL|RECEIVE_TIME|";

        System.out.println(a.replaceAll("\r",""));
    }

    @Test
    public void test53() throws UnsupportedEncodingException {
        String url = "http%3A%2F%2Fm.dajie.com%2Fats%2Fwish%2Flist%3FcorpId%3D9104102800000000623%26isFromJobsPage%3Dtrue%26fromSource%3D%2Fats%2Fshow%2FjobsListPage%2F2349571";
        System.out.println(URLDecoder.decode(url,"UTF-8"));
    }

    @Test
    public void test52(){
        String jobCode = "JOB002";

        List<Map<String,String>> lm = new ArrayList<Map<String, String>>();
        Map<String,String> m1 = new HashMap<String, String>(){{
            put("key","1");
            put("value","1111");
        }};
        lm.add(m1);
        Map<String,String> m2 = new HashMap<String, String>(){{
            put("key","2");
            put("value","2222");
        }};
        lm.add(m2);
        Map<String,String> m3 = new HashMap<String, String>(){{
            put("key","3");
            put("value","333");
        }};
        lm.add(m3);
        List<String> hideCitys = CustomCorpConstans.wmsjOtherFreeCityHide.get(jobCode);

        if (null != hideCitys) { //JOB009的职位进来会是null
            for (String hideCity : hideCitys) {
                System.out.println("hideCitys.size: "+hideCitys.size()+" ,hideCity :"+hideCity);
                Iterator<Map<String,String>> it=lm.iterator();
                while (it.hasNext()){
                    Map<String,String> map=it.next();
                    System.out.println("before: "+map.get("key")+" ,hideCity: "+hideCity);
                    if( map.get("key").equals(hideCity)){
                        System.out.println("mi: "+map.get("key"));
                        it.remove();
                        System.out.println("after: "+map.get("key"));
                    }

                }

            }
        }
        System.out.println(lm.size());
        /*for (Map<String,String> m : lm){
            String key = m.get("key");
            System.out.println(key);
            if (wmsjOtherFreeCityHide.get(jobCode).contains(key)){
                System.out.println(m.get("value"));

            }
        }*/
    }

    @Test
    public void test51() throws UnsupportedEncodingException {
        String value = "北:京,大_学+";
        value = value.replaceAll("_","&#95;").replaceAll(":","&#58;").replaceAll(",","&#44;");
        value = value.replaceAll("[+]","11111");
        System.out.println(value);
    }

    @Test
    public void test50(){
        String questionChoice = "101_北京大学,102_山东大学,103_清华大学";
        //String questionChoice = "北京大学,山东大学,清华大学";
        String[] choiceArr = questionChoice.split(",");
        for (String choice : choiceArr){
            String[] kv = choice.split("_");
            String option;
            if (kv.length > 1){
                option = "<option value='"+kv[0]+"'>"+kv[1]+"</option>";
            }else {
                option = "<option value='"+kv[0]+"'>"+kv[0]+"</option>";
            }
            System.out.println(option);
        }
    }

    @Test
    public void test49(){
        BigDecimal b1 = new BigDecimal("23.870001");
        b1 = b1.setScale(1,BigDecimal.ROUND_HALF_UP);
        System.out.println(b1);

    }

    @Test
    public void test48(){
        StringBuffer s1 = new StringBuffer("12345");
        StringBuffer s2 = new StringBuffer("12345");
        s1.substring(1);
        s2.deleteCharAt(0);
        System.out.println(s1+","+s2);
    }

    @Test
    public void test47(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("CR_R_PERSONAL_INFO__EMAIL","Email");
        jsonObject.put("CR_R_PERSONAL_INFO__NAME","姓名");
        jsonObject.put("CR_R_EDUCATION__DEGREE","学位");
        jsonObject.put("CR_R_REWARD__FREE7","实习经历");
        jsonObject.put("CR_R_REWARD__FREE9","是否有竞赛获奖");
        String jsonStr = jsonObject.toJSONString();
        System.out.println(jsonStr);

        Map<String,String> map = JSON.parseObject(jsonStr, Map.class);
        System.out.println(map.get("CR_R_PERSONAL_INFO__NAME"));    //获取showName
    }

    @Test
    public void test46(){
        String str1 = "";
        boolean b1 = true;
        StringBuffer str2 = new StringBuffer("");
        Boolean b2 = true;
        t46m(str1,b1,str2,b2);
        System.out.println("str1: "+str1+" ,b1: "+b1+" ,str2: "+str2+" ,b2: "+b2);
    }

    public void t46m(String str1,boolean b1,StringBuffer str2,Boolean b2){
        str1 = "1111";
        b1 = false;
        str2.append("2222");
        b2 = false;
    }

    @Test
    public void test45(){
        Date startTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (startTime != null){
            String startTimeStr = sdf.format(startTime);
            System.out.println(startTimeStr);
        }
    }

    @Test
    public void test44(){
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("a","aa");
        jsonObject.put("id","");*/
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","aa");
        map.put("id",null);
        String result = JSONObject.toJSONString(map,SerializerFeature.WriteMapNullValue);
        //String result = JSON.toJSONString(map);
        System.out.println(result);
    }

    @Test
    public void test43(){
        String json = "{\n" +
                "    \"jobs\": [\n" +
                "        {\n" +
                "            \"address\": \"\",\n" +
                "            \"appNumber\": 0,\n" +
                "            \"apply\": false,\n" +
                "            \"autoReplyFlag\": \"\",\n" +
                "            \"campusStatus\": \"3\",\n" +
                "            \"companyAdminId\": 9100200400000000001,\n" +
                "            \"companyId\": 9100102800000000001,\n" +
                "            \"corpOrgId\": 9005102800000000733,\n" +
                "            \"createTime\": \"2017-06-28\",\n" +
                "            \"education\": \"\",\n" +
                "            \"endtime\": 1501516800000,\n" +
                "            \"freshtime\": 1498638861000,\n" +
                "            \"id\": 9010100100000000145,\n" +
                "            \"importFlag\": \"\",\n" +
                "            \"intime\": 1495439068000,\n" +
                "            \"jobCode\": \"JOB176\",\n" +
                "            \"jobDesc\": \"\",\n" +
                "            \"jobTitle\": \"20170522_1\",\n" +
                "            \"jsonId\": \"9010100100000000145\",\n" +
                "            \"modifyDate\": 1498638861000,\n" +
                "            \"modifyIp\": \"124.127.51.245\",\n" +
                "            \"modifyUserId\": 9100200400000000001,\n" +
                "            \"orgName\": \"南京分行\",\n" +
                "            \"otherPlace\": \"\",\n" +
                "            \"passFlag\": \"1\",\n" +
                "            \"salary\": 0,\n" +
                "            \"scoreRuleId\": 0,\n" +
                "            \"sortNo\": 0,\n" +
                "            \"status\": \"\",\n" +
                "            \"totalCode\": \"00110G\",\n" +
                "            \"tpSubjectId\": \"0\",\n" +
                "            \"type\": \"房地产成本经理/主管\",\n" +
                "            \"usableStatus\": \"1\",\n" +
                "            \"workPlace\": \"北京\",\n" +
                "            \"workType\": \"\",\n" +
                "            \"workYear\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"\",\n" +
                "            \"appNumber\": 0,\n" +
                "            \"apply\": false,\n" +
                "            \"autoReplyFlag\": \"\",\n" +
                "            \"campusStatus\": \"3\",\n" +
                "            \"companyAdminId\": 9100200400000000001,\n" +
                "            \"companyId\": 9100102800000000001,\n" +
                "            \"corpOrgId\": 9005102800000001493,\n" +
                "            \"createTime\": \"2017-05-18\",\n" +
                "            \"education\": \"\",\n" +
                "            \"endtime\": 1501516800000,\n" +
                "            \"freshtime\": 1495098075000,\n" +
                "            \"id\": 9005100100000006808,\n" +
                "            \"importFlag\": \"\",\n" +
                "            \"intime\": 1495098070000,\n" +
                "            \"jobCode\": \"JOB175\",\n" +
                "            \"jobDesc\": \"\",\n" +
                "            \"jobTitle\": \"20170508_1\",\n" +
                "            \"jsonId\": \"9005100100000006808\",\n" +
                "            \"modifyDate\": 1495098075000,\n" +
                "            \"modifyIp\": \"124.127.51.245\",\n" +
                "            \"modifyUserId\": 9100200400000000001,\n" +
                "            \"orgName\": \"南京分行\",\n" +
                "            \"otherPlace\": \"\",\n" +
                "            \"passFlag\": \"1\",\n" +
                "            \"salary\": 0,\n" +
                "            \"scoreRuleId\": 0,\n" +
                "            \"sortNo\": 0,\n" +
                "            \"status\": \"\",\n" +
                "            \"totalCode\": \"00110G\",\n" +
                "            \"tpSubjectId\": \"0\",\n" +
                "            \"type\": \"管理培训生/储备干部\",\n" +
                "            \"usableStatus\": \"1\",\n" +
                "            \"workPlace\": \"北京\",\n" +
                "            \"workType\": \"\",\n" +
                "            \"workYear\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"\",\n" +
                "            \"appNumber\": 0,\n" +
                "            \"apply\": false,\n" +
                "            \"autoReplyFlag\": \"\",\n" +
                "            \"campusStatus\": \"3\",\n" +
                "            \"companyAdminId\": 9100200400000000001,\n" +
                "            \"companyId\": 9100102800000000001,\n" +
                "            \"corpOrgId\": 9005102800000001493,\n" +
                "            \"createTime\": \"2017-05-04\",\n" +
                "            \"education\": \"\",\n" +
                "            \"endtime\": 1501516800000,\n" +
                "            \"freshtime\": 1493889933000,\n" +
                "            \"id\": 9001100100000006295,\n" +
                "            \"importFlag\": \"\",\n" +
                "            \"intime\": 1493889605000,\n" +
                "            \"jobCode\": \"JOB174\",\n" +
                "            \"jobDesc\": \"\",\n" +
                "            \"jobTitle\": \"0504\",\n" +
                "            \"jsonId\": \"9001100100000006295\",\n" +
                "            \"modifyDate\": 1493889933000,\n" +
                "            \"modifyIp\": \"192.168.11.188\",\n" +
                "            \"modifyUserId\": 9100200400000000001,\n" +
                "            \"orgName\": \"南京分行\",\n" +
                "            \"otherPlace\": \"\",\n" +
                "            \"passFlag\": \"1\",\n" +
                "            \"salary\": 0,\n" +
                "            \"scoreRuleId\": 0,\n" +
                "            \"sortNo\": 0,\n" +
                "            \"status\": \"\",\n" +
                "            \"totalCode\": \"00110G\",\n" +
                "            \"tpSubjectId\": \"0\",\n" +
                "            \"type\": \"采购经理/主管\",\n" +
                "            \"usableStatus\": \"1\",\n" +
                "            \"workPlace\": \"北京\",\n" +
                "            \"workType\": \"\",\n" +
                "            \"workYear\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"\",\n" +
                "            \"appNumber\": 0,\n" +
                "            \"apply\": false,\n" +
                "            \"autoReplyFlag\": \"\",\n" +
                "            \"campusStatus\": \"3\",\n" +
                "            \"companyAdminId\": 9100200400000000001,\n" +
                "            \"companyId\": 9100102800000000001,\n" +
                "            \"corpOrgId\": 9005102800000001493,\n" +
                "            \"createTime\": \"2017-04-28\",\n" +
                "            \"education\": \"\",\n" +
                "            \"endtime\": 1501516800000,\n" +
                "            \"freshtime\": 1493367670000,\n" +
                "            \"id\": 9001100100000006293,\n" +
                "            \"importFlag\": \"\",\n" +
                "            \"intime\": 1493366809000,\n" +
                "            \"jobCode\": \"JOB170\",\n" +
                "            \"jobDesc\": \"\",\n" +
                "            \"jobTitle\": \"test\",\n" +
                "            \"jsonId\": \"9001100100000006293\",\n" +
                "            \"modifyDate\": 1493367670000,\n" +
                "            \"modifyIp\": \"192.168.11.188\",\n" +
                "            \"modifyUserId\": 9100200400000000001,\n" +
                "            \"orgName\": \"南京分行\",\n" +
                "            \"otherPlace\": \"\",\n" +
                "            \"passFlag\": \"1\",\n" +
                "            \"salary\": 0,\n" +
                "            \"scoreRuleId\": 0,\n" +
                "            \"sortNo\": 0,\n" +
                "            \"status\": \"\",\n" +
                "            \"totalCode\": \"00110G\",\n" +
                "            \"tpSubjectId\": \"0\",\n" +
                "            \"type\": \"销售代表\",\n" +
                "            \"usableStatus\": \"1\",\n" +
                "            \"workPlace\": \"北京\",\n" +
                "            \"workType\": \"\",\n" +
                "            \"workYear\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"\",\n" +
                "            \"appNumber\": 0,\n" +
                "            \"apply\": false,\n" +
                "            \"autoReplyFlag\": \"\",\n" +
                "            \"campusStatus\": \"3\",\n" +
                "            \"companyId\": 9100102800000000001,\n" +
                "            \"corpOrgId\": 9005102800000000299,\n" +
                "            \"createTime\": \"2017-03-21\",\n" +
                "            \"education\": \"\",\n" +
                "            \"email\": \"ztximu01@126.com\",\n" +
                "            \"endtime\": 1501516800000,\n" +
                "            \"freshtime\": 1490067574000,\n" +
                "            \"id\": 9001100100000006291,\n" +
                "            \"importFlag\": \"\",\n" +
                "            \"intime\": 1490067574000,\n" +
                "            \"jobCode\": \"JOB169\",\n" +
                "            \"jobDesc\": \"岗位职责:\\r\\n1.负责产品的功能测试、验收测试，及时提供测试指导意见。\\r\\n2.制定软件测试计划、编写测试用例； \\r\\n3.构建测试环境，执行软件测试，并撰写测试报告； \\r\\n4.制定和执行自动化测试、性能测试方面的工作。\\r\\n任职资格:\\r\\n1.熟悉测试流程、步骤及规范，精通测试技术；\\r\\n2.能够独立制定测试计划、设计测试方案，编写测试用例及测试报告；\\r\\n3.熟悉bug管理工具，如mantis，bugbase等；bug管理系统 redmine/禪道；\\r\\n4.熟悉oracle，mysql，对plsql使用熟练；\\r\\n6.具有耐心、细致的观察、缜密的逻辑思考能力，工作态度端正；\",\n" +
                "            \"jobTitle\": \"软件测试职位\",\n" +
                "            \"jsonId\": \"9001100100000006291\",\n" +
                "            \"modifyDate\": 1490067574000,\n" +
                "            \"orgName\": \"苏州分行\",\n" +
                "            \"passFlag\": \"1\",\n" +
                "            \"salary\": 0,\n" +
                "            \"scoreRuleId\": 0,\n" +
                "            \"sortNo\": 0,\n" +
                "            \"status\": \"\",\n" +
                "            \"totalCode\": \"00110I\",\n" +
                "            \"type\": \"软件测试\",\n" +
                "            \"usableStatus\": \"1\",\n" +
                "            \"workPlace\": \"苏州\",\n" +
                "            \"workType\": \"\",\n" +
                "            \"workYear\": \"\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"pageSize\": 3,\n" +
                "    \"selectMap\": {\n" +
                "        \"typeSelect\": {\n" +
                "            \"110101\": \"销售代表\",\n" +
                "            \"120401\": \"测试工程师\",\n" +
                "            \"120402\": \"软件测试\",\n" +
                "            \"130102\": \"产品经理/主管\",\n" +
                "            \"210106\": \"房地产成本经理/主管\",\n" +
                "            \"220202\": \"采购经理/主管\",\n" +
                "            \"260201\": \"管理培训生/储备干部\"\n" +
                "        },\n" +
                "        \"orgSelect\": {\n" +
                "            \"00110G\": \"南京分行\",\n" +
                "            \"00110I\": \"苏州分行\",\n" +
                "            \"001104\": \"销售部\",\n" +
                "            \"00110U\": \"北京\",\n" +
                "            \"001102\": \"产品部\",\n" +
                "            \"00110Y\": \"人事部\",\n" +
                "            \"001105\": \"设计部\",\n" +
                "            \"00110W\": \"测试部\"\n" +
                "        },\n" +
                "        \"jobCodeSelect\": {\n" +
                "            \"JOB176\": \"\",\n" +
                "            \"JOB175\": \"\",\n" +
                "            \"JOB174\": \"\",\n" +
                "            \"JOB170\": \"\",\n" +
                "            \"JOB169\": \"\",\n" +
                "            \"JOB167\": \"\",\n" +
                "            \"JOB166\": \"\",\n" +
                "            \"JOB005\": \"\",\n" +
                "            \"JOB004\": \"\",\n" +
                "            \"JOB157\": \"\",\n" +
                "            \"JOB154\": \"\",\n" +
                "            \"JOB142\": \"\",\n" +
                "            \"JOB138\": \"\"\n" +
                "        },\n" +
                "        \"citySelect\": {\n" +
                "            \"110000\": \"北京\",\n" +
                "            \"120000\": \"天津\",\n" +
                "            \"150100\": \"呼和浩特\",\n" +
                "            \"310000\": \"上海\",\n" +
                "            \"320500\": \"苏州\",\n" +
                "            \"500000\": \"重庆\",\n" +
                "            \"510100\": \"成都\",\n" +
                "            \"999999\": \"其它\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray jobs = jsonObject.getJSONArray("jobs");
        System.out.println(jobs.size());
    }

    @Test
    public void test42(){
        String[] ids = new String[1];
        ids[0] = "11";
        ids[1] = "12";
        System.out.println(ids[1]);
    }

    @Test
    public void test41(){
        List<Map<String , Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String,String> m1 = new HashMap<String, String>();
        List<Map<String,String>> l1 = new ArrayList<Map<String, String>>();
        Map<String,String> m2 = new HashMap<String, String>();
        m2.put("m2_1","m2_1_value");
        m2.put("m2_2","m2_2_value");
        Map<String,String> m3 = new HashMap<String, String>();
        m3.put("m3_1","m2_1_value");
        m3.put("m3_2","m2_2_value");
        l1.add(m2);l1.add(m3);
        m1.put("m1_1","m1_1_value");
        m1.put("m1_2","m1_2_value");

        Map<String , Object> mo1 = new HashMap<String, Object>();
        mo1.put("mo1",m1);
        mo1.put("l1",l1);

        mapList.add(mo1);

        System.out.println(JSONObject.toJSONString(mapList));


    }

    @Test
    public void test40(){
        String str = "{\"data\":[{\"apptoken\":\"MTE0OTUxNjE3OTA2ODRiNzY0MDU0MTBmMTcyOTQ2Y2Q0NmQyOTRhY2I0ZjJmOQ==\"}],\"error_code\":\"00\",\"msg\":\"登录成功！\",\"success\":true}";
        JSONObject loginJson = JSON.parseObject(str);
        String appToken = ((JSONObject) loginJson.getJSONArray("data").get(0)).getString("apptoken");


        System.out.println(appToken);
    }

    @Test
    public void test39(){
        int max = 4;
        int step = -1;
        int data = 1;
        for (int i=0;i<10;i++){
            data +=step;
            if (data == 0){
                step = 1;
            }else if (data == max){
                step = -1;
            }
            System.out.println(data);
        }
    }

    @Test
    public void test38(){
        List<String> l = null;
        //List<String> l2 = new ArrayList<String>(Arrays.asList("1","2"));
        //l.addAll(l2);
        //System.out.println(l2.size());
        try {
            for (String s : l){

                    System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(StringUtils.join(e.getStackTrace(),"\n"));
        }
    }

    @Test
    public void test37(){
        Node n3 = new Node(3,null);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);


        Node x = null;
        while (n1 !=null){
            Node temp = new Node(n1.value,null);
            temp.next = x;
            x = temp;
            n1 = n1.next;
        }



        while (x != null){
            System.out.println(x.getValue());
            x = x.next;
        }


    }

    class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    @Test
    public void test36(){
        Thread.currentThread().notify();

        Integer a=127;
        Integer b=127;
        System.out.println(a==b);
    }

    public static List<String> test35(){
        List<String> list = new ArrayList<String>();
        try
        {
            list.add("1");list.add("2");list.add("3");list.add("4");list.add("5");
            list.add("6");list.add("7");list.add("8");list.add("9");
            //list.add("10");
            //list.add("11");
            return list;
        }catch (Exception e){
            System.out.println("exception....");
        }finally {
            System.out.println("finally...");
            list.add("12");
        }
        return list;
    }

    public static int[] test34(){
        int a[] = {0,0};
        try
        {
            return a;
        }catch (Exception e){
            System.out.println("exception....");
        }finally {
            System.out.println("finally...");
            a[0]=100;
        }
        return a;
    }

    public static String test33(){
        String str = "";
        try
        {
            str += "a";
            return str;
        }catch (Exception e){
            System.out.println("exception....");
        }finally {
            System.out.println("finally...");
            str += "ff";
        }
        return str;
    }

    public static int test32(){
        int a = 0;
        try
        {
            return a+=20;
        }catch (Exception e){
            System.out.println("exception....");
        }finally {
            System.out.println("finally...");
            if (a>1){
                System.out.println("finally...a>1");
                a += 100;
            }
        }
        return a;
    }

    @Test
    public void test31(){
        Long l1 = 1111l;
        long l2 = 11211l;
        System.out.println(l1.equals(l2));
    }

    @Test
    public void test30(){
        String[] strs = {"11","22","33","44","55"};
        //strs = Arrays.copyOf(strs,strs.length-1);
        strs = Arrays.copyOfRange(strs,2,strs.length);
        for (String str : strs ){
            System.out.printf(str);
        }
    }

    @Test
    public void test29(){
        List<String> list = Collections.emptyList();
        for (String l : list){
            System.out.println("1");
        }
    }

    @Test
    public void test28(){
        new Thread(){
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str_createtime = sdf.format(new Date());
                System.out.println(str_createtime);
                Timestamp createtime = Timestamp.valueOf(str_createtime);
                System.out.println(createtime);
                try {
                    this.sleep(6000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("getSysTimestamp: "+RmDateHelper.getSysTimestamp().getTime()+" ,createtime: "+createtime.getTime());
                System.out.println("--: "+(RmDateHelper.getSysTimestamp().getTime()-createtime.getTime())/1000);
                if((RmDateHelper.getSysTimestamp().getTime()-createtime.getTime())/1000>5){
                    System.out.println("time out");
                }else {
                    System.out.println("...");
                }
            }
        }.start();
        while (true){

        }
        /*String ss = "3";
        System.out.println(CustomCorpConstans.wmsjOtherFreeCityHide.get("JOB007").contains(ss));*/
    }

    @Test
    //测试转json后的顺序
    public void test27(){
        Map<String,String> map = new LinkedHashMap<String, String>();
        map.put("1","a");map.put("2","b");map.put("3","c");
        map.put("4","d");map.put("5","e");map.put("6","f");
        for (Map.Entry m : map.entrySet()){
            System.out.println("key:"+m.getKey()+",value:"+m.getValue());
        }
        //System.out.println(JSONObject.toJSON(map).toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",map);
        System.out.println(jsonObject.toJSONString());

        System.out.println("jsonArray: " + JSONArray.toJSON(map).toString());

        String ss = "{\"data\":{\"1\":\"a\",\"2\":\"b\",\"3\":\"c\",\"4\":\"d\",\"5\":\"e\",\"6\":\"f\"}}";
        //JSONObject.parse(ss);
        System.out.println("json:"+JSONArray.parse(ss));

    }

    @Test
    public void test26(){
        List<String> list = Collections.EMPTY_LIST;
        for (String l : list){
            System.out.println("1111");
        }
    }

    @Test
    public void test25(){
        Map<String,String> map = new HashMap<String, String>();
        String value = null;
        map.put("11",value);
        System.out.println(map.get("11"));
        map.put("11",map.get("11")+",22");

        System.out.println(map.get("11").contains("ull"));
    }

    @Test
    public void test24(){
        String aa = "123,sdf,fff|";
        String[] aaa = aa.split("\\|");
        System.out.println(aaa[1]);//索引越界
    }

    @Test
    //String,Json,Map 转换
    public void test23(){
        JSONObject json = new JSONObject();
        json.put("key1","value1");
        json.put("key2","value2");
        String jsonStr = json.toJSONString();
        JSONObject json2 = JSONObject.parseObject(jsonStr);
        Map<String,String> map = JSONObject.toJavaObject(json2,Map.class);
        System.out.println(map);
    }

    @Test
    //String转int
    public void test22(){
        String s = "21.5";
        int i = (int)Float.parseFloat(s);
        System.out.println(i);
    }

    @Test
    public void test21() throws ParseException {
        String startDate = null;
        String endDate = null;
        String result = null;
        String graduatedate = "2017";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (graduatedate.length() == 4) {//只有年份
            startDate = graduatedate + "-01-01";
            endDate = graduatedate + "-12-31";
            result = sdf.parse(startDate).getTime()+","+sdf.parse(endDate).getTime();
        } else if (graduatedate.length() == 7 && '-' == (graduatedate.charAt(4))) {//年月
            startDate = graduatedate + "-01";
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(startDate));
            calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));  //设为这个月最后一天
            result = sdf.parse(startDate).getTime()+","+calendar.getTimeInMillis();
        } else if (graduatedate.length() == 10 && '-' == (graduatedate.charAt(4)) && '-' == (graduatedate.charAt(7))) {//年月日
            startDate = graduatedate;
            endDate = graduatedate;
            result = sdf.parse(startDate).getTime()+","+sdf.parse(endDate).getTime();
        }
        System.out.println(result);
    }

    @Test
    //日期计算
    public void test20() throws ParseException {
        String date = "2016-06-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(date));
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));  //设为这个月最后一天
        //calendar.add(calendar.MONTH,1);   //加一个月
        System.out.println("date: "+sdf.format(calendar.getTime())
                +" ,mi: "+calendar.getTimeInMillis());
        System.out.println(sdf.parse(date).getTime());
    }

    @Test
    public void test19(){
        List<Stu> list = new ArrayList<Stu>();
        Stu stu1 = new Stu();
        Stu stu2 = new Stu();
        Stu stu3 = new Stu();
        stu1.setCode("1");
        list.add(stu1);
        stu2.setCode("3");
        list.add(stu2);
        stu3.setCode("2");
        list.add(stu3);
        Collections.sort(list, new Comparator<Stu>() {
            public int compare(Stu o1, Stu o2) {
                Integer a = Integer.parseInt(o1.getCode());
                Integer b = Integer.parseInt(o2.getCode());
                return a.compareTo(b);  // 升序
                // return b.compareTo(a);   // 降序
            }
        });

        for (Stu s : list){
            System.out.println(s.getCode());
        }
    }

    @Test
    //list转数组
    public void test18(){
        List<String> list = new ArrayList<String>();
        list.add("11");
        list.add("22");
        list.add("33");
        String[] ss = list.toArray(new String[0]);
        for (String s: ss){
            System.out.println(s);
        }

    }

    @Test
    //随机字符串
    public void test17(){
        String a = "abcdefghijklmnopqrstuvwxyz0123456789";
        int index = (int)(Math.random()*(a.length()-1));
        System.out.println(index);
        System.out.println(a.charAt(index));
        String str = "";
        int size = 6;
        for (int i=0;i<size;i++){
            index = (int)(Math.random()*(a.length()-1));
            str += a.charAt(index);
        }
        System.out.println(str);
    }

    @Test
    //根据类名反射
    public void test16() throws ClassNotFoundException {
        Stu stu = new Stu();
        Class a =  Class.forName("com.lvk.util.DateUtil");
        Method[] ms = a.getMethods();
        for (Method m : ms){
            System.out.println(m.getName());
        }
    }

    @Test
    public void test15(){
        List<Long> idList = new ArrayList<Long>(Arrays.asList(1l,2l,3l,4l));
        List<Long> rList = new ArrayList<Long>(Arrays.asList(2l,4l,5l,6l,7l,2l));
        idList.removeAll(rList);
        System.out.println(idList);
    }

    @Test
    public void test14(){
        Stu stu1 = new Stu();
        stu1.setName("001");
        Stu stu2 = new Stu();
        stu2.setName("002");
        Stu stu3 = new Stu();
        stu3.setName("003");
        Stu stu4 = new Stu();
        stu4.setName("004");
        Stu stu5 = new Stu();
        stu5.setName("005");
        List<Stu> stus1 = new ArrayList<Stu>();
        stus1.add(stu1);
        stus1.add(stu2);
        stus1.add(stu3);
        stus1.add(stu4);
        stus1.add(stu5);

        for (Stu s : stus1){
            System.out.println(s.getName() + ",");
        }
        System.out.println("---------");

        /*List<Stu> stus2 = new ArrayList<Stu>();
        stus2.add(stu3);
        stus2.add(stu4);

        stus1.removeAll(stus2);
        for (Stu s : stus1){
            System.out.println(s.getName() + ",");
        }
        System.out.println("---------");*/

        Stu stu6 = new Stu();
        stu6 = stu3;
        //stu6.setName("003");
        Stu stu7 = new Stu();
        stu7.setName("004");
        List<Stu> stus3 = new ArrayList<Stu>();
        stus3.add(stu6);
        stus3.add(stu7);
        stus1.removeAll(stus3);
        for (Stu s : stus1){
            System.out.println(s.getName() + ",");
        }


    }

    @Test
    public void test13(){
        String fff = "9004100800000405726,\n" +
                "9005100800000784536,\n" +
                "9005100800000784785";
        String[] strs = fff.split(",");
        for (String str : strs){
            System.out.println(str.trim());
        }
    }


    @Test
    //获取前一年第一天的时间
    public void test12(){
        // 创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();
        // 或者用 Date 来初始化 Calendar 对象
        calendar.setTime(new Date());
        int lastYear = calendar.get(Calendar.YEAR)-1;
        String fromTime = lastYear + "-01-01 00:00:00";
        System.out.println(fromTime);
    }

    @Test
    //List合并
    public void test11(){
        List<Integer> list01 = new ArrayList<Integer>();
        List<Integer> list02 = new ArrayList<Integer>();
        list01.add(1);
        list01.add(2);
        list01.add(3);
        list02.add(6);
        list02.add(5);
        list01.addAll(list02); //顺序将保留
        System.out.println("end");
    }

    @Test
    //map排序
    public void test10(){
        List<Map.Entry<String,String>> mappingList = null;
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","1111");
        map.put("2","2222");
        map.put("3","3333");
        map.put("4","4444");
        for (Map.Entry<String,String> m : map.entrySet()){
            System.out.println(m.getKey()+","+m.getValue());
        }

        mappingList = new ArrayList<Map.Entry<String,String>>(map.entrySet());

        Collections.sort(mappingList, new Comparator<Map.Entry<String,String>>(){
            public int compare(Map.Entry<String,String> mapping1,Map.Entry<String,String> mapping2){
                return mapping1.getKey().compareTo(mapping2.getKey());
            }
        });
        for (Map.Entry<String,String> mapp : mappingList){
            System.out.println(mapp.getKey());
        }


    }

    @Test
    //父子级
    public void test09(){

        Stu s01 = new Stu();
        Stu s02 = new Stu();
        Stu s03 = new Stu();
        Stu s04 = new Stu();
        Stu s05 = new Stu();
        Stu s06 = new Stu();

        s01.setName("s001");
        s01.setCode("co1");
        s01.setParent("GUD");

        s02.setName("s002");
        s02.setCode("co2");
        s02.setParent("co1");
        s03.setName("s003");
        s03.setCode("co3");
        s03.setParent("co2");
        s05.setName("s005");
        s05.setCode("co5");
        s05.setParent("co2");
        s06.setName("s006");
        s06.setCode("co6");
        s06.setParent("co5");

        s04.setName("s004");
        s04.setCode("co4");
        s04.setParent("GUD");
        List<Stu> list = new ArrayList<Stu>();
        list.add(s01);
        list.add(s02);
        list.add(s03);
        list.add(s04);
        list.add(s05);
        list.add(s06);
        ttt(list);

        return;
    }

    public List<Stu> ttt(List<Stu> list){
        List<Stu> resultList = new ArrayList<Stu>();
        Map<String,Stu> map = getStuMap(list);
        for (Stu sss:list){
            String parentCode = sss.getParent();
            if (map.containsKey(parentCode)){ //判断此stu是否是顶级
                Stu stuFromMap = map.get(parentCode);
                stuFromMap.getChildren().add(map.get(sss.getCode()));
            }else{
                resultList.add(sss);
            }
        }
        return resultList;
    }

    public Map<String,Stu> getStuMap(List<Stu> list){
        Map<String,Stu> map = new HashMap<String, Stu>();
        for (Stu st : list){
            map.put(st.getCode(),st);
        }
        return map;
    }



    @Test
    public void test08(){
        boolean b = true;
        chgB(b);
        System.out.println(b);
    }
    public void chgB(boolean b){
        b = false; //只改变了引用
    }

    @Test
    //枚举
    public void test07(){
        System.out.println(Gender.MAN.getValue());
    }


    public enum Gender{
        MAN("1"), WOMEN("0");

        private final String value;

        Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Test
    public void test06(){
        int a = (int)(1+Math.random()*10);
        System.out.println(a);
    }

    @Test
    public void test05(){
/*        ICrSearchInfoService crSearchInfoService = (ICrSearchInfoService) CtsServiceContext.getInstance().getService("crSearchInfoService");
        List<Long> wishList = crSearchInfoService.generateAllWishIds(1, 10);
        System.out.println(wishList.size());*/
    }

    @Test
    public void test04(){
        //Date date = new Date(System.currentTimeMillis());
        //System.out.println(date.getTime());
        Date d1 = new Date();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d2 = new Date();

        System.out.println(DateUtil.getSecSpan(d1, d2));
    }

    @Test
    public void finalTest(){
        final List<String> ff = new ArrayList<String>();
        doForList(ff);
        for (int i=0;i<ff.size();i++){
            System.out.println(ff.get(i));
        }
    }

    public void doForList(List<String> list){
        list.add("aa");
        list.add("bb");
    }

    @Test
    public void test03(){
        List<String> list = new ArrayList<String>();
        ll(list);
        System.out.println(list.get(0));
    }

    public void ll(List<String> list){
        list.add("eeeeeee");
    }

    @Test
    public void test02(){
        Map<String,List<Stu>> map = new HashMap<String, List<Stu>>();
        List<Stu> list;
        for (int j=0;j<11;j++){
            int i = j/2;
            Stu st = new Stu();
            st.setName("name" + i);
            st.setAge(i);
            if (map.containsKey(i+"")){
                list = map.get(i+"");
                list.add(st);
            }else {
                list = new ArrayList<Stu>();
                list.add(st);
                map.put(i+"",list);
            }
        }
        System.out.println(map.size());
        for (Map.Entry<String,List<Stu>> entry : map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }



    @Test
    public void test01(){
        Map<String,List<Stu>> map = new HashMap<String, List<Stu>>();
        for (int j=0;j<11;j++){
            List<Stu> list;
            int i = j/2;
            Stu st = new Stu();
            st.setName("name" + i);
            st.setAge(i);
            list = map.get(i+"");
            if(null==list || list.size()==0){
                list = new ArrayList<Stu>();
                list.add(st);
                map.put(i+"",list);
            }else {
                list.add(st);
            }
        }
        System.out.println(map.size());
        for (Map.Entry<String,List<Stu>> entry : map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }


}

class Stu{
    private String name;
    private int age;
    private Boolean sex;
    private String code;
    private String parent;
    private List<Stu> children = new ArrayList<Stu>();

    public Boolean isSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Stu> getChildren() {
        return children;
    }

    public void setChildren(List<Stu> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

