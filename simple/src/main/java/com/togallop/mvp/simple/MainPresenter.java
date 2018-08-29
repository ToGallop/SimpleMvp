package com.togallop.mvp.simple;

import com.togallop.mvplib.base.BasePresenter;
import com.togallop.mvplib.net.HttpResultObserver;

import io.reactivex.disposables.Disposable;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * MainPresenter:
 */
public class MainPresenter extends BasePresenter<Contract.MainView> implements Contract.MainPresenter {

    private Model mModel;

    public MainPresenter() {
        mModel = getModel(Model.class);
    }

    @Override
    public void getUser() {
        mView.showLoading();
        Disposable disposable = mModel.getUser("togallop", new HttpResultObserver<String>() {
            @Override
            protected void onResult(String s) {
                mView.onShow(s);
                mView.hideLoading();
            }

            @Override
            protected void onFailure(Throwable e) {
                mView.onShow(e.getMessage());
                mView.hideLoading();
            }
        });
        addDisposable(disposable);
    }
}
