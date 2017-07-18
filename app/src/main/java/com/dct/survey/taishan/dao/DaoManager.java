package com.dct.survey.taishan.dao;

import android.content.Context;

import com.dct.survey.taishan.bean.UserBean;

/**
 * 创建：Android
 * 日期：2017/7/11 19:34
 * 描述：数据库操作类
 */

public class DaoManager {

    private UserBeanDao userBeanDao;
    private DictionaryLibraryDao dictionaryLibraryDao;
    private WorkSiteBeanDao workSiteBeanDao;

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

    public DictionaryLibraryDao getDictionaryLibraryDao() {
        return dictionaryLibraryDao;
    }

    public WorkSiteBeanDao getWorkSiteBeanDao() {
        return workSiteBeanDao;
    }

    private DaoManager(Context context){
        DaoSession daoSession = GreenDaoManager.getInstance(context).getDaoSession();
        userBeanDao = daoSession.getUserBeanDao();
        dictionaryLibraryDao = daoSession.getDictionaryLibraryDao();
        workSiteBeanDao = daoSession.getWorkSiteBeanDao();
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
