package com.lexinsmart.xushun.loggertest;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by xushun on 2017/3/28.
 */

public class LoggerDemoApplication extends Application {
    private String TAG = "LoggerDEMO";

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(TAG);
    }
}
