package com.fengbin.testmvp.bean;

/**
 * 作者：冯彬 on 2016/11/8 0008 11:35
 * 邮箱：jinbindeveloper@gmail.com
 * 描述：
 */
public class User {
    private String login;
    private String name;
    private int followers;
    private int following;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public User() {

    }
}
