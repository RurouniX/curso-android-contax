package com.requestwithlist.http;

import com.requestwithlist.model.CarList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 627803 on 25/11/2016.
 */
public interface Api {

    @GET("carros_luxo.json")
    Call<CarList> getCarList();


}
