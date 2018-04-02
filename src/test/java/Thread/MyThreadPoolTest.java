package Thread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lvkang on 16-5-3.
 */
public class MyThreadPoolTest {

    @Test
    //理解线程池中各个参数
    public void test01(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,8,200, TimeUnit.MILLISECONDS
                ,new ArrayBlockingQueue<Runnable>(5));

        for (int i=1;i<=12;i++){
            MyTask task = new MyTask(i);
            executor.execute(task);
            System.out.println("正在运行的线程数量："+executor.getPoolSize()+";正在等待的线程数量："
                    +executor.getQueue().size()+";已经执行完的线程数量："+executor.getCompletedTaskCount());
        }

        executor.shutdown();
        try {
            Thread.currentThread().sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyTask implements Runnable{

    private int num;

    public MyTask(int i) {
        this.num = i;
    }

    @Override
    public void run() {
        System.out.println("task:-->"+num);
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task:-->"+num+"执行完毕");
    }
}
