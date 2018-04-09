package JVM;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kangkang.lv
 * @date: 17-7-13 下午2:30
 */
public class JVMTest {

    private static final int _1MB = 1024 * 1024;

    /**
     * JDK1.6中 intern()方法会把首次遇到的字符串实例复制到永久代中,返回的也是永久代这个字符串实例的引用
     * 而StringBuilder创建的字符串实例在Java堆上
     * JDK1.7中的intern()不会再复制实例只是在常量池中记录首次出现的实例引用,
     * 因此intern()返回的引用和由StringBuilder创建的那个字符串实例是同一个
     */
    @Test
    public void test01(){
        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }


    /**
     *
     * 新生代MinorGC
     *
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+UseSerialGC 用Serial垃圾收集器
     */
    @Test
    public void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[1 * _1MB];
        allocation2 = new byte[1 * _1MB];
        allocation3 = new byte[3 * _1MB];
        allocation4 = new byte[4 * _1MB];   //出现一次MinorGC
    }

    /**
     * 大对象直接进入老年代
     *
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728(令大于这个设置值的对象直接在老年代分配)
     */
    @Test
    public void testPretenureSizeThreshold(){
        byte[] allocation1, allocation2;

        allocation1 = new byte[5 * _1MB];
        allocation2 = new byte[1 * _1MB];
    }

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     * -XX:+UseSerialGC
     */
    @Test
    public void testTenuringThreshold(){
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB / 4];
        //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    static class OOMObject{
        public byte[] placeholder = new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i=0;i<num;i++){
            //稍作延时
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception{
        fillHeap(1000);
    }
}
