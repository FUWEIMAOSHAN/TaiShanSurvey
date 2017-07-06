package com.dct.survey.taishan.api;

/**
 * 创建：Android
 * 日期：2017/7/6 17:25
 * 描述：接口地址
 */

public class Urls {

    //阿里云
    public static String getServices = "http://47.92.131.202:8009/";
    //服务地址
    public static String servicesURL = getServices + "CloudServiceApp/";

    //获取登录时的验证
    public static String LoginCheck = servicesURL + "CheckUserInfo";
}
