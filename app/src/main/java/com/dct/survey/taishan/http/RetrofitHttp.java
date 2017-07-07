package com.dct.survey.taishan.http;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建: 付威
 * 日期: 2017/3/20 17:22
 * 描述: 单例获取retrofit对象
 */
public class RetrofitHttp {

    /**
     * 单例获取retrofit对象
     */
    private static Api singleton;
    public static Api getRetrofit() {
        if (singleton == null) {
            synchronized (RetrofitHttp.class) {
                singleton = createRetrofit().create(Api.class);
            }
        }
        return singleton;
    }

    /**
     * 创建retrofit对象
     * @return
     */
    private static Retrofit createRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(8000, TimeUnit.MILLISECONDS)
                .writeTimeout(8000, TimeUnit.MILLISECONDS)
                .readTimeout(8000, TimeUnit.MILLISECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        return retrofit;
    }
}
