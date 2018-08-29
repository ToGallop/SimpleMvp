package com.togallop.mvp.simple;

import com.togallop.mvplib.base.IBaseModel;
import com.togallop.mvplib.net.HttpManager;
import com.togallop.mvplib.net.HttpResultObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * Model:
 */
public class Model implements IBaseModel {

    private ApiService apiService = HttpManager.getInstance().getApiService(ApiService.class);

    public Disposable getUser(String userName, HttpResultObserver<String> observer) {
        return apiService.getUser(userName).observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer);
    }

}
