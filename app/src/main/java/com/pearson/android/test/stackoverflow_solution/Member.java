package com.pearson.android.test.stackoverflow_solution;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 539117 on 7/27/2016.
 */
public class Member {

    @SerializedName("tee_id")
    int tee_id;

    @SerializedName("tee_name")
    String tee_name;

    @SerializedName("tee_color")
    String tee_color;

    public int getTee_id() {return tee_id;}

    public String getTee_color() {return tee_color;}

    public String getTee_name() {return tee_name;}
}

