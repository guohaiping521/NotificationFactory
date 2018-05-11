package com.example.zuoyebang.demo.Notification;

/**
 * Created by ghp on 17/5/17.
 * E-mail guohaiping521@126.com
 * 通知栏工厂类
 */

public class NotificationFactory {

    private static NotificationFactory mNotificationFactory = null;

    private NotificationFactory() {
    }


    public static NotificationFactory getInstance() {
        if (mNotificationFactory == null) {
            synchronized (NotificationFactory.class) {
                if (mNotificationFactory == null) {
                    mNotificationFactory = new NotificationFactory();
                }
            }
        }
        return mNotificationFactory;
    }

    /**
     * 获取通知栏引擎类
     *
     * @param strategy 通知栏样式策略
     * @return 通知栏引擎类
     */
    public NotificationEngine create(NotificationBaseI strategy) {
        return new NotificationEngine(strategy);
    }
}
