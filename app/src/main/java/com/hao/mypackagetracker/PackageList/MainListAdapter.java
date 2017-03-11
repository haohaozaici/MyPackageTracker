package com.hao.mypackagetracker.PackageList;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hao.mypackagetracker.R;
import com.hao.mypackagetracker.data.PackageSharedPreferenceData;
import com.hao.mypackagetracker.data.bean.Package;

import java.util.ArrayList;

/**
 * Created by haohao on 2017/3/11.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private ArrayList<Package> mData = new ArrayList<>();
    private Package mPackage;
    private Activity activity;

    public MainListAdapter(Activity activity) {
        this.activity = activity;
        mData = PackageSharedPreferenceData.instance.getData();
        notifyDataSetChanged();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_package_for_widget, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mPackage = mData.get(position);


        try {
            holder.tv_first_char.setText(mPackage.getNu().substring(0, 1));
            holder.tv_title.setText(mPackage.getCom());
            holder.tv_des.setText(mPackage.getData().get(0).getContext());
            holder.tv_time.setText(mPackage.getData().get(0).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_first_char;
        private TextView tv_title;
        private TextView tv_des;
        private TextView tv_time;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_first_char = (TextView) itemView.findViewById(R.id.tv_first_char);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_des = (TextView) itemView.findViewById(R.id.tv_des);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);

        }
    }

}




