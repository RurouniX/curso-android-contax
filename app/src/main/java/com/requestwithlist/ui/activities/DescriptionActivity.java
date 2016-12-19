package com.requestwithlist.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.requestwithlist.R;
import com.requestwithlist.model.Car;

public class DescriptionActivity extends AppCompatActivity {

    ImageView mImgHeader;
    Button mBtnMap;
    Button mBtnWeb;
    TextView mTxtDesc;
    TextView mTxtTitle;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mContext = this;
        Car car = (Car) getIntent().getSerializableExtra("carro");

        mBtnMap = (Button) findViewById(R.id.desc_btn_map);
        mBtnWeb = (Button) findViewById(R.id.desc_btn_web);
        mTxtDesc = (TextView) findViewById(R.id.desc_txt_desc);
        mTxtTitle = (TextView) findViewById(R.id.desc_txt_title);
        mImgHeader = (ImageView) findViewById(R.id.desc_img_header);
        Glide.with(this).load(car.urlPhoto).into(mImgHeader);

        mTxtDesc.setText(car.desc);
        mTxtTitle.setText(car.name);

        mBtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, WebActivity.class));
            }
        });
    }
}
