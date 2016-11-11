package com.fengbin.testmvp.mvp.model;

import com.fengbin.testmvp.bean.User;

import rx.Subscriber;

/**
 * 作者：冯彬 on 2016/11/8 0008 13:30
 * 邮箱：jinbindeveloper@gmail.com
 * 描述：
 */
public interface BaseModel {
    void getUser(String loginName, Subscriber<User> subscriber);
}
