package com.hao.mypackagetracker.SettingPreference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hao on 2017/3/8.
 */

public class Setting {

    /*饿汉式加载*/
    private static Setting instance;


    private Setting(Context context) {
        mPrefs = context.getSharedPreferences(SETTING_XML, Context.MODE_PRIVATE);
    }


    public static Setting getInstance(Context context) {
        return instance = new Setting(context);
    }


    public static final String SETTING_XML = "settings";
    public static final String KEY_FIRST_RUN = "first_run";

    private SharedPreferences mPrefs;


    public void putBoolean(String key, boolean value) {
        mPrefs.edit().putBoolean(key, value).apply();
    }


    public boolean getBoolean(String key, boolean defult) {
        return mPrefs.getBoolean(key, defult);
    }


    public void putInt(String key, int value) {
        mPrefs.edit().putInt(key, value).apply();

    }


    public int getInt(String key, int defult) {
        return mPrefs.getInt(key, defult);
    }


    public void putString(String key, String value) {
        mPrefs.edit().putString(key, value).apply();
    }


    public String getString(String key, String defult) {
        return mPrefs.getString(key, defult);
    }

}
