package com.dl.board.game.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * @Description
 * @Author wanglulei
 * @Date 2020/6/12  10:31
 **/
public class Md5Utils {

    public static String getMd5ByFile(File file) {
        String value = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            MappedByteBuffer byteBuffer = in.getChannel().map(
                    FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);

        } catch (Exception e) {
            e.printStackTrace();
            if (null != in) {
                try {
                    in.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return value;
    }

    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }


    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private final static String[] hexDigits = {
            "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"
    };


    public static String getPheadMd5(String prdid, String phoneid, long timestamp){

        StringBuilder tmp = new StringBuilder().append("prdid=").append(prdid)
                .append("&phoneid=").append(phoneid)
                .append("&timestamp=").append(timestamp)
                .append("&key=").append("ZTJyffYliwuJnzkv");
        return Md5Utils.MD5Encode(tmp.toString()).toLowerCase();
    }
}
