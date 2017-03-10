package com.hao.mypackagetracker.base;

import android.support.v7.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by haohao on 2017/3/10.
 */

public class BaseActivity extends AppCompatActivity {

    protected Disposable dispose;
    protected Observable mObservable;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }

    protected void unsubscribe() {
        // if (mObservable != null && !mObservable.isDisposed()) {
        //     dispose.dispose();
        // }
    }

}
