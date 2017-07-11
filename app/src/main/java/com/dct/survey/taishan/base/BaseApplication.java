package com.dct.survey.taishan.base;

import android.app.Application;
import android.content.Context;

import com.dct.survey.taishan.dao.GreenDaoManager;


/**
 * 创建：Android
 * 日期：2017/7/6 15:50
 * 描述：程序的入口
 */

public class BaseApplication extends Application {

    private Context applicationContext;
    private static  BaseApplication baseApplication;

    public BaseApplication() {}
    /**
     *  实例化一次
     */
    public synchronized static BaseApplication getInstance() {
        if (null == baseApplication) {
            synchronized (BaseApplication.class) {
                if (null == baseApplication) {
                    baseApplication = new BaseApplication();
                }
            }
        }
        return baseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        GreenDaoManager.getInstance(this); //配置GreenDao数据库
    }

    /**
     * 获取全局的上下文
     */
    public Context getContext() {
        return applicationContext;
    }
}
