package com.hao.mypackagetracker;

import android.app.Application;
import com.hao.mypackagetracker.SettingPreference.Setting;

/**
 * Created by hao on 2017/3/8.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Setting setting = Setting.getInstance(getApplicationContext());

    }
}
