package com.example.zuoyebang.demo.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * Created by ghp on 17/5/17.
 * E-mail guohaiping521@126.com
 * 通知栏引擎类
 */

public class NotificationEngine {
    private NotificationBaseI mBlueprint;

    NotificationEngine(NotificationBaseI rule) {
        this.mBlueprint = rule;
    }

    private Notification createNotification() {
        RemoteViews remoteViews = new RemoteViews(mBlueprint.providerContext().getPackageName(), mBlueprint.getRemoteView());
        mBlueprint.updateRemoteView(remoteViews);
        PendingIntent contentPendingIntent = mBlueprint.getContentPendingIntent(mBlueprint.providerContext());
        PendingIntent deletePendingIntent = mBlueprint.getDeletePendingIntent(mBlueprint.providerContext());
        Context context = mBlueprint.providerContext();
        boolean onGoing = mBlueprint.setOngoing();
        int smallIconId = mBlueprint.setSmallIcon();
        boolean autoCancel = mBlueprint.setAutoCancel();
        boolean showWhen = mBlueprint.setShowWhen();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(smallIconId)
                .setContentIntent(contentPendingIntent)
                .setContent(remoteViews)
                .setAutoCancel(autoCancel)
                .setOngoing(onGoing)
                .setShowWhen(showWhen);
        if (deletePendingIntent != null) {
            builder = builder.setDeleteIntent(deletePendingIntent);
        }
        return builder.build();
    }

    /**
     * 展示通知栏
     *
     * @param notificationId 通知栏id唯一表示  不同通知栏id不能相同 id用来取消通知使用
     */
    public void show(int notificationId) {
        NotificationManager notificationManager = (NotificationManager) mBlueprint.providerContext().getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, createNotification());
    }

    /**
     * 取消通知栏
     * @param notificationId 用来取消通知栏的id
     */
    public void cancel(int notificationId) {
        NotificationManager notificationManager = (NotificationManager) mBlueprint.providerContext().getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationId);
    }
}