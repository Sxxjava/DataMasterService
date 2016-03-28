package org.itsk.datamaster.entity;

/**
 * Created by Jour on 2016/2/25.
 */

/**
 CREATE TABLE `accountinfo` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `userId` int(11) NOT NULL,
 `accountInfo` text NOT NULL COMMENT '账号信息(加密存储)',
 PRIMARY KEY (`id`)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8;
 */
public class AccountInfo {
    /**账号信息表ID*/
    private int id;
    /**所属用户ID*/
    private int userId;
    /**账号信息(加密存储)*/
    private String accountInfo;

    public AccountInfo() {
    	
    }

    public AccountInfo(int userId, String accountInfo) {
        this.userId = userId;
        this.accountInfo = accountInfo;
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

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }
}
