package com.dct.survey.taishans.bean;

/**
 * 创建：Android
 * 日期：2017/7/10 13:38
 * 描述：登陆返回的信息
 */

public class LoginBean {

    /**
     * fileName : null
     * isTrue : false
     * messaage : null
     */

    private String fileName;
    private boolean isTrue;
    private String messaage;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isIsTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public String getMessaage() {
        return messaage;
    }

    public void setMessaage(String messaage) {
        this.messaage = messaage;
    }
}
