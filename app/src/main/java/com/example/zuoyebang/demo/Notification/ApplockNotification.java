package com.example.zuoyebang.demo.Notification;

import android.app.PendingIntent;
import android.content.Context;

import com.example.zuoyebang.demo.R;

/**
 * Created by ghp on 17/5/17.
 * E-mail guohaiping521@126.com
 */

public class ApplockNotification extends NotificationBase {

    public ApplockNotification(Context context) {
        super(context);
    }

    @Override
    public PendingIntent getContentPendingIntent(Context context) {
        return null;
    }

    @Override
    public int getMipmapId() {
        return R.mipmap.ic_launcher;
    }

    @Override
    public String getTitleId() {
        return context.getString(R.string.app_name);
    }

    @Override
    public String getDescriptionId() {
        return context.getString(R.string.app_name);
    }

}
