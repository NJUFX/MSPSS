package util;

import java.security.MessageDigest;

/**
 * Description: MD5加密算法
 * Created by Hanxinhu at 8:38 2017/11/30/030
 */
public class Encryptor {
    /**
     * 加密算法
     *
     * @param str
     * @return 加密后的字符串
     */
    public static String encrypt(String str) {
        boolean isTest = false;
        if(isTest){
            return str;
        }else{
            //MD5 32位加密
            String result = "";
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(str.getBytes());
                byte b[] = md.digest();
                int i;
                StringBuilder buf = new StringBuilder("");
                for (int offset = 0; offset < b.length; offset++) {
                    i = b[offset];
                    if (i < 0)
                        i += 256;
                    if (i < 16)
                        buf.append("0");
                    buf.append(Integer.toHexString(i));
                }
                result = buf.toString();
//                System.out.println("MD5(" + str + ",32) = " + result);
                return result;
            }catch (Exception e){
                e.printStackTrace();
                return str;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Encryptor.encrypt("1"));
        System.out.println(Encryptor.encrypt("123456"));
        System.out.println(Encryptor.encrypt("wsxgy813"));
    }
}
