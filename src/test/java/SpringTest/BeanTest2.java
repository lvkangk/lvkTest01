package SpringTest;

import com.lvk.Service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: kangkang.lv
 * @date: 17-3-23 下午2:35
 */
//@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration({
        "classpath:/applicationContext.xml"
})*/
public class BeanTest2 {

    @Autowired
    private TestService testService;

    @Test
    public void test01() throws InterruptedException {
        testService.te();
        //Thread.currentThread().sleep(10000l);
    }

}
