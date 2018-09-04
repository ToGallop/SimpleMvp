package com.togallop.mvp.simple.mvp.orgs;

import com.togallop.mvplib.base.IBaseView;

/**
 * Created by DELL on 2018年9月4日 004.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * Contract: org契约类，管理View和Presenter
 */
public interface OrgContract {

    interface View extends IBaseView{
        void showOrg(String org);
    }

    interface Presenter{
        void getOrg(String org);
    }

}
