package com.hao.mypackagetracker.PackageList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import com.elvishew.xlog.XLog;
import com.hao.mypackagetracker.AddPackage.AddActivity;
import com.hao.mypackagetracker.R;
import com.hao.mypackagetracker.data.PackageSharedPreferenceData;
import com.hao.mypackagetracker.data.bean.Package;
import com.hao.mypackagetracker.data.bean.PackageCompany;
import com.hao.mypackagetracker.data.api.Network;
import com.hao.mypackagetracker.base.BaseActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ft.replace(R.id.container, new MainListFragment());
                    break;
                case R.id.navigation_dashboard:
//                    ft.replace(R.id.container, new GradeFragment());
                    break;
                case R.id.navigation_notifications:
//                    ft.replace(R.id.container, new GradeFragment());
                    break;
            }
            ft.commit();
            return true;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.container, new MainListFragment());
        ft.commit();
    }


    @Override
    protected void setUpViews() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }



}
