package com.fengbin.testmvp.mvp.presenter;

import android.text.TextUtils;

import com.fengbin.testmvp.R;
import com.fengbin.testmvp.bean.User;
import com.fengbin.testmvp.mvp.model.BaseModel;
import com.fengbin.testmvp.mvp.model.MainModel;
import com.fengbin.testmvp.mvp.view.BaseView;

import rx.Subscriber;

/**
 * 作者：冯彬 on 2016/11/8 0008 13:36
 * 邮箱：jinbindeveloper@gmail.com
 * 描述：
 */
public class MainPresenter<MainActivity> implements BasePresenter{
    private BaseView mMainView;
    private BaseModel mModel;
    public MainPresenter() {
        mModel = new MainModel();
    }

    @Override
    public void attachView(BaseView view) {
        mMainView = view;
    }

    @Override
    public void detachView() {
        mMainView = null;
    }

    @Override
    public void searchUser(String loginName) {
        if(TextUtils.isEmpty(loginName.trim())) {
            mMainView.showErrorMessage(R.string.error_name);
            return;
        }
        if(mModel != null) {
            mModel.getUser(loginName, new Subscriber<User>() {

                @Override
                public void onStart() {
                    mMainView.showProgressDialog();
                }

                @Override
                public void onCompleted() {
                    mMainView.hideProgressDialog();
                }

                @Override
                public void onError(Throwable e) {
                    mMainView.showErrorMessage(R.string.error_quary);
                }

                @Override
                public void onNext(User user) {
                    mMainView.showText(user);
                }
            });
        }
    }
}
