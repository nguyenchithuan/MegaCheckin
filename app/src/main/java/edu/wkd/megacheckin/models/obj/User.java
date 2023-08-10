package edu.wkd.megacheckin.models.obj;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id_user")
    private int id;
    @SerializedName("email")
    private String email;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("device_register")
    private String deviceRegister;
    @SerializedName("ip_register")
    private String ipRegister;
    @SerializedName("link_avatar")
    private String linkAvatar;
    @SerializedName("create_at")
    private String createAt;

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", deviceRegister='" + deviceRegister + '\'' +
                ", ipRegister='" + ipRegister + '\'' +
                ", linkAvatar='" + linkAvatar + '\'' +
                ", createAt='" + createAt + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeviceRegister() {
        return deviceRegister;
    }

    public void setDeviceRegister(String deviceRegister) {
        this.deviceRegister = deviceRegister;
    }

    public String getIpRegister() {
        return ipRegister;
    }

    public void setIpRegister(String ipRegister) {
        this.ipRegister = ipRegister;
    }

    public String getLinkAvatar() {
        return linkAvatar;
    }

    public void setLinkAvatar(String linkAvatar) {
        this.linkAvatar = linkAvatar;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
