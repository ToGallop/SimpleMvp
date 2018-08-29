package com.togallop.mvplib.net;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * HttpResultSubscriber:
 */
public abstract class HttpResultObserver<T> extends DisposableSingleObserver<T> {


    @Override
    public void onSuccess(T t) {
        onResult(t);
    }


    @Override
    public void onError(Throwable e) {
        onFailure(e);
    }

    /**
     * @param t 获取结果
     */
    protected abstract void onResult(T t);

    /**
     * @param e 获取结果失败
     */
    protected abstract void onFailure(Throwable e);

}
