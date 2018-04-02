package com.lvk.Other;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: kangkang.lv
 * @date: 17-3-23 下午7:28
 */
@Component
public class TestOther implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        ///System.out.println("postProcessBeforeInitialization"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessAfterInitialization"+beanName);
        return bean;
    }

    public void me(){
        System.out.println("other method...");
    }

    public void me2(String from){
        System.out.println("other me2... from: "+from);
    }

}
