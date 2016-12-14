package com.requestwithlist.ui.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Car fusca = (Car) getIntent().getSerializableExtra("carro");

        mBtnMap = (Button) findViewById(R.id.desc_btn_map);
        mBtnWeb = (Button) findViewById(R.id.desc_btn_web);
        mTxtDesc = (TextView) findViewById(R.id.desc_txt_desc);
        mTxtTitle = (TextView) findViewById(R.id.desc_txt_title);
        mImgHeader = (ImageView) findViewById(R.id.desc_img_header);

        Glide.with(this).load(fusca.urlPhoto).into(mImgHeader);

        mTxtDesc.setText(fusca.desc);
        mTxtTitle.setText(fusca.name);

        Snackbar.make(findViewById(R.id.activity_description), fusca.name, Snackbar.LENGTH_SHORT).show();
    }
}
