package com.example.websocketcommtest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import android.widget.TextView;
import android.os.Handler;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class BackgroundService extends Service {
    private static final String TAG = "BackgroundService";
    private static final long INTERVAL = 1000; // 1 second
    private Handler handler;
    private int count = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        // Perform any setup tasks here
        handler = new Handler();
        startCounting();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Define the behavior of your service here
        // This method is called each time the service is started
        return START_STICKY; // If the service is killed, it will be restarted automatically
    }


    @Override
    public IBinder onBind(Intent intent) {
        // Return null because this service does not support binding
        return null;
    }

    private void startCounting() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                count++;
                Log.d(TAG, "Count" + count);
                handler.postDelayed(this, INTERVAL);
            }
        }, INTERVAL);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Release any resources here
    }
}
