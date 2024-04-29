package com.example.websocketcommtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start the background service
        Intent serviceIntent = new Intent(this, BackgroundService.class);
        startService(serviceIntent);

        // Finish the activity
        finish();
    }
}
