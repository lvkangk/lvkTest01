package ProxyAndReflectTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: kangkang.lv
 * @date: 17-3-30 下午4:37
 */
public class ReflectTest {

    @Test
    public void test02() throws Exception {
        Class<?> c = Class.forName("ProxyAndReflectTest.Human");
        Method[] methods = c.getMethods();
        Constructor<?>[] constructors = c.getConstructors();
        for (Method method:methods){
            System.out.println(method.toString());
        }
        System.out.println("---------------");
        for (Constructor constructor:constructors){
            System.out.println(constructor.toString());
        }
        System.out.println("---------------");
        Human h = (Human) constructors[0].newInstance("Jack",12);
        Method printName = c.getMethod("printname");
        printName.invoke(h);


    }

    @Test
    public void test01(){
        Human h1 = new Human("Jack",24);
        Class c1 = h1.getClass();
        Field[] fields = c1.getFields();
        Method[] methods = c1.getDeclaredMethods();
        for (Field field:fields){
            System.out.println("fieldName: "+field.getName()+" ,type: "+field.getType());
        }
        for (Method method : methods){
            System.out.println("methodName: "+method.getName()+" ,returnType: "+method.getReturnType());
        }
    }


}

class Human{
    public Human(String name,int age) {
        this.age = age;
        this.name = name;
    }

    public int age;
    public String name;

    public void printAge() {
        System.out.println("age is: "+age);
    }

    public void printName() {
        System.out.println("name is: "+name);
    }

    private int mmm(){
        return 0;
    }

}

