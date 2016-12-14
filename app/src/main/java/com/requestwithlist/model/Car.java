package com.requestwithlist.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by 627803 on 23/11/2016.
 */
public class Car implements Serializable {

    @SerializedName("nome")
    public String name;
    public String desc;
    @SerializedName("url_info")
    public String urlInfo;
    @SerializedName("url_foto")
    public String urlPhoto;
    @SerializedName("url_video")
    public String urlVideo;
    public String latitude;
    public String longitude;

}
