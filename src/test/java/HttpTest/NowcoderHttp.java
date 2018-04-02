package HttpTest;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: kangkang.lv
 * @date: 17-8-9 下午4:39
 */
public class NowcoderHttp {

    public static List<NameValuePair> makeSign(List<NameValuePair> nvps,String apiKey,String secretKey,String path){
        final long timestamp = System.currentTimeMillis() / 1000;
        nvps.add(new BasicNameValuePair("api_key", apiKey));
        nvps.add(new BasicNameValuePair("timestamp", String.valueOf(timestamp)));
        nvps.add(new BasicNameValuePair("path", path));
        Collections.sort(nvps, new Comparator<NameValuePair>() {
            @Override
            public int compare(NameValuePair o1, NameValuePair o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        List<String> pairs = new ArrayList<String>();
        for (NameValuePair nvp : nvps) {
            pairs.add(nvp.getName() + "=" + nvp.getValue());
        }

        String unSignString = StringUtils.join(pairs, '&') + secretKey;
        String sign = DigestUtils.md5Hex(unSignString);
        nvps.add(new BasicNameValuePair("sign", sign));
        return nvps;
    }

    /**
     * 获取某客户的所有试卷
     * @throws java.io.IOException
     */
    @Test
    public void t5() throws IOException {
        final String apiBaseUrl = "http://d.api.nowcoder.com";
        final String allPapersPath = "/v1/papers/oid-";
        String ownerId = "300575";
        final String apiKey = "DAJIE_001";
        final String secretKey = "DAJIE_001";
        final String path = apiBaseUrl+allPapersPath+ownerId;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps = makeSign(nvps,apiKey,secretKey,path);
        StringBuffer param = new StringBuffer();
        for (NameValuePair nvp : nvps) {
            param.append("&");
            param.append(nvp.getName() + "=" + nvp.getValue());

        }
        String url = path + "?" + param.substring(1,param.length());
        System.out.println("url: "+url);
        HttpGet get = new HttpGet(url);
        HttpResponse res = httpClient.execute(get);

        System.out.println(res);
        if (res != null) {
            System.out.println(res.getStatusLine().getStatusCode());
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
                String resStr = EntityUtils.toString(entity);
                   /* response = new JSONObject(result);
                    System.out.println(response);*/
                System.out.println(resStr);

                com.alibaba.fastjson.JSONObject json = JSON.parseObject(resStr);
                com.alibaba.fastjson.JSONArray jsonArray = json.getJSONObject("data").getJSONArray("datas");
                com.alibaba.fastjson.JSONArray result = new com.alibaba.fastjson.JSONArray();
                for (int i=0;i<jsonArray.size();i++){
                    com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject) jsonArray.get(i);
                    com.alibaba.fastjson.JSONObject resultData = new com.alibaba.fastjson.JSONObject();
                    resultData.put("id",jsonObject.get("id"));
                    resultData.put("paperName",jsonObject.get("paperName"));
                    result.add(resultData);
                }
                System.out.println(result.toJSONString());
            }

        }
    }

    /**
     * 获取客户在牛客的账户id
     * @throws IOException
     */
    @Test
    public void t4() throws IOException {
        //final String apiBaseUrl = "https://api.nowcoder.com";
        final String apiBaseUrl = "http://d.api.nowcoder.com";
        final String selfPath = "/v1/users/self";
        //final String allPapersPath = "/v1/papers/oid-";
        final String apiKey = "DAJIE_001";
        final String secretKey = "DAJIE_001";
        final String path = apiBaseUrl+selfPath;
        // String ownerId = "";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps = makeSign(nvps,apiKey,secretKey,path);
        for (NameValuePair nvp : nvps){
            System.out.println(nvp.getName()+":"+nvp.getValue());
        }
        StringBuffer param = new StringBuffer();
        for (NameValuePair nvp : nvps) {
            param.append("&");
            param.append(nvp.getName() + "=" + nvp.getValue());

        }

        String url = path + "?" + param.substring(1,param.length());
        System.out.println("url: "+url);
        HttpGet get = new HttpGet(url);
        HttpResponse res = httpClient.execute(get);

        System.out.println(res);
        if (res != null) {
            System.out.println(res.getStatusLine().getStatusCode());
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
                String resStr = EntityUtils.toString(entity);
                   /* response = new JSONObject(result);
                    System.out.println(response);*/
                System.out.println(resStr);




            }
        }
        //id:300575
    }

    /**
     * 牛客网对接test
     */
    @Test
    public void t3() throws IOException {
        //final String apiBaseUrl = "https://api.nowcoder.com";
        final String apiBaseUrl = "http://d.api.nowcoder.com";
        final String apiPathTemplate = "/v1/papers/%d/test_users";
        final long paperId = 1446838;

        final String apiKey = "DAJIE_001";
        final String secretKey = "DAJIE_001";
        final long timestamp = System.currentTimeMillis() / 1000;
        final String path = String.format(apiPathTemplate, paperId);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(apiBaseUrl + path);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("key", "key5"));
        /*nvps.add(new BasicNameValuePair("key", "key1"));
        nvps.add(new BasicNameValuePair("key", "key2"));
        nvps.add(new BasicNameValuePair("key", "key4"));
        nvps.add(new BasicNameValuePair("key", "key5"));*/
        nvps.add(new BasicNameValuePair("name", "明5"));
        /*nvps.add(new BasicNameValuePair("name", "杰克"));
        nvps.add(new BasicNameValuePair("name", "汤姆"));
        nvps.add(new BasicNameValuePair("name", "明4"));
        nvps.add(new BasicNameValuePair("name", "明5"));*/
        nvps = makeSign(nvps,apiKey,secretKey,path);

        for (NameValuePair nvp : nvps){
            System.out.println(nvp.getName()+":"+nvp.getValue());
        }

        //URL Encode
        post.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));

    /*
    body的内容
    api_key=apiKey&key=key1&key=key2&key=key3&
    name=%E6%9D%B0%E5%85%8B&name=%E6%B1%A4%E5%A7%86
    &name=%E6%98%8E&path=%2Fv1%2Fpapers%2F100&timestamp=1458378903
    &sign=ea5bcc1ecb1132d3b1cfec6a0fae3c2a
    */
        HttpResponse res = httpClient.execute(post);

        System.out.println(res);
        if (res != null) {
            System.out.println(res.getStatusLine().getStatusCode());
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(entity);
                   /* response = new JSONObject(result);
                    System.out.println(response);*/
                com.alibaba.fastjson.JSONObject json = JSON.parseObject(result);
                com.alibaba.fastjson.JSONArray jsonArray = json.getJSONArray("data");
                com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject) jsonArray.get(0);

                System.out.println(jsonObject.getString("testUrl"));
            }
        }
    }

}
