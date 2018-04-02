package SpringTest;

import com.lvk.Service.Impl.Test2ServiceImpl;
import com.lvk.Service.Test2Service;
import com.lvk.Service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: kangkang.lv
 * @date: 17-3-23 上午11:34
 */
public class BeanTest {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        /*TestService testService = (TestService) context.getBean("testAop");
        testService.te();*/
        Test2ServiceImpl test2Service = (Test2ServiceImpl) context.getBean("testAop2");
        test2Service.te();
    }


}
