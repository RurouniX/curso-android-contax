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
    View mViewError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mList = (RecyclerView) findViewById(R.id.main_list);
        mViewLoading = findViewById(R.id.main_layout_loading);
        mViewError = findViewById(R.id.main_layout_error);

        findViewById(R.id.main_btn_try_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoadingView();
                doRequest();

            }
        });

        doRequest();

        mList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
    }

    private void doRequest() {
        Call<CarList> call = HttpRequest.getApiInstance(mContext).getCarList();
        call.enqueue(new Callback<CarList>() {
            @Override
            public void onResponse(Call<CarList> call, Response<CarList> response) {

                if (response.isSuccessful()) {
                    showSuccessView();
                    mList.setAdapter(new CarAdapter(mContext, response.body().cars.car));

                } else {
                    showErroView();
                }
            }

            @Override
            public void onFailure(Call<CarList> call, Throwable t) {

                showErroView();
            }
        });
    }

    private void showLoadingView() {

        mViewLoading.setVisibility(View.VISIBLE);
        mViewError.setVisibility(View.GONE);
        mList.setVisibility(View.GONE);

    }

    private void showSuccessView() {
        mViewLoading.setVisibility(View.GONE);
        mViewError.setVisibility(View.GONE);
        mList.setVisibility(View.VISIBLE);
    }

    private void showErroView() {
        mViewLoading.setVisibility(View.GONE);
        mViewError.setVisibility(View.VISIBLE);
        mList.setVisibility(View.GONE);
    }

}
