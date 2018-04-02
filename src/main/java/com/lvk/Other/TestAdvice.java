package com.lvk.Other;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: kangkang.lv
 * @date: 17-3-31 下午4:56
 */
public class TestAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println("TestAdvice before......");
    }
}
