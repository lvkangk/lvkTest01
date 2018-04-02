package Redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: kangkang.lv
 * @date: 16-10-29 下午1:47
 */
public class RedisTest {
    private Jedis jedis;

    @Before
    public void setup(){
        jedis = new Jedis("127.0.0.1",6379);
        //jedis.auth("admin");

    }

    /**
     * redis存储字符串
     */
    @Test
    public void test1(){
        //向key-->name中放入了value-->xinxin
        jedis.set("name","lvkang");
        System.out.println(jedis.get("name"));

        //拼接
        jedis.append("name"," is me");
        System.out.println(jedis.get("name"));

        //删除某个键
        jedis.del("name");
        System.out.println(jedis.get("name"));

        //设置多个键值对
        jedis.mset("name","jack","age","22");
        jedis.incr("age");
        System.out.println(jedis.get("name")+"--"+jedis.get("age"));
    }

    /**
     * redis操作Map
     */
    @Test
    public void test2(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","mike");
        map.put("password","pss");
        map.put("qq", "222111");
        jedis.hmset("user1", map);
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("nawme","11112e");
        map1.put("password","wwwww");
        map1.put("qee","2145");
        jedis.hmset("user1", map1); //覆盖了之前的
        jedis.hset("user1","rrr","rvalue");
        System.out.println(jedis.hgetAll("user1"));
        //取值时,第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，
        //后面的key可以跟多个，是可变参数
        List<String> list = jedis.hmget("user1","name","password","qq");
        System.out.println(list);

        jedis.hdel("user1","qq");
        System.out.println(jedis.hmget("user1","qq"));  //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user1"));    //输出user1的属性个数
        System.out.println(jedis.exists("user1"));//存在,返回true
        System.out.println(jedis.hkeys("user1"));//输出user1中所有的key值
        System.out.println(jedis.hvals("user1"));//返回map对象中的所有value
    }

    /**
     * Redis操作List
     */
    @Test
    public void test3(){
        jedis.del("javaF");
        jedis.lpush("javaF","Struts");
        jedis.lpush("javaF","Spring");
        jedis.lpush("javaF","Mybatis");
        //参数:第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("javaF",0,-1));

        jedis.del("javaF");
        jedis.rpush("javaF", "Struts");
        jedis.rpush("javaF", "Spring");
        jedis.rpush("javaF", "Mybatis");
        System.out.println(jedis.lrange("javaF",0,-1));

        jedis.del("javaF");
        jedis.lpush("javaF","Struts");
        jedis.lpush("javaF","Spring");
        jedis.lpush("javaF","Mybatis");
        jedis.lpush("javaF","ssh");
        jedis.lpush("javaF","ssh");
        //移除javaF中值为ssh的
        //第二个参数: =0 移除所有=某值的
        //          >0 从头到尾移除
        //          <0 从尾到头移除
        Long rmNum = jedis.lrem("javaF", 0, "ssh");
        System.out.println(rmNum);
        System.out.println(jedis.lrange("javaF",0,-1));
        String rp = jedis.rpop("javaF");
        System.out.println("rp="+rp+" ,"+jedis.lrange("javaF",0,-1));
        String lp = jedis.lpop("javaF");
        System.out.println("lp="+lp+" ,"+jedis.lrange("javaF",0,-1));



    }

    /**
     * Redis操作Set
     */
    @Test
    public void test4(){
        jedis.sadd("set1","aa");
        jedis.sadd("set1","bb");
        jedis.sadd("set1","cc");
        jedis.sadd("set1","dd");
        jedis.sadd("set1","ee");
        //移除
        jedis.srem("set1","cc");
        System.out.println(jedis.smembers("set1"));         //获取所有加入的value
        System.out.println(jedis.sismember("set1","bb"));   //判断 bb 是否是user集合的元素
        System.out.println(jedis.srandmember("set1"));      //随机取一个值
        System.out.println(jedis.scard("set1"));            //返回元素个数
    }

    @Test
    public void test5() {
        jedis.del("numList");
        jedis.lpush("numList", "3");
        jedis.lpush("numList", "3");
        jedis.rpush("numList", "4");
        jedis.lpush("numList","12");
        jedis.rpush("numList", "1");
        System.out.println(jedis.lrange("numList",0,-1));
        System.out.println(jedis.sort("numList"));          //排序输出
        System.out.println(jedis.lrange("numList",0,-1));System.out.println(jedis.lrange("numList",0,-1));
    }

    @Test
    public void test6(){
        //测试中文
        jedis.set("name","康康");
        System.out.println(jedis.get("name"));
    }

}
