package com.togallop.mvplib.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;

/**
 * Created by DELL on 2018年8月29日 029.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * BaseMvpActivity: MVP activity 基类
 */
public abstract class BaseMvpActivity<P extends BasePresenter<? extends IBaseView>> extends BaseActivity implements IBaseView {

    //主Presenter
    protected P mPresenter;
    //多个Presenter时候需要的容器
    private ArraySet<? extends BasePresenter> mPresenters = new ArraySet<>(4);
    //Loading Dialog
    private Dialog mLoading;

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        mLoading = initLoading();
        mPresenter.attachView(this);
        initView();
        initListener();
        initData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        for (BasePresenter presenter : mPresenters) {
            presenter.detachView();
        }
        mPresenters.clear();
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        if (mLoading != null && !mLoading.isShowing()) {
            mLoading.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mLoading != null && mLoading.isShowing()) {
            mLoading.dismiss();
        }
    }

    @Override
    public void showMsg(String msg) {
        toastS(msg);
    }

    protected abstract P getPresenter();

    /**
     * @return loading Dialog
     */
    protected Dialog initLoading() {
        return new ProgressDialog(this);
    }

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 初始化Listener
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();


}
