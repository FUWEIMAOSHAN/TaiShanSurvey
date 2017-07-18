package com.dct.survey.taishan.dao;

import com.dct.survey.taishan.bean.DictionaryBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建：Android
 * 日期：2017/7/18 12:38
 * 描述：GreenDao对象集合转换String操作
 */

public class MyObjectConverent implements PropertyConverter<List<DictionaryBean>, String> {

    private final Gson gson;

    public MyObjectConverent() {
        gson = new Gson();
    }

    @Override
    public List<DictionaryBean> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<ArrayList<DictionaryBean>>() {
        }.getType();
        List<DictionaryBean> itemList = gson.fromJson(databaseValue, type);
        return itemList;
    }

    @Override
    public String convertToDatabaseValue(List<DictionaryBean> entityProperty) {
        String databaseValue = gson.toJson(entityProperty);
        return databaseValue;
    }
}
