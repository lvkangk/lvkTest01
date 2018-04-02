package Thread;

/**
 * @author: kangkang.lv
 * @date: 17-3-13 下午2:36
 */
public class testThread  extends Thread implements Runnable{
    @Override
    public void run() {
        super.run();
        System.out.println("sdsfdfsd");
    }

    public static void main(String[] args) {

        new testThread().start();
    }
}