package com.example.websocketcommtest;

import android.util.Log;

public class HelloWorld {
    private static final String TAG = "HelloWorld";
    public static void sayHello() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Log.d(TAG, "Hello, World!");
                    try {
                        // Sleep for 3 seconds
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
