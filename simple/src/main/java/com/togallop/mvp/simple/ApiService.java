package com.togallop.mvp.simple;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * ApiService:
 */
public interface ApiService {

    @GET("users/{username}")
    Single<String> getUser(@Path("username") String userName);

    @GET("orgs/{org}")
    Single<String> getOrg(@Path("org") String org);

}
