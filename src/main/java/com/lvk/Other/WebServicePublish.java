package com.lvk.Other;

import com.lvk.Service.Impl.WebServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @author: kangkang.lv
 * @date: 18-1-10 下午5:46
 */
public class WebServicePublish {
    public static void main(String[] args) {

        String address = "http://localhost:8989/WS_Service/WebService";
        Endpoint.publish(address,new WebServiceImpl());
        System.out.println("发布WebServiceImpl成功");


    }

}
