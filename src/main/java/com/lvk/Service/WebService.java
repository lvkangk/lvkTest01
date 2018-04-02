package com.lvk.Service;

import javax.jws.WebMethod;

/**
 * @author: kangkang.lv
 * @date: 18-1-10 下午5:43
 */
@javax.jws.WebService
public interface WebService {

    @WebMethod
    String sayHello(String name);

}
