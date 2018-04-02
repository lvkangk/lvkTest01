package JVM;

/**
 *  虚拟机栈OOM测试
 *  -Xss128K
 *
 * @author: kangkang.lv
 * @date: 17-7-12 下午4:36
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        }catch (Throwable e){
            System.out.println("stackLength: "+javaVMStackSOF.stackLength);
            throw e;
        }

    }

}
