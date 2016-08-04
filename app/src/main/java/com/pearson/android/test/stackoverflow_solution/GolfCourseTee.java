package com.pearson.android.test.stackoverflow_solution;

import com.google.gson.annotations.SerializedName;
import com.pearson.android.test.stackoverflow_solution.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 539117 on 7/27/2016.
 */
public class GolfCourseTee {

    @SerializedName("Men")
    List<Member> Men;

    @SerializedName("Ladies")
    List<Member> Ladies;

    @SerializedName("Junior")
    List<Member> Junior;

    List<Member> cumulativeList;

    public List<Member> getAllMembers(){

        if(cumulativeList == null) {
            cumulativeList = new ArrayList<Member>();
            cumulativeList.addAll(Men);
            cumulativeList.addAll(Ladies);
            cumulativeList.addAll(Junior);
        }

        return cumulativeList;
    }

    public List<Member> getJunior() {return Junior;}

    public List<Member> getLadies() {return Ladies;}

    public List<Member> getMen() {return Men;}
}
