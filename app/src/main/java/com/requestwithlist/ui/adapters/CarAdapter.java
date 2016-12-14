package com.requestwithlist.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.requestwithlist.R;
import com.requestwithlist.model.Car;
import com.requestwithlist.ui.activities.DescriptionActivity;

import java.util.List;

/**
 * Created by 627803 on 23/11/2016.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    Context mContext;
    List<Car> mList;

    public CarAdapter(Context context, List<Car> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {

        final Car car = mList.get(position);

        holder.mViewRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, DescriptionActivity.class);
                intent.putExtra("carro", car);
                mContext.startActivity(intent);
            }
        });

        holder.mTxtTitle.setText(car.name);
        holder.mTxtDesc.setText(car.desc);
        Glide.with(mContext).load(car.urlPhoto).into(holder.mImg);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView mImg;
        TextView mTxtTitle;
        TextView mTxtDesc;
        View mViewRoot;

        public CarViewHolder(View itemView) {
            super(itemView);
            mViewRoot = itemView;
            mImg = (ImageView) itemView.findViewById(R.id.adapter_car_img);
            mTxtTitle = (TextView) itemView.findViewById(R.id.adapter_car_txt_title);
            mTxtDesc = (TextView) itemView.findViewById(R.id.adapter_car_txt_desc);
        }
    }
}
