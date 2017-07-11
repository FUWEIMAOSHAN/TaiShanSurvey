package com.dct.survey.taishan.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 创建：Android
 * 日期：2017/7/11 8:57
 * 描述：配置GreenDao数据库
 */

public class GreenDaoManager {

    private  DaoSession daoSession;
    private  DaoMaster daoMaster;

    private GreenDaoManager(Context context){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "dct.db",null);
        SQLiteDatabase sqLiteDatabase = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }
    private static GreenDaoManager greenDaoManager;
    public synchronized static  GreenDaoManager getInstance(Context context){
        if (null == greenDaoManager){
            synchronized (GreenDaoManager.class){
                if (null == greenDaoManager) {
                    greenDaoManager = new GreenDaoManager(context);
                }
            }
        }
        return greenDaoManager;
    }

    public DaoSession getDaoSession(){
        return  daoSession;
    }
    public DaoMaster getDaoMaster(){
        return daoMaster;
    }
}
