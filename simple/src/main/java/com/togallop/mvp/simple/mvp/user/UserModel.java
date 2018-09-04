package com.togallop.mvp.simple.mvp.user;

import com.togallop.mvp.simple.ApiService;
import com.togallop.mvp.simple.mvp.BaseModel;
import com.togallop.mvplib.base.IBaseModel;
import com.togallop.mvplib.net.HttpManager;
import com.togallop.mvplib.net.HttpResultObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * UserModel: 用户相关信息model
 */
public class UserModel extends BaseModel {

    public Disposable getUser(String userName, HttpResultObserver<String> observer) {
        return getApiService().getUser(userName).subscribeWith(observer);
    }

}
