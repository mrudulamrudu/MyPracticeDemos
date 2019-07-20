package com.practice.mypracticedemos.activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import com.practice.mypracticedemos.R;

public class NotificationsActivity extends BaseActivity implements View.OnClickListener {

    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private static final int NOTIFICATION_ID = 999;
    private NotificationManager notificationManager;
    private Button btnShowNotification, btnUpdateNotification, btnCancelNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        registerViews();
    }

    void setNotificationButtonState(Boolean isNotifyEnabled,
                                    Boolean isUpdateEnabled,
                                    Boolean isCancelEnabled) {
        btnShowNotification.setEnabled(isNotifyEnabled);
        btnUpdateNotification.setEnabled(isUpdateEnabled);
        btnCancelNotification.setEnabled(isCancelEnabled);
    }

    private void registerViews() {
        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setToolBar(toolbar, getString(R.string.notifications));

        btnShowNotification = findViewById(R.id.btnShowNotification);
        btnUpdateNotification = findViewById(R.id.btnUpdateNotification);
        btnCancelNotification = findViewById(R.id.btnCancelNotification);

        setNotificationButtonState(true, false, false);

        btnShowNotification.setOnClickListener(this);
        btnUpdateNotification.setOnClickListener(this);
        btnCancelNotification.setOnClickListener(this);

    }

    private void createNotification() {

        setNotificationButtonState(false, true, true);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = getNotificationBuilder();
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(getString(R.string.app_name))
                .setAutoCancel(true)
                .setColor(Color.BLUE)
                .setStyle(new NotificationCompat.BigTextStyle().
                        bigText("Hey! you there..?"))
                .setContentIntent(notificationPendingIntent);
        notificationBuilder.setPriority(NotificationCompat.PRIORITY_MAX);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Primary Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        return new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID);
    }

    private void updateNotification() {
        if (notificationManager != null) {
            setNotificationButtonState(false, false, true);
            Bitmap androidImage = BitmapFactory.decodeResource(getResources(), R.drawable.mascot);
            NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
            notifyBuilder.setStyle(new NotificationCompat.BigPictureStyle()
                    .bigPicture(androidImage)
                    .setBigContentTitle("Notification Updated!"))
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(getString(R.string.app_name))
                    .setAutoCancel(true)
                    .setColor(Color.BLUE);
            notificationManager.notify(NOTIFICATION_ID, notifyBuilder.build());
        }
    }

    private void cancelNotification() {
        if (notificationManager != null) {
            setNotificationButtonState(true, false, false);
            notificationManager.cancel(NOTIFICATION_ID);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowNotification:
                createNotification();
                break;
            case R.id.btnUpdateNotification:
                updateNotification();
                break;
            case R.id.btnCancelNotification:
                cancelNotification();
                break;
        }
    }
}
