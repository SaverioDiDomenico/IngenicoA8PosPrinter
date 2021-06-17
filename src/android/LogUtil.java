package it.dynamicid;

import android.util.Log;


public class LogUtil {

    public static void d(String message) {
        Log.d(DemoConfig.TAG, message);
    }

    public static void e(String message) {
        Log.e(DemoConfig.TAG, message);
    }
}
