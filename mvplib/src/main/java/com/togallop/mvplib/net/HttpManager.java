package com.togallop.mvplib.net;

import android.support.annotation.NonNull;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by DELL on 2018年8月28日 028.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * HttpManager: Http 网络请求管理
 */
public final class HttpManager {

    private Retrofit mRetrofit;
    // TODO: 2018年8月30日 030 URL要改
    private String mBaseUrl = "https://api.github.com/";
    private OkHttpClient mOkHttpClient;
    private Boolean debug = true;

    private final Logger LOG = Logger.getLogger(HttpManager.class.getName());

    private HttpManager() {
        mRetrofit = createRetrofit();
    }

    public static HttpManager getInstance() {
        return Holder.INSTANCE;
    }

    public HttpManager setOkHttpClient(OkHttpClient okHttpClient) {
        this.mOkHttpClient = okHttpClient;
        return Holder.INSTANCE;
    }

    public HttpManager setBaseUrl(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
        return Holder.INSTANCE;
    }

    public HttpManager setDebug(Boolean debug) {
        this.debug = debug;
        return Holder.INSTANCE;
    }

    public <T> T getApiService(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

    private Retrofit createRetrofit() {
        mOkHttpClient = createDefaultClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(mOkHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addCallAdapterFactory(ObserveOnMainCallAdapterFactory.createMainScheduler());
        return builder.build();
    }

    /**
     * @return OkHttpclient
     */
    public OkHttpClient createDefaultClient() {
        final int timeOut = 10;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .proxy(Proxy.NO_PROXY);

        if (debug) {
            builder.addInterceptor(new HttpLoggingInterceptor(new InterceptorLogInfo()));
        }

        return builder.build();
    }

    private static class Holder {
        private static final HttpManager INSTANCE = new HttpManager();
    }

    /**
     * info 等级log
     */
    private class InterceptorLogInfo implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(@NonNull String message) {
            LOG.log(Level.INFO, message);
        }
    }

}
