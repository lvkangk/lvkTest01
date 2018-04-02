package PythonTest;

import org.junit.Test;
import org.python.util.PythonInterpreter;

/**
 * @author: kangkang.lv
 * @date: 16-11-29 上午11:54
 */
public class PythonTest {

    @Test
    public void test01(){
        PythonInterpreter interpreter = new PythonInterpreter();
        //执行python语句
        interpreter.exec("print 'hollo word'");
        //执行python文件
        interpreter.execfile("/home/lvkang/testpy01.py");
    }

}
