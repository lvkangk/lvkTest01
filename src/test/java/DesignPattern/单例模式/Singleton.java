package DesignPattern.单例模式;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author: kangkang.lv
 * @date: 17-2-17 下午3:47
 */
public class Singleton {


    @Test
    public void test02(){

    }

    @Test
    //反射攻击单例模式
    public void test01() throws Exception{
        Singleton1 s1 = Singleton1.getInstance();
        Constructor<Singleton1> constructor = Singleton1.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton1 s2 = constructor.newInstance();
        System.out.println(s1 == s2);   //false
    }


}

/**
 * 懒汉
 */
class Singleton1{
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance(){
        if (instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

}

/**
 * 饿汉
 */
class Singleton2{
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

/**
 * 懒汉，线程安全
 * 但是多线程处理时,只有一个线程能访问这个方法,效率会很低
 */
class Singleton3{
    private static Singleton3 instance;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}

/**
 * 双重校验锁
 */
class Singleton4{
    private static Singleton4 instance;
    private Singleton4() {
    }

    public static Singleton4 getInstance(){
        if (instance == null){
            //只有未创建实例时候才触发锁
            synchronized(Singleton4.class){
                if (instance == null){  //做这次判断是为了避免多个线程同时触发锁,会各new一次
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

}
