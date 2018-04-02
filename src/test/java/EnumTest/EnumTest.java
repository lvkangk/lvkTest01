package EnumTest;

import com.lvk.Model.FreeNum;
import com.lvk.constant.CrCorpConstants;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kangkang.lv
 * @date: 16-12-20 下午4:16
 */
public class EnumTest {

    @Test
    public void test02(){
        String s = "M";
        System.out.println(WishSourceEnum.valueOf(s).getCode());
    }

    @Test
    public void test01(){
        String str = YYEnum.qqq.toString();
        System.out.println(YYEnum.qqq.getValue());
        System.out.println(YYEnum.valueOf("qqq").getValue());
        System.out.println(str);

        System.out.println("-----");

        for (YYEnum y : YYEnum.values()){
            System.out.println(y.toString());
        }


    }

    enum YYEnum{
        qqq(1),
        www(2);

        private int value;

        private YYEnum(int value){
            this.value = value;
        }

        private int getValue() {
            return value;
        }
    }

    /**
     * jdk 1.7以前不支持swich(String),所以可以用枚举方式
     */
    @Test
    public void test(){
        try {
            List<FreeNum> list = new ArrayList<FreeNum>();
            FreeNum freeNum1 = new FreeNum();
            freeNum1.setId(11);freeNum1.setTableName("tb_free_1");
            FreeNum freeNum2 = new FreeNum();
            freeNum2.setId(22);freeNum2.setTableName("tb_free_2");
            FreeNum freeNum3 = new FreeNum();
            freeNum3.setId(33);freeNum3.setTableName("tb_free_3");
            list.add(freeNum1);list.add(freeNum2);list.add(freeNum3);

            System.out.println(list.size());
            for (FreeNum freeNum :list){
                CrCorpConstants.TABLE_FREE_ENUM tf = CrCorpConstants.TABLE_FREE_ENUM.valueOf(freeNum.getTableName());
                switch (tf){
                    case tb_free_1:
                        System.out.println(freeNum.getId()+":tb_free_1");
                        break;
                    case tb_free_2:
                        System.out.println(freeNum.getId()+":tb_free_2");
                        break;
                    case tb_free_3:
                        System.out.println(freeNum.getId()+":tb_free_3");
                        break;
                    case tb_free_4:
                        System.out.println(freeNum.getId()+":tb_free_4");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
