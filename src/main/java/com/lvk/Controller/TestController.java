package com.lvk.Controller;

import com.lvk.Other.TestAware;
import com.lvk.Service.TestService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lvkang on 16-5-18.
 */
@Controller
//@RequestMapping("/lvkk")
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private TestAware testAware;

    @RequestMapping("/t1")
    @ResponseBody
    public Map<Integer,String> t1(){
        Map<Integer,String> result = new LinkedHashMap<>();
        result.put(1,"111");
        result.put(2,"222");
        result.put(3,"333");
        result.put(4,"444");
        result.put(5,"555");
        return result;
    }

    @RequestMapping("/kk")
    public String getMenuBox(){
        testService.te();
        //testAware.test01();
        System.out.println("22222");
        return "test";
    }


}
