package com.fengbin.testmvp.mvp.model;

import com.fengbin.testmvp.bean.User;
import com.fengbin.testmvp.retrofit.HttpMethod;

import rx.Subscriber;

/**
 * 作者：冯彬 on 2016/11/8 0008 13:45
 * 邮箱：jinbindeveloper@gmail.com
 * 描述：
 */
public class MainModel implements BaseModel {
    @Override
    public void getUser(String loginName, Subscriber<User> subscriber) {
        HttpMethod.getInstance().getUser(loginName,subscriber);
    }
}
