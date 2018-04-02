import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lvkang on 16-5-19.
 */
public class PatternTest {

    @Test
    public void test08(){
        String m = "le34";
        String mm = "title34443_3";

        Pattern pattern = Pattern.compile(m);
        Matcher matcher = pattern.matcher(mm);

        System.out.println(matcher.find());
    }

    @Test
    public void test07(){
        String m = "(?i)"+"师";//不区分大小写
        String mm = "title34443_3";

        Pattern pattern = Pattern.compile(m);
        Matcher matcher = pattern.matcher(mm);

        System.out.println(matcher.find());
    }

    @Test
    public void test06(){
        String mo = "11000000000";
        boolean b = Pattern.matches("^((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(17[0,1,3,5-8])|(18[0-9]))\\d{8}$",mo);
        System.out.println(b);
    }

    @Test
    public void test05(){
        String mo = "17000000000";
        String mobile = "^((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(17[0,1,3,5-8])|(18[0-9]))\\d{8}$";
        Pattern pattern = Pattern.compile(mobile);
        Matcher matcher = pattern.matcher(mo);
        System.out.println(matcher.matches());
    }

    @Test
    public void test04(){

        //Pattern pattern = Pattern.compile(".*[0]{2}$");//后两位都为0
        Pattern pattern = Pattern.compile(".*\\$$"); //"$"结尾
        String str = "ggfaa09";
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }

    @Test
    public void test03(){
        Pattern pattern = Pattern.compile("^h[a-z]{1,3}o\\b.*");
        String str = "hellosir";
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());   //false   ??????????????????????
    }

    @Test
    public void test01(){
        Pattern pattern = Pattern.compile("\\d{3,5}");
        String str = "222-55555-334-5";
        out(str);
        Matcher matcher = pattern.matcher(str);
        out(matcher.find());
        out(matcher.start()+"----"+matcher.end());  //0----3
        out(matcher.find());
        out(matcher.start()+"----"+matcher.end());  //4----9
        out(matcher.find());
        out(matcher.start()+"----"+matcher.end());  //10----13
        //out(matcher.find());
        //out(matcher.start()+"----"+matcher.end());  //java.lang.IllegalStateException: No match available

        //永远从整个字符串的开头开始匹配,所以在这里都是true
        out(matcher.lookingAt());
    }


    @Test
    //分组
    public void test02(){
        /*Pattern pattern = Pattern.compile("(\\d{3,5})([a-z]{2})");
        String str = "123rt-34345bb-234cc-006";*/
        Pattern pattern = Pattern.compile("(\\w+)\\=(\\w*)");
        String str = "qt=wrf342;iu8=999;999r=ererg8;tt=;=u5";
        Matcher matcher =  pattern.matcher(str);
        out(str);
        while (matcher.find()){
            out(matcher.group(1)+"==="+matcher.group(2));
        }
    }


    public void out(Object o){
        System.out.println(o);
    }
}
