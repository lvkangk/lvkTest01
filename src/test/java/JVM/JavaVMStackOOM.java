package JVM;

/**
 * 创建线程导致内存溢出异常
 *  -Xss20M
 *  未成功输出OOM结果,职一直运行,idea卡顿
 *
 * @author: kangkang.lv
 * @date: 17-7-12 下午4:53
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }
}
