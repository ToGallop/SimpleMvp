package com.togallop.mvp.simple;

import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.TextView;

import com.togallop.mvp.simple.mvp.orgs.OrgContract;
import com.togallop.mvp.simple.mvp.orgs.OrgPresenter;
import com.togallop.mvp.simple.mvp.user.UserContract;
import com.togallop.mvp.simple.mvp.user.UserPresenter;
import com.togallop.mvplib.base.BaseMvpActivity;

/**
 * Created by DELL on 2018年9月4日 004
 * Describe:
 */
public class MainActivity extends BaseMvpActivity<UserPresenter> implements UserContract.View, OrgContract.View {

    private TextView tvMsg;
    private Button btnClick;
    private Button btnClick2;

    private OrgPresenter mOrgPresenter;

    private ProgressDialog mLoading;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected UserPresenter getPresenter() {
        mOrgPresenter = new OrgPresenter();
        addToPresenters(mOrgPresenter);
        return new UserPresenter();
    }

    @Override
    protected void initView() {
        tvMsg = findViewById(R.id.tv_msg);
        btnClick = findViewById(R.id.btn_click);
        btnClick2 = findViewById(R.id.btn_click2);
        mLoading = new ProgressDialog(this);
    }

    @Override
    protected void initListener() {
        btnClick.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                mPresenter.getUser("togallop");
            }
        });
        btnClick2.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                mOrgPresenter.getOrg("google");
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showUser(String msg) {
        tvMsg.setText(msg);
    }

    @Override
    public void showOrg(String org) {
        tvMsg.setText(org);
    }

    @Override
    public void showLoading(String msg) {
        mLoading.setMessage(msg);
        if (!mLoading.isShowing()) {
            mLoading.show();
        }
    }

    @Override
    public void showLoading() {
        if (!mLoading.isShowing()) {
            mLoading.show();
        }
    }

    @Override
    public void showMsg(String msg) {
        toastS(msg);
    }

    @Override
    public void hideLoading() {
        if (mLoading.isShowing()) {
            mLoading.dismiss();
        }
    }
}
