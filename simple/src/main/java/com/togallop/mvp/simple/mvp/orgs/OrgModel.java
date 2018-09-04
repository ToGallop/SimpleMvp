package com.togallop.mvp.simple.mvp.orgs;

import com.togallop.mvp.simple.mvp.BaseModel;
import com.togallop.mvplib.net.HttpResultObserver;

import io.reactivex.disposables.Disposable;

/**
 * Created by DELL on 2018年9月4日 004.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * OrgModel: org 相关数据model
 */
public class OrgModel extends BaseModel {

    public Disposable getOrg(String org, HttpResultObserver<String> observer) {
        return getApiService().getOrg(org).subscribeWith(observer);
    }

}
