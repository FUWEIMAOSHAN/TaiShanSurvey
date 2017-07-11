package com.dct.survey.taishan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 创建：Android
 * 日期：2017/7/11 19:21
 * 描述：调查点的实体类
 */

@Entity
public class SurveyTarget {

    //点的GUID
    @Unique
    private String GUID;
    //工地GUID
    @Unique
    private String HSITEGUID;
    //用户GUID
    @Unique
    private String USERGUID;
    //名称
    private String NAME;
    //地址
    private String ADDRESS;
    //调查点类型
    private String TGTTYPE;
    //纬度
    private String N;
    //经度
    private String E;
    //高程
    private String Z;
    //备注
    private String REMARK;
    //封面照路径
    private String IMAGEURL;
    //状态
    private String STATE;
    //更新时间
    private String UPDATETIME;
    //等级  字典表获取
    private String GRADE;
    //编号
    private String NO;
    @Generated(hash = 421803194)
    public SurveyTarget(String GUID, String HSITEGUID, String USERGUID, String NAME,
            String ADDRESS, String TGTTYPE, String N, String E, String Z,
            String REMARK, String IMAGEURL, String STATE, String UPDATETIME,
            String GRADE, String NO) {
        this.GUID = GUID;
        this.HSITEGUID = HSITEGUID;
        this.USERGUID = USERGUID;
        this.NAME = NAME;
        this.ADDRESS = ADDRESS;
        this.TGTTYPE = TGTTYPE;
        this.N = N;
        this.E = E;
        this.Z = Z;
        this.REMARK = REMARK;
        this.IMAGEURL = IMAGEURL;
        this.STATE = STATE;
        this.UPDATETIME = UPDATETIME;
        this.GRADE = GRADE;
        this.NO = NO;
    }
    @Generated(hash = 2050059567)
    public SurveyTarget() {
    }
    public String getGUID() {
        return this.GUID;
    }
    public void setGUID(String GUID) {
        this.GUID = GUID;
    }
    public String getHSITEGUID() {
        return this.HSITEGUID;
    }
    public void setHSITEGUID(String HSITEGUID) {
        this.HSITEGUID = HSITEGUID;
    }
    public String getUSERGUID() {
        return this.USERGUID;
    }
    public void setUSERGUID(String USERGUID) {
        this.USERGUID = USERGUID;
    }
    public String getNAME() {
        return this.NAME;
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    public String getADDRESS() {
        return this.ADDRESS;
    }
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }
    public String getTGTTYPE() {
        return this.TGTTYPE;
    }
    public void setTGTTYPE(String TGTTYPE) {
        this.TGTTYPE = TGTTYPE;
    }
    public String getN() {
        return this.N;
    }
    public void setN(String N) {
        this.N = N;
    }
    public String getE() {
        return this.E;
    }
    public void setE(String E) {
        this.E = E;
    }
    public String getZ() {
        return this.Z;
    }
    public void setZ(String Z) {
        this.Z = Z;
    }
    public String getREMARK() {
        return this.REMARK;
    }
    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }
    public String getIMAGEURL() {
        return this.IMAGEURL;
    }
    public void setIMAGEURL(String IMAGEURL) {
        this.IMAGEURL = IMAGEURL;
    }
    public String getSTATE() {
        return this.STATE;
    }
    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }
    public String getUPDATETIME() {
        return this.UPDATETIME;
    }
    public void setUPDATETIME(String UPDATETIME) {
        this.UPDATETIME = UPDATETIME;
    }
    public String getGRADE() {
        return this.GRADE;
    }
    public void setGRADE(String GRADE) {
        this.GRADE = GRADE;
    }
    public String getNO() {
        return this.NO;
    }
    public void setNO(String NO) {
        this.NO = NO;
    }
}
