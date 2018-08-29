package com.togallop.mvplib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by DELL on 2018年8月30日 030.
 * E-Mail:n.zjx@163.com
 * SimpleMvp
 * ToastUtil: toast 工具类
 */
public final class ToastUtil {

    private static Toast sToast;

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    /**
     * toast duration = LENGTH_SHORT
     */
    public static void toastS(Context context, @NonNull String info) {
        showToast(context, info, Toast.LENGTH_SHORT);
    }

    /**
     * toast duration = LENGTH_SHORT
     */
    public static void toastS(Context context, @StringRes int info) {
        showToast(context, info, Toast.LENGTH_SHORT);
    }

    /**
     * toast duration = LENGTH_LONG
     */
    public static void toastL(Context context, @NonNull String info) {
        showToast(context, info, Toast.LENGTH_LONG);
    }

    /**
     * toast duration = LENGTH_LONG
     */
    public static void toastL(Context context, @StringRes int info) {
        showToast(context, info, Toast.LENGTH_LONG);
    }

    private static void showToast(final Context context, final CharSequence msg, final int duration) {
        HANDLER.post(new Runnable() {
            @SuppressLint("ShowToast")
            @Override
            public void run() {
                if (sToast == null) {
                    sToast = Toast.makeText(context, msg, duration);
                } else {
                    sToast.setText(msg);
                    sToast.setDuration(duration);
                }
                sToast.show();
            }
        });
    }

    private static void showToast(final Context context, @StringRes final int msg, final int duration) {
        HANDLER.post(new Runnable() {
            @SuppressLint("ShowToast")
            @Override
            public void run() {
                if (sToast == null) {
                    sToast = Toast.makeText(context, msg, duration);
                } else {
                    sToast.setText(msg);
                    sToast.setDuration(duration);
                }
                sToast.show();
            }
        });
    }

}
