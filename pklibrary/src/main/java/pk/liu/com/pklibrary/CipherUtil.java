package pk.liu.com.pklibrary;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by liushichao on 2018/1/31.
 */

public class CipherUtil {
    private static final String CipherMode = "AES/CBC/PKCS5PADDING";
    private static String key = "weJiSEvR5yAC5ftB";
    private static String algorithm = "AES";

    /**
     * 对字符串加密
     */
    public static String encrypt(String data, String iv) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(CipherMode);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, new IvParameterSpec(iv.getBytes()));
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.encodeToString(encrypted, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对字符串解密
     */
    public static String decrypt(String data, String iv) throws Exception {
        try {
            byte[] encrypted1 = Base64.decode(data.getBytes(), Base64.DEFAULT);
            Cipher cipher = Cipher.getInstance(CipherMode);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), algorithm);
            cipher.init(Cipher.DECRYPT_MODE, keyspec, new IvParameterSpec(iv.getBytes()));
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
