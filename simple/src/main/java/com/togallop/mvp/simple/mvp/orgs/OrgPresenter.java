package com.togallop.mvp.simple.mvp.orgs;

import com.togallop.mvplib.base.BasePresenter;
import com.togallop.mvplib.net.HttpResultObserver;
import com.togallop.mvplib.utils.Logger;

import io.reactivex.disposables.Disposable;

/**
 * Created by DELL on 2018年9月4日 004.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * OrgPresenter: org P层
 */
public class OrgPresenter extends BasePresenter<OrgContract.View> implements OrgContract.Presenter {

    private OrgModel mModel;

    private Disposable mDisposable;

    public OrgPresenter() {
        mModel = getModel(OrgModel.class);
    }

    @Override
    public void getOrg(String org) {
        //判断是否正在执行getOrg请求，防止重复请求
        if (isNotDisposed(mDisposable)) {
            Logger.i(mDisposable.isDisposed());
            return;
        }
        mView.showLoading();
        mDisposable = mModel.getOrg(org, new HttpResultObserver<String>() {
            @Override
            protected void onResult(String s) {
                mView.showOrg(s);
                mView.hideLoading();
            }

            @Override
            protected void onFailure(Throwable e) {
                mView.showMsg(e.getMessage());
                mView.hideLoading();
            }
        });
        addDisposable(mDisposable);
    }
}
