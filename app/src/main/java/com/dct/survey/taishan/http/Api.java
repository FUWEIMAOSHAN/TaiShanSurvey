package com.dct.survey.taishan.http;

import com.dct.survey.taishan.bean.DictionaryLibrary;
import com.dct.survey.taishan.bean.LoginBean;
import com.dct.survey.taishan.bean.UserBean;
import com.dct.survey.taishan.bean.WorkSiteBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 创建：Android
 * 日期：2017/7/6 17:25
 * 描述：接口地址
 */

public interface Api {

     String BASE_URL = "http://47.92.131.202:8008/CloudServiceApp/";

    /**
     * 登陆接口
     */
    @GET("CheckUserInfo")
    Observable<LoginBean> login(@QueryMap Map<String, String> map);

    /**
     * 获取所有的用户
     */
    @GET("GetAllUserInfo")
    Observable<List<UserBean>> getAllUserInfo();

    /**
     * 字典数据接口
     */
    @GET("GetDictionaryInfoList")
    Observable<DictionaryLibrary> getDictionary();

    /**
     * 获取工地信息数据接口
     */
    @GET("getWorkSiteList")
    Observable<List<WorkSiteBean>> getWorkSite();

}
