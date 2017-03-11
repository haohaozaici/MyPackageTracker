package com.hao.mypackagetracker.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.hao.mypackagetracker.data.bean.Package;
import com.hao.mypackagetracker.data.bean.PackageArray;

import java.util.ArrayList;

/**
 * Created by haohao on 2017/3/11.
 */

public enum PackageSharedPreferenceData {

    instance;

    private ArrayList<Package> data;
    private ArrayList<Package> delivered, delivering;
    private SharedPreferences mPreferences;
    private static final String PACKAGE_DATA = PackageData.class.getSimpleName();


    public void init(Context context) {
        loadAllData(context);
    }

    public ArrayList<Package> getData(){
        return data;
    }


    public void addSingleData(Package packageData) {
        this.data.add(packageData);
    }


    public void saveAllData(Activity activity) {
        mPreferences = activity.getSharedPreferences(PACKAGE_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        PackageArray packageArray = new PackageArray(data);
        editor.putString(PACKAGE_DATA, new Gson().toJson(packageArray));
        editor.apply();
    }


    public void loadAllData(Context context) {
        mPreferences = context.getSharedPreferences(PACKAGE_DATA, Context.MODE_PRIVATE);
        String dataJson = mPreferences.getString(PACKAGE_DATA, "{\"data\":[]}");
        Gson gson = new Gson();
        data = gson.fromJson(dataJson, PackageArray.class).data;
    }


    public void loadDeliveredData() {

    }

}
