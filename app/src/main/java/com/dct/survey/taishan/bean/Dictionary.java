package com.dct.survey.taishan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 创建： fuwei
 * 日期： 2017-07-10 下午 10:27
 * 描述： 字典数据
 */

@Entity
public class Dictionary {

    /**
     * CODE : 11270202
     * DESCRIPTION : null
     * FROWINDEX : 1
     * KEYNAME : 好
     * KEYVALUE : 1127020201
     * NAME : 保护现状
     */

    private String CODE;
    private String DESCRIPTION;
    private int FROWINDEX;
    private String KEYNAME;
    private String KEYVALUE;
    private String NAME;

    @Generated(hash = 978544408)
    public Dictionary(String CODE, String DESCRIPTION, int FROWINDEX,
            String KEYNAME, String KEYVALUE, String NAME) {
        this.CODE = CODE;
        this.DESCRIPTION = DESCRIPTION;
        this.FROWINDEX = FROWINDEX;
        this.KEYNAME = KEYNAME;
        this.KEYVALUE = KEYVALUE;
        this.NAME = NAME;
    }

    @Generated(hash = 487998537)
    public Dictionary() {
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getFROWINDEX() {
        return FROWINDEX;
    }

    public void setFROWINDEX(int FROWINDEX) {
        this.FROWINDEX = FROWINDEX;
    }

    public String getKEYNAME() {
        return KEYNAME;
    }

    public void setKEYNAME(String KEYNAME) {
        this.KEYNAME = KEYNAME;
    }

    public String getKEYVALUE() {
        return KEYVALUE;
    }

    public void setKEYVALUE(String KEYVALUE) {
        this.KEYVALUE = KEYVALUE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}
