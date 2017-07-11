package com.dct.survey.taishan.utils;

/**
 * Created by peishaoting on 2015/8/8.
 * java 获取uuid
 */
public class UUID {
    public static String getUUID(){
        //获取uuid
        java.util.UUID uuid= java.util.UUID.randomUUID();
//        StringBuilder sb = new StringBuilder();
//        sb.append(digits(uuid.getMostSignificantBits() >> 32, 8));
//        sb.append(digits(uuid.getMostSignificantBits() >> 16, 4));
//        sb.append(digits(uuid.getMostSignificantBits(), 4));
//        sb.append(digits(uuid.getLeastSignificantBits() >> 48, 4));
//        sb.append(digits(uuid.getLeastSignificantBits(), 12));
        return uuid.toString();
    }

}
