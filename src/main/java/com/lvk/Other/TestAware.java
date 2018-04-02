package com.lvk.Other;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: kangkang.lv
 * @date: 17-3-28 下午7:20
 */
@Component
public class TestAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void test01(){
        TestOther testOther = (TestOther) applicationContext.getBean("testOther");
        testOther.me2("testAware");
    }
}
