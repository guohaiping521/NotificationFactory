package com.example.zuoyebang.demo.Notification;

import android.app.PendingIntent;
import android.content.Context;
import android.widget.RemoteViews;


/**
 * Created by ghp on 17/5/17.
 * E-mail guohaiping521@126.com
 * 通知栏设计蓝图接口
 */


interface NotificationBaseI {
    /**
     * 获取notification点击意图
     *
     * @param context 环境上下文
     * @return PendingIntent
     */
    PendingIntent getContentPendingIntent(Context context);

    /**
     * 获取notification取消意图
     *
     * @param context 环境上下文
     * @return PendingIntent
     */
    PendingIntent getDeletePendingIntent(Context context);

    /**
     * 自定义通知栏layout 资源id
     *
     * @return 布局资源id
     */
    int getRemoteView();

    /**
     * 通知栏ui更是
     *
     * @param remoteViews 通知栏布局view
     */
    void updateRemoteView(RemoteViews remoteViews);

    /**
     * 设置通知栏小图标
     *
     * @return 小图标资源id
     */
    int setSmallIcon();

    /**
     * 设置是否可以取消
     *
     * @return 取消结果  true 可以取消
     */
    boolean setAutoCancel();

    /**
     * 设置是否是正在进行的通知
     *
     * @return 结果 true 表示正在更新
     */
    boolean setOngoing();

    /**
     * 是否允许set when
     *
     * @return true  允许
     */
    boolean setShowWhen();

    /**
     * 环境提供环境上下文
     *
     * @return 环境上下文
     */
    Context providerContext();

    int getMipmapId();

    String getTitleId();

    String getDescriptionId();
}
