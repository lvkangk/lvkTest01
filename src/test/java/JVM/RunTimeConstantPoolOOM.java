package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 *  运行时常量池导致的内存移除异常
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author: kangkang.lv
 * @date: 17-7-13 下午2:21
 */
public class RunTimeConstantPoolOOM {

    public static void main(String[] args) {
        //使List保持这常量池引用,避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        //10M的PermSize在integer范围内足够产生OOM了
        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
