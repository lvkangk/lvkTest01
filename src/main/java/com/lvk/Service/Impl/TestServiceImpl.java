package com.lvk.Service.Impl;

import com.lvk.Other.TestOther;
import com.lvk.Service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: kangkang.lv
 * @date: 17-3-23 下午2:14
 */
@Service("testService")
public class TestServiceImpl implements TestService,InitializingBean,DisposableBean{

    @Autowired
    private TestOther testOther;

    /*public TestOther getTestOther() {
        return testOther;
    }

    public void setTestOther(TestOther testOther) {
        this.testOther = testOther;
    }*/

    public void start(){

        System.out.println("TsetService start");
    }

    public void end(){
        System.out.println("TsetService end");
    }

    public void te(){
        System.out.println("TsetService te");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /*new Thread(){
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(5000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thrrrrrrrr");
            }
        }.start();
        testOther.me();
        System.out.println("afterPropertiesSet");*/

    }
}
