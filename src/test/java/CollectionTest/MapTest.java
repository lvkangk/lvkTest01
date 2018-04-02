package CollectionTest;

import org.junit.Test;

import java.util.*;

/**
 * @author: kangkang.lv
 * @date: 17-2-22 下午2:15
 */
public class MapTest {

    @Test
    public void test01(){
        Map<String,String> map = new HashMap<String, String>(4);
        map.put("1","11");
        map.put("2","22");
        map.put("3","33");
        map.put("4","ee");

        map.put("5","44");
        map.put("6","55");
        map.put("7","44");
        map.put("8","55");

        map.get("2");
        map.remove("3");
    }

}
