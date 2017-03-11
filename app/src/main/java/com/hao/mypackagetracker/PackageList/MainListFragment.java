package com.hao.mypackagetracker.PackageList;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.elvishew.xlog.XLog;
import com.hao.mypackagetracker.R;
import com.hao.mypackagetracker.base.BaseFragment;
import com.hao.mypackagetracker.data.PackageSharedPreferenceData;
import com.hao.mypackagetracker.data.api.Network;
import com.hao.mypackagetracker.data.bean.Package;
import com.hao.mypackagetracker.data.bean.PackageCompany;
import com.hao.mypackagetracker.support.SwipeRefreshLayout;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by haohao on 2017/3/11.
 */

public class MainListFragment extends BaseFragment {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private MainListAdapter mainListAdapter = new MainListAdapter(getActivity());
    private LinearLayout mLittleSun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mLittleSun = (LinearLayout) view.findViewById(R.id.empty_view);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mainListAdapter);
        getPackage();

        if (PackageSharedPreferenceData.instance.getData().size() == 0) {
            mLittleSun.setVisibility(View.VISIBLE);
        }

        return view;
    }

    private void getPackageCompany() {

        String PackageNumber = "70388432404380";
        Network.getApi().getCompany(PackageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PackageCompany>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }


                    @Override
                    public void onNext(PackageCompany packageCompany) {
                        XLog.d(packageCompany);
                    }


                    @Override
                    public void onError(Throwable e) {

                    }


                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void getPackage() {
        String companyName = "huitongkuaidi";
        String PackageNumber = "70388432404380";
        Network.getApi().getPackage(companyName, PackageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Package>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }


                    @Override
                    public void onNext(Package packageInfo) {
                        XLog.d(packageInfo);
                        PackageSharedPreferenceData.instance.addSingleData(packageInfo);

                    }


                    @Override
                    public void onError(Throwable e) {

                    }


                    @Override
                    public void onComplete() {

                    }
                });
    }

}
