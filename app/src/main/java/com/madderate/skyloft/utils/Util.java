package com.madderate.skyloft.utils;

import java.util.HashMap;
import java.util.Map;

// 通用的工具类
// 包含各种通用算法
public class Util {

    private static Map<Character, String> urlSpecialCharacterMap = new HashMap<Character, String>() {
        {
            urlSpecialCharacterMap.put(' ', "%20");
            urlSpecialCharacterMap.put('"', "%22");
            urlSpecialCharacterMap.put('#', "%23");
            urlSpecialCharacterMap.put('%', "%25");
            urlSpecialCharacterMap.put('&', "%26");
            urlSpecialCharacterMap.put('(', "%28");
            urlSpecialCharacterMap.put(')', "%29");
            urlSpecialCharacterMap.put('+', "%2B");
            urlSpecialCharacterMap.put(',', "%2C");
            urlSpecialCharacterMap.put('/', "%2F");
            urlSpecialCharacterMap.put(':', "%3A");
            urlSpecialCharacterMap.put(';', "%3B");
            urlSpecialCharacterMap.put('<', "%3C");
            urlSpecialCharacterMap.put('=', "%3D");
            urlSpecialCharacterMap.put('>', "%3E");
            urlSpecialCharacterMap.put('?', "%3F");
            urlSpecialCharacterMap.put('@', "%40");
            urlSpecialCharacterMap.put('\\', "%5C");
            urlSpecialCharacterMap.put('|', "%7C");
        }
    };

    // 将某个字符转为URL编码
    public static String replaceCharToURLEncode(char ch) {
        if (!urlSpecialCharacterMap.containsKey(ch)) {
            return String.valueOf(ch);
        }
        return urlSpecialCharacterMap.get(ch);
    }

    // 将字符串中的一个字符转换成URL编码
    public static String replaceOneCharInStrToURLEncode(int index, String str) {
        // 判断传入的index位置字符是否是特殊字符
        // 是则进行替换，不是则不改变
        if (!urlSpecialCharacterMap.containsKey(str.charAt(index))) {
            return str;
        }
        return "" + str.substring(0, index) +
                urlSpecialCharacterMap.get(str.charAt(index)) +
                str.charAt(index) +
                str.substring(index + 1);
    }

    // 将字符串中某种特定字符转换成URL编码
    public static String replaceACharInStrToURLEncode(char ch, String str) {
        String[] subStrings = str.split(String.valueOf(ch));
        StringBuilder builder = new StringBuilder();
        int i;
        for (i = 0; i < subStrings.length - 1; i++) {
            builder.append(subStrings[i])
                    .append(urlSpecialCharacterMap.get(ch));
        }
        builder.append(subStrings[i]);
        return builder.toString();
    }

    public static String replaceURLSpecialChar(String partUrl) {
        char[] chars = partUrl.toCharArray();
        StringBuilder builder = new StringBuilder("");
        for (char aChar : chars) {
            builder.append(replaceCharToURLEncode(aChar));
        }
        return builder.toString();
    }
}
