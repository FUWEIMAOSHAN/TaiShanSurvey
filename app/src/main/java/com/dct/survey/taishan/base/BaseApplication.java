package com.dct.survey.taishan.base;

import android.app.Application;

/**
 * 创建：Android
 * 日期：2017/7/6 15:50
 * 描述：程序的入口
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
    }
}
