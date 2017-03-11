package com.hao.mypackagetracker.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.hao.mypackagetracker.R;
import com.hao.mypackagetracker.data.PackageSharedPreferenceData;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by haohao on 2017/3/10.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected Toolbar mToolbar;
    protected ActionBar mActionBar;


    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(layoutResId);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            mActionBar = getSupportActionBar();
        }
        setUpViews();
    }


    protected abstract void setUpViews();


    @Override
    protected void onPause() {
        super.onPause();
        PackageSharedPreferenceData.instance.saveAllData(BaseActivity.this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearSubscribe();
    }


    protected void clearSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

}
