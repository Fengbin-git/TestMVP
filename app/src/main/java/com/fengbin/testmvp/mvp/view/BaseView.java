package com.fengbin.testmvp.mvp.view;

import com.fengbin.testmvp.bean.User;

/**
 * 作者：冯彬 on 2016/11/8 0008 11:55
 * 邮箱：jinbindeveloper@gmail.com
 * 描述：
 */
public interface BaseView {
    void showProgressDialog();
    void hideProgressDialog();
    void showText(User user);
    void showErrorMessage(int text);
}
