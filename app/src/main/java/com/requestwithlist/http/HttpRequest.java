package com.requestwithlist.http;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 627803 on 25/11/2016.
 */

public class HttpRequest {

    private static HttpRequest httpRequest;
    private final Context mContext;
    static Api mApi;
    static boolean isDev = true;

    public HttpRequest(Context context) {
        this.mContext = context;
    }

    public static Api getApiInstance(Context context) {

        if (mApi == null) {
            String url = "";
            if(isDev){
                url = "http://www.livroandroid.com.br/livro/carros/";
            }else {
                url = "http://www.livroandroid.com.br/livro/carros/";
            }
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApi = retrofit.create(Api.class);
            return mApi;
        } else {
            return mApi;
        }
    }



}
