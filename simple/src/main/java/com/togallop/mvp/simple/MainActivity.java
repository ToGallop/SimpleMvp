package com.togallop.mvp.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.togallop.mvplib.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements Contract.MainView {

    private TextView tvMsg;
    private Button btnClick;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        tvMsg = findViewById(R.id.tv_msg);
        btnClick = findViewById(R.id.btn_click);
    }

    @Override
    protected void initListener() {
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getUser();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onShow(String msg) {
        tvMsg.setText(msg);
    }
}
