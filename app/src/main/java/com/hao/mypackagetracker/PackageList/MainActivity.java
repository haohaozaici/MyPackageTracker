package com.hao.mypackagetracker.PackageList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import com.elvishew.xlog.XLog;
import com.hao.mypackagetracker.AddPackage.bean.Package;
import com.hao.mypackagetracker.AddPackage.bean.PackageCompany;
import com.hao.mypackagetracker.R;
import com.hao.mypackagetracker.api.Network;
import com.hao.mypackagetracker.api.PackageApi;
import com.hao.mypackagetracker.base.BaseActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MainActivity extends BaseActivity {

    private Button mButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mButton.setText(R.string.title_home);
                    getPackageCompany();
                    return true;
                case R.id.navigation_dashboard:
                    mButton.setText(R.string.title_dashboard);
                    getPackage();
                    return true;
                case R.id.navigation_notifications:
                    mButton.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private void getPackageCompany() {

        String PackageNumber = "70388432404380";
        Network.getApi().getCompany(PackageNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<PackageCompany>() {
                @Override public void onSubscribe(Disposable d) {

                }


                @Override public void onNext(PackageCompany packageCompany) {
                    XLog.d(packageCompany);
                }


                @Override public void onError(Throwable e) {

                }


                @Override public void onComplete() {

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
                @Override public void onSubscribe(Disposable d) {

                }


                @Override public void onNext(Package packageInfo) {
                    XLog.d(packageInfo);
                }


                @Override public void onError(Throwable e) {

                }


                @Override public void onComplete() {

                }
            });
    }

}
