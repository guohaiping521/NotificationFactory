package com.example.zuoyebang.demo.Notification;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zuoyebang.demo.R;

import static com.example.zuoyebang.demo.Notification.NotificationConstants.TYPE_CHARGING_COMPLETE;

/**
 * 1.解耦了，最起码的新手能够上手了，不用关心底层咋实现的
 * 2.api 改了 你原来方法 是不是 每个通知 都得改
 * 3.你原来加一个通知改一次 utils 类  如果100个人同时都改这个utils 类 呢，互不干扰
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_send_notification_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationFactory instance = NotificationFactory.getInstance();
                NotificationEngine notificationEngine = instance.create(new ApplockNotification(MainActivity.this));
                notificationEngine.show(TYPE_CHARGING_COMPLETE);
            }
        });
    }
}
