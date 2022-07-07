package com.zhang.xypaotui.utils;

import java.util.Random;

public class CodeUtils {
    public static String getCode(){
        char[] chars = "01234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
