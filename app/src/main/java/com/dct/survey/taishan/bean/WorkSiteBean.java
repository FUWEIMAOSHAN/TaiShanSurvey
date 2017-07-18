package com.dct.survey.taishan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 创建：Android
 * 日期：2017/7/18 12:58
 * 描述：工地信息的实体类
 */

@Entity
public class WorkSiteBean {

    /**
     * COMMONNO : 2016CL
     * FLOATRULE : null
     * GUID : e111d3e9-ecf0-4c77-9d81-e9cb4e272b43
     * PARENTGUID : null
     * REGION : null
     * SITENAME : 台山项目
     */

    private String COMMONNO;
    private String FLOATRULE;
    @Unique
    private String GUID;
    private String PARENTGUID;
    private String REGION;
    private String SITENAME;
    @Generated(hash = 1869774512)
    public WorkSiteBean(String COMMONNO, String FLOATRULE, String GUID,
            String PARENTGUID, String REGION, String SITENAME) {
        this.COMMONNO = COMMONNO;
        this.FLOATRULE = FLOATRULE;
        this.GUID = GUID;
        this.PARENTGUID = PARENTGUID;
        this.REGION = REGION;
        this.SITENAME = SITENAME;
    }
    @Generated(hash = 1355519148)
    public WorkSiteBean() {
    }
    public String getCOMMONNO() {
        return this.COMMONNO;
    }
    public void setCOMMONNO(String COMMONNO) {
        this.COMMONNO = COMMONNO;
    }
    public String getFLOATRULE() {
        return this.FLOATRULE;
    }
    public void setFLOATRULE(String FLOATRULE) {
        this.FLOATRULE = FLOATRULE;
    }
    public String getGUID() {
        return this.GUID;
    }
    public void setGUID(String GUID) {
        this.GUID = GUID;
    }
    public String getPARENTGUID() {
        return this.PARENTGUID;
    }
    public void setPARENTGUID(String PARENTGUID) {
        this.PARENTGUID = PARENTGUID;
    }
    public String getREGION() {
        return this.REGION;
    }
    public void setREGION(String REGION) {
        this.REGION = REGION;
    }
    public String getSITENAME() {
        return this.SITENAME;
    }
    public void setSITENAME(String SITENAME) {
        this.SITENAME = SITENAME;
    }

}
