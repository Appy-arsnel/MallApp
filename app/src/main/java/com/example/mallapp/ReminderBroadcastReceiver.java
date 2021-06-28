package com.example.mallapp;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_baseline_access_alarms_24)
                .setContentTitle("set Reminder")
                .setContentText("Event at mall");
        Intent intentToFire = new Intent(context, Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentToFire, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManagerCompat.from(context).notify((int) System.currentTimeMillis(), builder.build());
    }
}