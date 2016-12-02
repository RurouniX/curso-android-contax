package com.requestwithlist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 627803 on 23/11/2016.
 */

public class Cars {

    @SerializedName("carro")
    public List<Car> car;
}
