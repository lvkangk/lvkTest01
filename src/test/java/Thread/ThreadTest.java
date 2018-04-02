package Thread;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by lvkang on 16-5-3.
 */
public class ThreadTest {

    public volatile int inc = 0;

    public static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public void increase(){
        inc++;
    }

    @Test
    //ThreadLocal
    public void threadTest08() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(i)).start();
        }
        Thread.currentThread().sleep(10000l);
    }

    static class MyThread implements Runnable {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("线程" + index + "的初始value:" + value.get());
            for (int i = 0; i < 10; i++) {
                value.set(value.get() + i);
            }
            System.out.println("线程" + index + "的累加value:" + value.get());
        }
    }

    @Test
    public void threadTest07() throws InterruptedException {
        final ThreadTest t1 = new ThreadTest();
        for (int i=0;i<100;i++){
            new Thread(){
                @Override
                public void run() {
                    for (int j=0;j<1000;j++){
                        t1.increase();
                        System.out.println("threadName: "+Thread.currentThread().getName()
                                +" ,inc: "+t1.inc);
                    }
                }
            }.start();
        }
        int count = 0;
        Thread.sleep(6000l);
        System.out.println("count----> "+Thread.activeCount()+" ,inc: "+t1.inc);
        /*while (Thread.activeCount()>1) {
            Thread.yield();
            count++;
            System.out.println(count+" :inc= " + t1.inc);
        }*/


    }

    @Test
    public void threadTest06() throws Exception {
        ThreadPoolExecutor executer = new ThreadPoolExecutor(2,3,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        final ThreadPeo tp = new ThreadPeo("tp1",10000);
        executer.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tp.pppp();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        executer.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tp.printName();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));


        System.out.println("正在运行的线程数量："+executer.getPoolSize()
                +" ,正在等待的线程数量："+executer.getQueue().size());
        Thread.currentThread().sleep(30000);
    }

    @Test
    public void threadTest05() throws Exception {
        final ThreadPeo tp1 = new ThreadPeo("tp1",5000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThreadPeo.printSta();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        final ThreadPeo tp2 = new ThreadPeo("tp1",5000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThreadPeo.printSta();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //final ThreadPeo tp2 = new ThreadPeo("tp2",1000);


        Thread.currentThread().sleep(30000);
    }

    @Test
    public void threadTest04() throws Exception {
        //final ThreadPeo tp1 = new ThreadPeo("tp1");
        for (int i=0;i<2;i++){
            final ThreadPeo tp = new ThreadPeo("tp"+i,1000);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        tp.pppp();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.currentThread().sleep(15000);
        System.out.println("end");
    }

    @Test
    public void threadTest03(){
        new Thread(){
            @Override
            public void run() {
                for (int j=0;j<10;j++){
                    System.out.println(getName()+":"+j);
                }
            }
        }.start();
        for (int j=0;j<1000;j++){
            System.out.println(",,,,,,,,"+j);
        }
    }

    @Test
    public void threadTest01(){
        Thread thread = new MyThread01();
        thread.start();
        for (int j=0;j<100;j++){
            System.out.println(",,,,,,,,"+j);
        }
    }

    @Test
    public void threadTest02(){
        Runnable ru = new MyRunnable01();
        Thread t = new Thread(ru);
        Thread t2 = new Thread(ru);
        t.start();
        t2.start();
        for (int j=0;j<10;j++){
            System.out.println(",,,,,,,,"+j);
        }
        for (int k=0;k<10;k++){
        }
    }


}


class MyThread01 extends Thread{

    @Override
    public void run() {
        for (int i=0;i<10 ; i++){
            System.out.println(getName()+":"+i);
        }
    }
}

class MyRunnable01 implements Runnable {

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            System.out.println("run:"+i);
        }
    }
}
