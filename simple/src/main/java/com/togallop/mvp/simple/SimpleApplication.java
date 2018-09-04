package com.togallop.mvp.simple;

import android.app.Application;

import com.togallop.mvplib.net.HttpManager;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * SimpleApplication:
 */
public class SimpleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpManager.getInstance()
                .setBaseUrl("https://api.github.com/")
                .setDebug(BuildConfig.DEBUG)
                .setOkHttpClient(HttpManager.getInstance().createDefaultClient())
                .setRetrofit(HttpManager.getInstance().createRetrofit());
    }
}
