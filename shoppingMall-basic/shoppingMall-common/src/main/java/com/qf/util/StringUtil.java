package com.qf.util;

/**
 * @Author: xiaohe
 * @Date:2020/3/10 20:57
 */
public class StringUtil {

    //封装Redis键
    public static String getRedisKey(String pre,String key){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pre);
        stringBuilder.append(key);
        return stringBuilder.toString();
    }
}
