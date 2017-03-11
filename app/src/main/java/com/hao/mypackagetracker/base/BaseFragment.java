package com.hao.mypackagetracker.base;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by haohao on 2017/3/10.
 */

public class BaseFragment extends Fragment {

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onDestroy() {
        super.onDestroy();
        clearSubscribe();
    }


    public void clearSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }
}
