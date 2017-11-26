package com.cicinnus.doubanplus.module.movies_detail.model;

/**
 *
 * 影人
 * Created by Cicinnus
 * on 2017/11/25.
 */

public class CastsModel {
    //名字
    private String name;
    //角色
    private String role;
    //头像
    private String avatar;
    //人物主页
    private String castUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCastUrl() {
        return castUrl;
    }

    public void setCastUrl(String castUrl) {
        this.castUrl = castUrl;
    }
}
