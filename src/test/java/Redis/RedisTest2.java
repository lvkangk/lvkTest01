package Redis;

import com.alibaba.fastjson.JSONObject;
import com.lvk.Model.CrAppFormBigItem;
import com.lvk.Model.CrAppFormItem;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: kangkang.lv
 * @date: 16-11-25 下午4:12
 */
public class RedisTest2 {
    private Jedis jedis;

    @Before
    public void setup(){
        jedis = new Jedis("127.0.0.1",6379);
        //jedis.auth("admin");

    }

    @Test
    public void test02(){
        Map<String,String> map = jedis.hgetAll("map1");
        String beanStr = map.get("bean");
        //System.out.println(JSONObject.parseObject(beanStr,List.class));
        //List<CrAppFormBigItem> list = JSONObject.parseObject(beanStr,List.class);
        List<CrAppFormBigItem> list = JSONObject.parseArray(beanStr, CrAppFormBigItem.class);
        List<CrAppFormItem> ll = list.get(0).getSubList();
        System.out.println(ll);
       // System.out.println(map);
    }

    @Test
    public void test01(){
        Map<String,String> map = new HashMap<String, String>();
        List<CrAppFormItem> list = new ArrayList<CrAppFormItem>();
        List<CrAppFormBigItem> bigList = new ArrayList<CrAppFormBigItem>();
        CrAppFormBigItem bigItem1 = new CrAppFormBigItem();
        CrAppFormBigItem bigItem2 = new CrAppFormBigItem();
        bigItem2.setId(10001111l);
        CrAppFormItem appFormItem1 = new CrAppFormItem();
        appFormItem1.setId(1l);
        CrAppFormItem appFormItem2 = new CrAppFormItem();
        appFormItem2.setId(2l);
        list.add(appFormItem1);list.add(appFormItem2);
        bigItem1.setSubList(list);
        bigList.add(bigItem1);bigList.add(bigItem2);
        map.put("corpId", "9001");
        map.put("bean", JSONObject.toJSONString(bigList));
        jedis.hmset("map1",map);
        //System.out.println(list);
    }
}
