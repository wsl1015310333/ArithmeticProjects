

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import java.net.URLDecoder;
import java.util.Calendar;

import static sun.plugin2.util.SystemUtil.decodeBase64;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
public class YiSaMiMa {
    public static void main(String []args){





//        String getPass = null;
//        try {
//            getPass = decrypt(URLDecoder.decode("wkJ%2Fdfg%2BqwqGzWbUUCyypw%3D%3D","utf-8"), "x5s4d6j9");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String date = getPass.substring(getPass.length()-2,getPass.length());
//        Calendar d2=Calendar.getInstance();
//        System.out.println(date);
//        System.out.println(date.trim().equals((d2.get(Calendar.DATE)+10)+""));
    }
    public static String decrypt(String message, String key) throws Exception {

        byte[] bytesrc = decodeBase64(message);// convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

        byte[] retByte = cipher.doFinal(bytesrc);
        return new String(retByte);
    }

}
