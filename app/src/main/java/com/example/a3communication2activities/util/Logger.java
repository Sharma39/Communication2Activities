package com.example.a3communication2activities.util;

import android.util.Log;

public class Logger {
    public static final String TAG = "TAG_X";

    public static void logDebug(String message){
        Log.d(TAG, message);
    }

    public static void logError(String message){
        Log.e(TAG, message);
    }
}
