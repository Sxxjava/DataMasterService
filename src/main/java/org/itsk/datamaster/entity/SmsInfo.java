package org.itsk.datamaster.entity;

/**
 * Created by Jour on 2016/2/25.
 */
public class SmsInfo {
    /**账号信息表ID*/
    private int id;
    /**所属用户ID*/
    private int userId;
    /**短信信息(加密存储)*/
    private String smsInfo;

    public SmsInfo() {
    }

    public SmsInfo(int userId, String smsInfo) {
        this.userId = userId;
        this.smsInfo = smsInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSmsInfo() {
        return smsInfo;
    }

    public void setSmsInfo(String smsInfo) {
        this.smsInfo = smsInfo;
    }
}
