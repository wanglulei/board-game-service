/*
 *  Copyright 2015-2020 Xmiles, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.dl.board.game.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Description: 压缩解压缩工具类
 *
 * @author Ale
 * @date 2018-04-23
 */
public class CompressorUtils {


    /**
     * @param srcByte 原始数据
     * @return 压缩后的数据
     */
    public static byte[] compressor(byte[] srcByte) {

        return QuickLZ.compress(srcByte,1);
    }


    /**
     * @param compressorByte 压缩后的数据
     * @return
     */
    public static byte[] decompressor(byte[] compressorByte) {
         return QuickLZ.decompress(compressorByte);
    }



    /**
     　　* @Description: 压缩数据并转化为base64
     　　* @param  srcData 原始数据
     　　* @return 压缩并base64编码后数据
     　　*/
    public static String compressor(String srcdata) {
        String compressorStr = null;
        try {
            byte[] data = srcdata.getBytes("UTF-8");
            byte[] compressorData = compressor(data);
            compressorStr = Base64.getEncoder().encodeToString(compressorData);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return compressorStr;
        }
        return compressorStr;

    }


    /**
     　　* @Description: base64解码并解压数据
     　　* @param  data 解压后数据
     　　* @return 原始数据
        * @throws UnsupportedEncodingException
     　　*/
    public static String decompress(String data) {

        try {
            byte[] srcData = decompressor(Base64.getDecoder().decode(data));
            return new String(srcData, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main (String[] args) {
        String str = "7ZfLjtMwFIZfZRTp7NrGdpzYzop0aKXZIMTMDrGIWpOJlBuJw0WIHVskJLbwJDwPAt4CJ21pPISiMBnaBVIXds9/Tj5b6Sf18WurrmT5NCzTJMzWF2vLp5xNrKJcx3ptYYoQsiZtqCkyhpigZGJ1O/B++yBvt5WUu0rTeam3WZhKPfDb+09f3n3UEwsdVz+fp14V0hh0qUJVV5bvTKznYRKvgzSvM2X50yZT1rHqBPJaFbV6FKo4z/QQhDbTdaJUV3H7WIKwmCI+ddAZpj5lPmGaYaU6VYymhJ9h16fIp56uqlLKq0OBlsNIkBuJqAzXm3Ot8ko9LOOV3qFd5+7MlUySOIu2ZYw299d8dZFGeva1UkXl23acRtUsSuNEVs/qMJut8tSu4rRO2pPbu6uzHRsWHgQU+H1YMOACAtEuAph7TYkj4BgWS5ifA1/CgoNAIHTYbVrEOenUXJiLZq1DfA6C3SMvgXBMgIhZkUXbezoBUJ1uy81EHcJbUGcP2t76KZHqfg/EcktK96RhIstjkXZKDALWznEh0CW0ASUd0BdhKa9z/Rs/fdg3kz7X8YGuI6bryN515BfXff/89uuHG67j/13XdR2/resGvj9aZXPgtMkIx3x/+kXnjOG58SD7JUdHcdwdUBqCc0fx23iU/cLAfDS7/TvUfreJgW5zTLc5B1SFe1T1l2rqZRdoIDs12ekx2fFAdtdkd4/JTgayeya7d0x2ZyA7M9kP/Q1Bt2HXH7Jld8lv2OlAdm6y8ztkZ39idweyC5Nd3B07ph32Jz8A";
//        System.out.println(decompress(str));

        String stra = "{\"type\": 25,\"viewAd\": 0,\"coin\": 0}";
        System.out.println(compressor(stra));

    }
}
