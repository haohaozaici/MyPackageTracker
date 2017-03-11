package com.hao.mypackagetracker.data.api;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haohao on 2017/3/10.
 */

public class Network {

    private static PackageApi sPackageApi;


    public static PackageApi getApi() {
        return sPackageApi = createRetrofit().create(PackageApi.class);
    }


    private static Retrofit createRetrofit() {

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();

        return new Retrofit.Builder()
            .client(mOkHttpClient)
            .baseUrl(PackageApi.API_HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    }

}
