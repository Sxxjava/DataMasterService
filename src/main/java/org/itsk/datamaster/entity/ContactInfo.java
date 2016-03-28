package org.itsk.datamaster.entity;

/**
 * Created by Jour on 2016/2/25.
 */
public class ContactInfo {
    /**账号信息表ID*/
    private int id;
    /**所属用户ID*/
    private int userId;
    /**短信信息(加密存储)*/
    private String contactInfo;

    public ContactInfo() {
    }

    public ContactInfo(int userId, String contactInfo) {
        this.userId = userId;
        this.contactInfo = contactInfo;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
