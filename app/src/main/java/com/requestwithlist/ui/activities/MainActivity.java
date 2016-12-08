package com.requestwithlist.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.requestwithlist.R;
import com.requestwithlist.http.HttpRequest;
import com.requestwithlist.model.Car;
import com.requestwithlist.model.CarList;
import com.requestwithlist.ui.adapters.CarAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView mList;
    Context mContext;
    View mViewLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mList = (RecyclerView) findViewById(R.id.main_list);
        mViewLoading = findViewById(R.id.main_layout_loading);
        Call<CarList> call = HttpRequest.getApiInstance(mContext).getCarList();
        call.enqueue(new Callback<CarList>() {
            @Override
            public void onResponse(Call<CarList> call, Response<CarList> response) {

                mList.setAdapter(new CarAdapter(mContext, response.body().cars.car));

            }

            @Override
            public void onFailure(Call<CarList> call, Throwable t) {
                t.toString();
            }
        });


        mList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));


    }

    private void showLoadingView() {

    }

    private void showSuccessView() {

    }

    private void showErroView() {

    }

}
