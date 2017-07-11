package com.dct.survey.taishan.dao;

import android.content.Context;
import android.text.TextUtils;

import com.dct.survey.taishan.bean.Dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建：Android
 * 日期：2017/7/11 19:34
 * 描述：数据库操作类
 */

public class DaoManager {

    private DictionaryDao dictionaryDao;

    public DictionaryDao getDictionaryDao() {
        return dictionaryDao;
    }

    private DaoManager(Context context){
        DaoSession daoSession = GreenDaoManager.getInstance(context).getDaoSession();
        dictionaryDao = daoSession.getDictionaryDao();
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
     * 获取等级
     */
    public List<String> getGrade(){
        List<Dictionary> gradeLists = dictionaryDao.queryBuilder().where(DictionaryDao.Properties.CODE.eq("1134")).build().list();
        List<String> grades = new ArrayList<>();
        for (Dictionary dictionary : gradeLists){
            String grade = dictionary.getKEYNAME();
            grades.add(grade);
        }
        return grades;
    }

    /**
     * 获取类型
     */
    public List<String> getType(){
        List<Dictionary> typeLists = dictionaryDao.queryBuilder().where(DictionaryDao.Properties.CODE.eq("113504")).build().list();
        List<String> types = new ArrayList<>();
        for (Dictionary dictionary : typeLists){
            String type = dictionary.getKEYNAME();
            types.add(type);
        }
        return types;
    }

    /**
     * 根据类型的名称获取类型的编号
     * 根据等级的名称获取等级的编号
     */
    public String getNoFromName(String type){
        if (TextUtils.isEmpty(type)){
            return "";
        }else {
            List<Dictionary> list = dictionaryDao.queryBuilder().where(DictionaryDao.Properties.KEYNAME.eq(type)).build().list();
            String keyvalue = list.get(0).getKEYVALUE();
            return keyvalue;
        }
    }
}
