package com.dct.survey.taishan.http;

import com.dct.survey.taishan.bean.Dictionary;
import com.dct.survey.taishan.bean.UserBean;
import com.dct.survey.taishan.bean.UserInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
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
    Observable<UserBean> login(@QueryMap Map<String, String> map);

    /**
     * 获取所有的用户
     */
    @GET("GetAllUserInfo")
    Observable<List<UserInfo>> getAllUserInfo();

    /**
     * 字典数据接口
     */
    @GET("GetDictionaryInfoList")
    Observable<List<Dictionary>> getDictionary(@Query("offSet") int offSet);

}
