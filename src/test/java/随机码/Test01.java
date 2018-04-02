package 随机码;

import org.junit.Test;

/**
 * @author: kangkang.lv
 * @date: 17-11-8 上午11:19
 */
public class Test01 {


    @Test
    public void t01(){
        int size = 6;
        String code = "";
        for (int i=0;i<size;i++){
            code += (int)(Math.random()*10);
        }
        System.out.println(code);

    }




}
