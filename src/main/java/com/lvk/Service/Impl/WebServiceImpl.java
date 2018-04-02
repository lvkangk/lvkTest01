package com.lvk.Service.Impl;

import com.lvk.Service.WebService;

/**
 * @author: kangkang.lv
 * @date: 18-1-10 下午5:44
 */
@javax.jws.WebService
public class WebServiceImpl implements WebService {
    @Override
    public String sayHello(String name) {
        System.out.println("Hello, "+name);
        name += " success!";
        return name;
    }
}
