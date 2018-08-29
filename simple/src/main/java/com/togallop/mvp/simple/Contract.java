package com.togallop.mvp.simple;

import com.togallop.mvplib.base.IBaseView;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * Contract: view presenter 管理
 */
public interface Contract {

    interface MainView extends IBaseView{
        void onShow(String msg);
    }

    interface MainPresenter{
        void getUser();
    }

}
