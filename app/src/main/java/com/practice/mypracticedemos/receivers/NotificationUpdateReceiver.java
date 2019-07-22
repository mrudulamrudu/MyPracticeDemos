package com.practice.mypracticedemos.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.practice.mypracticedemos.utils.DataUtils;

public class NotificationUpdateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        DataUtils.showToast(context,"Hey! You clicked me.");
        //This is used to close the notification tray
        Intent intentClose = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        context.sendBroadcast(intentClose);
    }
}
