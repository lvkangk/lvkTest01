package Encrypt;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.provider.*;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author: kangkang.lv
 * @date: 17-7-20 下午3:41
 */
public class Encrypt {

    private static String[] chars = new String[]{"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    private static String[] chars2 = new String[]{"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    //生成推荐码逻辑
    @Test
    public void test03(){
        String data = "斯蒂芬司法违法无人各个dedsfasdf";
        int codeSize = 5;       //code长度
        String resCode = "";
        String key = "dajie";
        String sMD5EncryptResult = (new MD5()).toHexString(key + data);
        BigInteger md5num = new BigInteger(sMD5EncryptResult, 16);
        md5num = new BigInteger(md5num.toString());
        BigInteger scale = new BigInteger("36");
        for (int i = 0; i < codeSize; ++i) {
            resCode = chars[md5num.mod(scale).intValue()] + resCode;
            md5num = md5num.divide(scale);
        }
        //final String myShortURL = resCode;
        System.out.println("resCode: "+resCode);
    }

    @Test
    public void test02(){
        String str = "9001191600000000001,9100102800000000001";
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(str.getBytes());
        System.out.println(encode);
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] bytes = decoder.decodeBuffer(encode);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01(){
        String str = "lvkng";
        String md5Hex = DigestUtils.md5Hex(str);
        System.out.println(md5Hex);

    }

}
