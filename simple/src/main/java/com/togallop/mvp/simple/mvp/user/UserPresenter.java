package com.togallop.mvp.simple.mvp.user;

import android.text.TextUtils;

import com.togallop.mvplib.base.BasePresenter;
import com.togallop.mvplib.net.HttpResultObserver;

import io.reactivex.disposables.Disposable;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * MainPresenter:
 */
public class UserPresenter extends BasePresenter<UserContract.View> implements UserContract.Presenter {

    private UserModel mModel;

    public UserPresenter() {
        mModel = getModel(UserModel.class);
    }

    @Override
    public void getUser(String userName) {

        if (TextUtils.isEmpty(userName)) {
            mView.showMsg("用户名不能为空");
            return;
        }

        mView.showLoading("正在加载...");
        Disposable disposable = mModel.getUser(userName, new HttpResultObserver<String>() {
            @Override
            protected void onResult(String s) {
                mView.showUser(s);
                mView.hideLoading();
            }

            @Override
            protected void onFailure(Throwable e) {
                mView.showUser(e.getMessage());
                mView.hideLoading();
            }
        });
        addDisposable(disposable);
    }
}
