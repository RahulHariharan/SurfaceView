package com.pearson.android.test.stackoverflow_efficient_data_construction_recyclerview;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pearson.android.test.R;
import com.pearson.android.test.surfaceview.SurfaceViewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adapter.ClickListener {


    RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<String> mDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,SurfaceViewActivity.class);
        startActivity(intent);
        /*initData();

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new Adapter(this,mDataList);
        mRecyclerView.setAdapter(mAdapter);*/
    }

    private void initData(){

        mDataList = new ArrayList<>();
        mDataList.add("Africa");
        mDataList.add("Antartica");
        mDataList.add("Asia");
        mDataList.add("Australia");
        mDataList.add("Europe");
        mDataList.add("North America");
        mDataList.add("South America");
    }

    @Override
    public void onContinentClicked(String continent) {
        Log.v("continent",continent);
    }
}
