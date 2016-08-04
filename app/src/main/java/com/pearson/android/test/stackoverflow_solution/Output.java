package com.pearson.android.test.stackoverflow_solution;

import com.google.gson.annotations.SerializedName;
import com.pearson.android.test.stackoverflow_solution.GolfCourseTee;

/**
 * Created by 539117 on 7/27/2016.
 */
public class Output {

    @SerializedName("status")
    String status;

    @SerializedName("GolfCourseTee")
    GolfCourseTee GolfCourseTee;

    @SerializedName("message")
    String message;

    public com.pearson.android.test.stackoverflow_solution.GolfCourseTee getGolfCourseTee() {return GolfCourseTee;}

    public String getMessage() {return message;}

    public String getStatus() {return status;}
}
