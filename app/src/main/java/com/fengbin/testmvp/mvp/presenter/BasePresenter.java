package com.fengbin.testmvp.mvp.presenter;

import com.fengbin.testmvp.mvp.view.BaseView;

/**
 * 作者：冯彬 on 2016/11/8 0008 11:56
 * 邮箱：jinbindeveloper@gmail.com
 * 描述：
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
    void searchUser(String loginName);
}
