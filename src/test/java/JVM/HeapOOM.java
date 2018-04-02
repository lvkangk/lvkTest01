package JVM;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Java堆内存溢出异常测试
 * -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author: kangkang.lv
 * @date: 17-7-11 下午3:07
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }



    static class OOMObject{

    }

}
