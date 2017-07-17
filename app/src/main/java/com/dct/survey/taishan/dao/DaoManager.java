package com.dct.survey.taishan.dao;

import android.content.Context;

import com.dct.survey.taishan.bean.UserBean;

/**
 * 创建：Android
 * 日期：2017/7/11 19:34
 * 描述：数据库操作类
 */

public class DaoManager {

    private DictionaryDao dictionaryDao;
    private UserBeanDao userBeanDao;

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

    public DictionaryDao getDictionaryDao() {
        return dictionaryDao;
    }

    private DaoManager(Context context){
        DaoSession daoSession = GreenDaoManager.getInstance(context).getDaoSession();
        dictionaryDao = daoSession.getDictionaryDao();
        userBeanDao = daoSession.getUserBeanDao();
    }
    private static DaoManager daoManager;
    public synchronized static  DaoManager getInstance(Context context){
        if (null == daoManager){
            synchronized (DaoManager.class){
                if (null == daoManager) {
                    daoManager = new DaoManager(context);
                }
            }
        }
        return daoManager;
    }

    /**
     * 根据登陆的用户名获取当前用户的信息
     *
     */
    public UserBean getCurrentUser(String username){
        UserBean userBean = userBeanDao.queryBuilder().where(UserBeanDao.Properties.LOGINNAME.eq(username)).unique();
        return userBean;
    }
}
