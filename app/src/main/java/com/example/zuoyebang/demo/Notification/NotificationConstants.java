package com.example.zuoyebang.demo.Notification;

/**
 * Created by ghp on 17/5/17.
 * E-mail guohaiping521@126.com
 */

public class NotificationConstants {

    public static final int TYPE_CHARGING_COMPLETE = 1; //充满电通知
    public static final int TYPE_BOOST_APP = 2; //清理后台应用通知
    public static final int TYPE_LOW_POWER = 3; //低电量提醒通知

    public static final int REQUEST_CODE_CHARGING_COMPLETE = 0x0001; //充满电通知请求码
    public static final int REQUEST_CODE_BOOST_APP = 0x0002; //清理后台应用通知请求码
    public static final int REQUEST_CODE_TYPE_LOW_POWER = 0x0003; //低电量提醒通知

}
