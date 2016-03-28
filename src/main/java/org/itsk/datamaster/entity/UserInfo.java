package org.itsk.datamaster.entity;

/**
 * Created by Jour on 2016/2/25.
 */
public class UserInfo {
    private int id;
    private String phone;
    private String password;
    private String nickname;
    private String photopwd;
    private String numberpwd;
    private String thumb;

    public UserInfo(String phone, String password, String nickname, String thumb) {
        this.phone = phone;
        this.password = password;
        this.nickname = nickname;
        this.thumb = thumb;
    }

    public UserInfo(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public UserInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhotopwd() {
		return photopwd;
	}

	public void setPhotopwd(String photopwd) {
		this.photopwd = photopwd;
	}

	public String getNumberpwd() {
		return numberpwd;
	}

	public void setNumberpwd(String numberpwd) {
		this.numberpwd = numberpwd;
	}

	public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
