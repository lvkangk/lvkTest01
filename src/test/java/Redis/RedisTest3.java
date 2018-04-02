package Redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: kangkang.lv
 * @date: 17-8-3 下午2:56
 */
public class RedisTest3 {

    private Jedis jedis;

    @Before
    public void setup(){
        jedis = new Jedis("127.0.0.1",6379);
        //jedis.auth("admin");
    }

    @Test
    public void test01(){
        jedis.hset("recommendCode","AAA",5+"");

        System.out.println(jedis.hincrBy("recommendCode","AAA",-2l));
        System.out.println(jedis.hget("recommendCode","BBB"));
    }

}
