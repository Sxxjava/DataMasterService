package org.itsk.datamaster.entity;

import com.google.gson.Gson;

/**
 * Created by Jour on 2016/3/8.
 */
public class SettingItems {
    private int id;
    private int userId;
    private int autoSync;
    private int enterPassword;
    private int enterPhotoPassword;
    private String photoPwd;
    private String numberPwd;
    private String encryptKey;
    private String ivParameter;

    public SettingItems(int userId, int autoSync, int enterPassword, int enterPhotoPassword) {
        this.userId = userId;
        this.autoSync = autoSync;
        this.enterPassword = enterPassword;
        this.enterPhotoPassword = enterPhotoPassword;

    }

    public SettingItems() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAutoSync() {
        return autoSync;
    }

    public void setAutoSync(int autoSync) {
        this.autoSync = autoSync;
    }

    public int getEnterPassword() {
        return enterPassword;
    }

    public void setEnterPassword(int enterPassword) {
        this.enterPassword = enterPassword;
    }

    public int getEnterPhotoPassword() {
        return enterPhotoPassword;
    }

    public void setEnterPhotoPassword(int enterPhotoPassword) {
        this.enterPhotoPassword = enterPhotoPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhotoPwd() {
        return photoPwd;
    }

    public void setPhotoPwd(String photoPwd) {
        this.photoPwd = photoPwd;
    }

    public String getNumberPwd() {
        return numberPwd;
    }

    public void setNumberPwd(String numberPwd) {
        this.numberPwd = numberPwd;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getIvParameter() {
        return ivParameter;
    }

    public void setIvParameter(String ivParameter) {
        this.ivParameter = ivParameter;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
