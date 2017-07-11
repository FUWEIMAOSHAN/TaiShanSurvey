package com.dct.survey.taishan.utils;

import java.text.SimpleDateFormat;

/**
 * Created by peishaoting on 2015/8/7.
 * 获取时间函数
 */
public class CurrentDate {
    //精确到秒
    public static String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new java.util.Date());
    }

    public static String getH(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
        return df.format(new java.util.Date());
    }


    //精确到天
    public static String getDay(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new java.util.Date());
    }
    //精确到天
    public static String getMini(){
        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm");
        return df.format(new java.util.Date());
    }
    //精确到秒
    public static String getmm(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//这里定义为秒
        return df.format(new java.util.Date());
    }

    //精确到毫秒
    public static String getyMini(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return df.format(new java.util.Date());
    }

    //年
    public static int  getyear(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return Integer.parseInt(df.format(new java.util.Date()));
    }
    //月
    public static int  getmonth(){
        SimpleDateFormat df = new SimpleDateFormat("MM");
        return Integer.parseInt(df.format(new java.util.Date()));
    }
    //日
    public static int  getDay1(){
        SimpleDateFormat df = new SimpleDateFormat("dd");
        return Integer.parseInt(df.format(new java.util.Date()));
    }
}
