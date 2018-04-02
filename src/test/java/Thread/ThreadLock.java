package Thread;

/**
 *
 * 类锁和对象锁不会产生竞争，二者的加锁方法不会相互影响。
 * 私有锁和对象锁也不会产生竞争，二者的加锁方法不会相互影响。
 * synchronized直接加在实例方法上和synchronized(this)都是对当前对象加锁，二者的加锁方法够成了竞争关系
 *
 *
 * @author: kangkang.lv
 * @date: 17-2-20 下午4:09
 */
public class ThreadLock {

    private Object object;

    //类锁
    public static synchronized void method1(){
        //.....
    }
    //类锁
    public void method2(){
        synchronized (ThreadLock.class){
           //.....
        }
    }

    //对象锁
    public synchronized void method3(){
        //.....
    }
    //对象锁
    public void method4(){
        synchronized (this){
            //.....
        }
    }

    //私有锁
    public void method5(){
        synchronized (object){
            //.....
        }
    }

}
