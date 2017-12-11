import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/4/10 0010.
 */
public class FriendNum {
    public static void main(String []args) throws Exception {
        String key = "x5s4d6j9";
        int seedOfDate = Calendar.getInstance().get(Calendar.DATE) + 10;
        int seedOfHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + 10;

        String account = "liuyj";// 用户帐号
        String content = account + seedOfDate + seedOfHour;
        System.out.println("加密前：" + content);
        String pass = FriendNum.encrypt(content, key);
        System.out.println("加密后：" + pass);
        String auth = URLEncoder.encode(pass, "utf-8");
        System.out.println("对密文进行编码（auth值）：" + auth);
    }


    public static String encrypt(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        return encodeBase64(cipher.doFinal(message.getBytes("UTF-8")));
    }

    public static String encodeBase64(byte[] b) {
        return Base64.getEncoder().encodeToString(b);
    }

}
