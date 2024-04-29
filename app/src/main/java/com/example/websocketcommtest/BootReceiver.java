package com.example.websocketcommtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.content.ContextCompat;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            // Start your background service
            Intent serviceIntent = new Intent(context, BackgroundService.class);
            ContextCompat.startForegroundService(context, serviceIntent);
        }
    }
}
