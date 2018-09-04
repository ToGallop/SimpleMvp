package com.togallop.mvp.simple.mvp.user;

import com.togallop.mvplib.base.IBaseView;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * Contract: view presenter 管理
 */
public interface UserContract {

    interface View extends IBaseView{
        void showUser(String msg);
    }

    interface Presenter {
        void getUser(String userName);
    }

}
