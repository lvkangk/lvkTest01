package ProxyAndReflectTest;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author: kangkang.lv
 * @date: 17-2-15 下午4:27
 */
public class ProxyTest {

    @Test
    public void Test02(){
        RealPeople realPeople = new RealPeople();
        People proxyPeople = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new DynamicProxyPeople(realPeople));
        proxyPeople.doSomething();
    }

    @Test
    public void Test01(){
        People p = new RealPeople();
        ProxyPeople proxyPeople = new ProxyPeople(p);
        proxyPeople.doSomething();
    }
}

interface People{
    void doSomething();
}

class RealPeople implements People{

    @Override
    public void doSomething() {
        System.out.println("do do do");
    }
}

class ProxyPeople implements People{

    ProxyPeople(People people){
        this.people = people;
    }

    private People people;

    @Override
    public void doSomething() {
        System.out.println("Before...");
        people.doSomething();
        System.out.println("After...");
    }
}

/**
 * 动态代理
 */
class DynamicProxyPeople implements InvocationHandler{
    private Object proxied;

    public DynamicProxyPeople(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before....");
        return method.invoke(proxied,args);
    }
}
