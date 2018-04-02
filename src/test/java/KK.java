/**
 * @author: kangkang.lv
 * @date: 17-3-6 上午11:25
 */
public class KK {
    int i = 0;
    public int getI(){
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 9999;
        }finally {
            i++;
        }

    }
}
