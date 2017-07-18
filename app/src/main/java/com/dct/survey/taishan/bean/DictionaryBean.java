package com.dct.survey.taishan.bean;

import java.util.List;

/**
 * 创建： fuwei
 * 日期： 2017-07-10 下午 10:27
 * 描述： 字典数据
 */

public class DictionaryBean {

    /**
     * CODE : 11270202
     * DESCRIPTION : null
     * FROWINDEX : 1
     * KEYNAME : 好
     * KEYVALUE : 1127020201
     * NAME : 保护现状
     */

    private int CODE;
    private String DESCRIPTION;
    private int KEYVALUE;
    private String NAME;
    private List<DictionaryBean> DAMAGED; //残损现状
    private List<DictionaryBean> IMAGEREQUIRE; //影像要求
    private List<DictionaryBean> LEVEL; //规模
    private List<DictionaryBean> TYPE; //类型


}
