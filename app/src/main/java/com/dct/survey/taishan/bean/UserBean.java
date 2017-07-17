package com.dct.survey.taishan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 创建： fuwei
 * 日期： 2017-07-10 下午 10:14
 * 描述： 用户信息
 */

@Entity
public class UserBean {

    /**
     * DEPTNAME : null
     * EMAIL : null
     * GUID : 0117124e-0480-4288-8ac7-2dd0abc45e1c
     * HEADURL :
     * LOGINNAME : 1121
     * LOGINPASSWORD : A01610228FE998F515A72DD730294D87
     * PHONE : null
     * QQ : null
     * QQGROUP : null
     * REALNAME : 121
     * ROLENAME :
     * SEX : null
     * STATE : null
     * TITLE : null
     * USERCOUNT :
     * WORKSITEARR : null
     */

    private String DEPTNAME;
    private String EMAIL;
    @Unique
    private String GUID;
    private String HEADURL;
    private String LOGINNAME;
    private String LOGINPASSWORD;
    private String PHONE;
    private String QQ;
    private String QQGROUP;
    private String REALNAME;
    private String ROLENAME;
    private String SEX;
    private String STATE;
    private String TITLE;
    private String USERCOUNT;
    private String WORKSITEARR;

    @Generated(hash = 438718866)
    public UserBean(String DEPTNAME, String EMAIL, String GUID, String HEADURL,
            String LOGINNAME, String LOGINPASSWORD, String PHONE, String QQ,
            String QQGROUP, String REALNAME, String ROLENAME, String SEX,
            String STATE, String TITLE, String USERCOUNT, String WORKSITEARR) {
        this.DEPTNAME = DEPTNAME;
        this.EMAIL = EMAIL;
        this.GUID = GUID;
        this.HEADURL = HEADURL;
        this.LOGINNAME = LOGINNAME;
        this.LOGINPASSWORD = LOGINPASSWORD;
        this.PHONE = PHONE;
        this.QQ = QQ;
        this.QQGROUP = QQGROUP;
        this.REALNAME = REALNAME;
        this.ROLENAME = ROLENAME;
        this.SEX = SEX;
        this.STATE = STATE;
        this.TITLE = TITLE;
        this.USERCOUNT = USERCOUNT;
        this.WORKSITEARR = WORKSITEARR;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public String getDEPTNAME() {
        return DEPTNAME;
    }

    public void setDEPTNAME(String DEPTNAME) {
        this.DEPTNAME = DEPTNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getHEADURL() {
        return HEADURL;
    }

    public void setHEADURL(String HEADURL) {
        this.HEADURL = HEADURL;
    }

    public String getLOGINNAME() {
        return LOGINNAME;
    }

    public void setLOGINNAME(String LOGINNAME) {
        this.LOGINNAME = LOGINNAME;
    }

    public String getLOGINPASSWORD() {
        return LOGINPASSWORD;
    }

    public void setLOGINPASSWORD(String LOGINPASSWORD) {
        this.LOGINPASSWORD = LOGINPASSWORD;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getQQGROUP() {
        return QQGROUP;
    }

    public void setQQGROUP(String QQGROUP) {
        this.QQGROUP = QQGROUP;
    }

    public String getREALNAME() {
        return REALNAME;
    }

    public void setREALNAME(String REALNAME) {
        this.REALNAME = REALNAME;
    }

    public String getROLENAME() {
        return ROLENAME;
    }

    public void setROLENAME(String ROLENAME) {
        this.ROLENAME = ROLENAME;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getUSERCOUNT() {
        return USERCOUNT;
    }

    public void setUSERCOUNT(String USERCOUNT) {
        this.USERCOUNT = USERCOUNT;
    }

    public String getWORKSITEARR() {
        return WORKSITEARR;
    }

    public void setWORKSITEARR(String WORKSITEARR) {
        this.WORKSITEARR = WORKSITEARR;
    }
}
