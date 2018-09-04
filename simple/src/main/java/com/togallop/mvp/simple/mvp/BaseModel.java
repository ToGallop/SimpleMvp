package com.togallop.mvp.simple.mvp;

import com.togallop.mvp.simple.ApiService;
import com.togallop.mvplib.base.IBaseModel;
import com.togallop.mvplib.net.HttpManager;

/**
 * Created by DELL on 2018年9月4日 004.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * BaseModel: 实现IBaseModel基类Model，项目里的请求数据model可以继承BaseModel
 * BaseModel里可以定义Model公共方法
 */
public abstract class BaseModel implements IBaseModel {

    private ApiService apiService;

    protected ApiService getApiService() {
        if (apiService == null) {
            apiService = HttpManager.getInstance().getApiService(ApiService.class);
        }
        return apiService;
    }

}
