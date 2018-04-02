package Thread;

/**
 * @author: kangkang.lv
 * @date: 17-2-18 下午5:18
 */
public class ThreadPeo {

    public String name;
    public int time;

    public ThreadPeo(String name,int time) {
        this.name = name;
        this.time = time;
    }
    public void pppp() throws InterruptedException {
        synchronized (name){
            System.out.println("pppp--> 1");
            Thread.currentThread().sleep(time);
            System.out.println("pppp---> 2:"+name+" ,has sleep "+time/1000+"s");
        };
    }

    public static synchronized void printSta() throws InterruptedException {
        System.out.println("printSta---> 1");
        Thread.currentThread().sleep(5000);
        System.out.println("printSta---> 2");
    }

    public synchronized void printName() throws InterruptedException {
        System.out.println("printName---> 1");
        Thread.currentThread().sleep(5000);
        System.out.println("printName---> 2");

    }


    public void setTime(int time) {
        this.time = time;
    }
}
