package Thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by lvkang on 16-5-9.
 */
public class ExecutorServiceTest {

    @Test
    public void test05(){
        Thread t = new Thread(new Deamon());
        t.setDaemon(true);
        t.start();
        try {
            TimeUnit.SECONDS.sleep(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Deamon implements Runnable{
        private Thread[] t = new Thread[10];
        @Override
        public void run() {
            for (int i = 0; i<t.length;i++){
                t[i] = new Thread(new DaemonSpawn());
                System.out.println("t[" + i + "].isDaemon--" + t[i].isDaemon());
                t[i].start();
            }
        }
    }

    class DaemonSpawn implements Runnable{
        @Override
        public void run() {
            while (true){
                Thread.yield();
            }
        }
    }





    @Test
    public void test04(){
        ExecutorService executor = Executors.newCachedThreadPool(new DaemonThreadFactory());
    }

    public class DaemonThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    }

/*    @Test
    public void test03() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        //for (int i=0;i<6;i++){
            executor.execute(new MyRun02(Thread.MAX_PRIORITY));
            executor.execute(new MyRun02(Thread.MIN_PRIORITY));
        //}
        executor.shutdown();
        TimeUnit.SECONDS.sleep(15l);
    }
    class MyRun02 implements Runnable{

        private int i;

        public MyRun02(int i){
            this.i = i;
        }

        @Override
        public void run() {
            Thread.currentThread().setPriority(i);
            try {
                TimeUnit.SECONDS.sleep(3l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);

        }
    }*/



    @Test
    //创建一个任务，它将睡眠1至10秒的随机数之间，然后显示它的睡眠时间并退出。创建并运行一定数量的这种任务。
    public void test02(){
        ExecutorService executer = Executors.newFixedThreadPool(5);
        for (int i=0;i<7;i++){
            executer.execute(new MyRun01(i));
        }
        executer.shutdown();
        try {
            TimeUnit.SECONDS.sleep(15l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyRun01 implements Runnable{

        private int id;
        MyRun01(int id){
            this.id = id;
        }

        @Override
        public void run() {
            long time = (long)(1+Math.random()*10);
            try {
                TimeUnit.SECONDS.sleep(time);
                System.out.println("Thread--"+id+":Sleep--"+time+"s");
                //Thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test01(){
        ExecutorService executer = Executors.newFixedThreadPool(8);

        Future<String> future = executer.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                //System.out.println("StringResult1111");
                return "StringResult1111";
            }
        });

        try {
            String str = future.get();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
