package com.hao.mypackagetracker.data.bean;

import java.util.ArrayList;

/**
 * Created by haohao on 2017/3/11.
 */

public class PackageArray {

    public ArrayList<Package> data;

    public PackageArray(ArrayList<Package> mData){
        this.data = mData;
    }


    public ArrayList<Package> getData() {
        return data;
    }


    public void setData(ArrayList<Package> data) {
        this.data = data;
    }
}
