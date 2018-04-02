package com.lvk.Service.Impl;

import com.lvk.Other.TestOther;
import com.lvk.Service.Test2Service;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: kangkang.lv
 * @date: 17-3-23 下午2:14
 */
/*@Service("test2Service")*/
public class Test2ServiceImpl{

    //@Autowired
    //private TestOther testOther;

    /*public TestOther getTestOther() {
        return testOther;
    }

    public void setTestOther(TestOther testOther) {
        this.testOther = testOther;
    }*/

    public void te(){
        System.out.println("Tset2Service te");
    }
}
