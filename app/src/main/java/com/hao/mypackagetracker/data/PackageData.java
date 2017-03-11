package com.hao.mypackagetracker.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.hao.mypackagetracker.data.bean.Package;
import com.hao.mypackagetracker.support.FileUtils;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by haohao on 2017/3/11.
 */

public enum PackageData {

    instance;

    @Expose private ArrayList<Package> data;
    private ArrayList<Package> delivered, delivering;
    @Expose private String dataVersion = "1.0.0";
    private static final String FILE_NAME = "packages.json";

    private static final String PACKAGE_DATA = PackageData.class.getSimpleName();
    private Context mContext;

    private void init(Context context){
        this.mContext = context;
    }

    public boolean save() {
        try {
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            FileUtils.saveFile(mContext, FILE_NAME, gson.toJson(this));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void load() {
        String json;
        try {
            json = FileUtils.readFile(mContext, FILE_NAME);
        } catch (IOException e) {
            json = "{\"data\":[]}";
            e.printStackTrace();
        }
        this.data = new Gson().fromJson(json, PackageData.class).data;
        refreshList();
    }


    public void refreshList() {
        delivered = new ArrayList<>();
        delivering = new ArrayList<>();
        for (Package p : data) {
            if (p.getState() == Package.STATUS_DELIVERED) {
                delivered.add(p);
            } else {
                delivering.add(p);
            }
        }
    }


    public void add(Package pack) {
        data.add(pack);
        refreshList();
    }


    public void add(int index, Package pack) {
        data.add(index, pack);
        refreshList();
    }


    public void set(int index, Package pack) {
        data.set(index, pack);
        refreshList();
    }

    // public void remove(int index) {
    //     final Package removedItem = data.remove(index);
    //
    //     lastRemovedData = removedItem;
    //     lastRemovedPosition = index;
    //
    //     refreshList();
    // }
    //
    // public void remove(Package pack) {
    //     int nowPos = indexOf(pack);
    //     remove(nowPos);
    // }
    //
    // public int undoLastRemoval() {
    //     if (lastRemovedData != null) {
    //         int insertedPosition;
    //         if (lastRemovedPosition >= 0 && lastRemovedPosition < data.size()) {
    //             insertedPosition = lastRemovedPosition;
    //         } else {
    //             insertedPosition = data.size();
    //         }
    //
    //         data.add(insertedPosition, lastRemovedData);
    //         refreshList();
    //
    //         lastRemovedData = null;
    //         lastRemovedPosition = -1;
    //
    //         return insertedPosition;
    //     } else {
    //         return -1;
    //     }
    // }


    public ArrayList<Package> getData() {
        return data;
    }


    public ArrayList<Package> getDeliveredData() {
        return delivered;
    }


    public ArrayList<Package> getDeliveringData() {
        return delivering;
    }


    // public int indexOf(Package p) {
    //     return indexOf(p.number);
    // }
    //
    //
    // public int indexOf(String number) {
    //     for (int index = 0; index < size(); index++) {
    //         if (get(index).number.equals(number)) return index;
    //     }
    //     return -1;
    // }


    public int size() {
        return data.size();
    }


    public Package get(int index) {
        return data.get(index);
    }

}
