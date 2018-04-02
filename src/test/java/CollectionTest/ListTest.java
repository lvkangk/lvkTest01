package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: kangkang.lv
 * @date: 17-2-18 下午2:12
 */
public class ListTest {



    @Test
    public void test02(){
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();
        list1.get(0);
        list1.remove(0);
        list1.iterator();
        list2.get(0);
        list2.remove(0);
        list2.iterator();

    }

    /**
     * 使用迭代器遍历时可删除list中的项
     */
    @Test
    public void test01(){
        List<String> list = new ArrayList<String>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if("33".equals(iterator.next())){
                iterator.remove();
            }
            /*String next = iterator.next();
            System.out.println(next);*/
        }
        iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(list.size());
    }

}
