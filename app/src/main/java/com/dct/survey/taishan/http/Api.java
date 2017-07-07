package com.dct.survey.taishan.http;

import com.dct.survey.taishan.bean.BaseResult;

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

     String BASE_URL = "http://47.92.131.202:8009/CloudServiceApp/";

    /**
     * 登陆接口
     */
    @GET("CheckUserInfo")
    Observable<BaseResult> login(@QueryMap Map<String, String> map);
}
