package SpringTest;

import org.junit.Test;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * @author: kangkang.lv
 * @date: 17-3-2 下午8:03
 */
public class IocTest {

    @Test
    public void test02(){
//        ApplicationContext;
       // FileSystemXmlApplicationContext;
//        BeanDefinitionReader;
//        DefaultResourceLoader;
        //ClassPathXmlApplicationContext

    }

    @Test
    public void test01(){
        //1.创建一个IoC配置文件的抽象资源,这个抽象资源包含里BeanDefinition的定义信息
        ClassPathResource resource = new ClassPathResource("bean.xml");
        //2.创建一个BeanFactory,这里使用DefaultListableBeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //3.创建一个载入BeanDefinition的读取器,这里使用XmlBeanDefinitionReader来载入XML文件形式的BeanDefinition,
        //通过一个回调配置给BeanFactory
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        //4.从定义好的资源位置读入配置信息,具体的解析过程由XmlBeanDefinitionReader来完成.
        reader.loadBeanDefinitions(resource);
        //完成整个载入和注册Bean定义后,需要的IoC容器就建立起来了.
        //这个时候就可以直接使用Ioc容器了
    }

}
