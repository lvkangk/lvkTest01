package HttpTest;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: lvkang
 * Date: 16-8-8 下午4:55
 */
public class ApaHttp {

    private static final String success = "200. OK";

    @Test
    public void t1() throws JSONException {
        String url = "http://test.rcxue.com/open/v2/get_jwt_token/";
        JSONObject param = new JSONObject();
        param.put("username","schneider@rcxue.com");
        param.put("password","Schneider123");
        doPost(param,url,null);
    }

    @Test
    public void t2() throws JSONException {
        String url = "http://localhost:8080/test/t4";
        JSONObject param = new JSONObject();
        param.put("username","schneider@rcxue.com");
        param.put("password","Schneider123");
        doPost(param,url,null);
    }




    public static JSONObject doPost(JSONObject json,String url,String token) {
        String resultUrl = null;
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json.toString(),"UTF-8");//指定编码格式
            s.setContentEncoding("UTF-8");
            //s.setContentType("application/x-www-form-urlencoded");
            //s.setContentType("text/json");//发送json数据需要设置contentType
            post.setEntity(s);
            /*post.getParams().setParameter("username","schneider@rcxue.com");
            post.getParams().setParameter("password","Schneider123");*/
            if (StringUtils.isNotEmpty(token)){
                post.addHeader("Postman-Token", token);
            }
            post.addHeader("Content-Type", "application/json");
            //client = getHttpClient(client);
            HttpResponse res = client.execute(post);


            if (res != null) {
                if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                    HttpEntity entity = res.getEntity();
                    String result = EntityUtils.toString(entity);
                   /* response = new JSONObject(result);
                    System.out.println(response);*/
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            //log.error("getTestURLByEmail doPost Exception:");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
       //log.debug("getTestURLByEmail doPost end");
        return null;
    }






}
