package com.togallop.mvplib.base;

/**
 * Created by DELL on 2018年8月29日 029.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * IBaseView: MVP V 层Base接口定义
 */
public interface IBaseView {

    /**
     * @param msg 显示文本信息
     */
    void showMsg(String msg);

    /**
     * 显示loading
     */
    void showLoading();

    /**
     * 带文字信息显示loading
     */
    void showLoading(String msg);

    /**
     * 隐藏loading
     */
    void hideLoading();

}
