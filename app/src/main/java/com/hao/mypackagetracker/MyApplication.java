package com.hao.mypackagetracker;

import android.app.Application;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;
import com.hao.mypackagetracker.SettingPreference.Setting;
import com.hao.mypackagetracker.data.PackageSharedPreferenceData;

/**
 * Created by hao on 2017/3/8.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        PackageSharedPreferenceData.instance.init(this);
        //初始化log
        XLog.init(LogLevel.ALL);

        Setting setting = Setting.getInstance(getApplicationContext());

    }
}
