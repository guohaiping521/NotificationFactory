package com.example.zuoyebang.demo.Notification;

import android.app.PendingIntent;
import android.content.Context;
import android.view.View;
import android.widget.RemoteViews;

import com.example.zuoyebang.demo.R;


/**
 * Created by ghp on 17/5/17.
 * E-mail guohaiping521@126.com
 * 通知栏设计蓝图接口适配器
 */

public abstract class NotificationBase implements NotificationBaseI {
    protected Context context;


    public NotificationBase(Context context) {
        //防止内存泄漏
        this.context = context.getApplicationContext();
    }

    /**
     * 默认返回的布局
     *
     * @return 布局id
     */
    @Override
    public int getRemoteView() {
        return R.layout.common_notify_layout;
    }

    /**
     * 默认设置的通知栏样式
     */
    @Override
    public void updateRemoteView(RemoteViews remoteViews) {
        remoteViews.setInt(R.id.common_notify_img, "setBackgroundResource", getMipmapId());
        remoteViews.setTextViewText(R.id.common_notify_title_txt, getTitleId());
        remoteViews.setTextViewText(R.id.common_notify_description_txt, getDescriptionId());
        remoteViews.setViewVisibility(R.id.common_notify_corner_img, View.GONE);
        remoteViews.setViewVisibility(R.id.common_notify_open_txt, View.GONE);
    }

    /**
     * 默认小图标
     *
     * @return 小图标资源ID
     */
    @Override
    public int setSmallIcon() {
        return R.mipmap.ic_launcher;
    }

    @Override
    public boolean setAutoCancel() {
        return true;
    }

    @Override
    public boolean setOngoing() {
        return false;
    }

    @Override
    public boolean setShowWhen() {
        return false;
    }

    @Override
    public Context providerContext() {
        return context;
    }

    @Override
    public PendingIntent getDeletePendingIntent(Context context) {
        return null;
    }

    @Override
    public int getMipmapId() {
        return R.mipmap.ic_launcher;
    }

    @Override
    public String getTitleId() {
        return "demo";
    }

    @Override
    public String getDescriptionId() {
        return "description";
    }
}
