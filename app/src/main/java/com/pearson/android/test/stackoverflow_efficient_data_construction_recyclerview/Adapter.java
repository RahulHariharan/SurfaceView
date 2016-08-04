package com.pearson.android.test.stackoverflow_efficient_data_construction_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pearson.android.test.R;

import java.util.ArrayList;

/**
 * Created by 539117 on 7/14/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.DataViewHolder> {

    ArrayList<String> mContinentList;
    ClickListener mListener;

    public interface ClickListener{

        void onContinentClicked(String continent);
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{

        TextView mDataItemTextView;
        String mContinent;

        public DataViewHolder(View itemView,String continent) {
            super(itemView);

            mDataItemTextView = (TextView) itemView.findViewById(R.id.data_text_view);
            mContinent = continent;
            Log.v("continent",mContinent);
            mDataItemTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onContinentClicked(mContinent);
                }
            });

        }
    }

    public Adapter(Context context, ArrayList<String> continentList){

      this.mContinentList = continentList;
      this.mListener = (ClickListener) context;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        Log.v("position", Integer.toString(position));
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item_view, parent, false);
        return new DataViewHolder(view,mContinentList.get(position));
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

        holder.mDataItemTextView.setText(mContinentList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mContinentList.size();
    }
}
