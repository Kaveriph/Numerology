package com.example.kaveri.numerology;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KAVERI on 7/30/2017.
 */
public class NumerologyResultAdapter extends RecyclerView.Adapter<NumerologyResultAdapter.ViewHolder>{

    private List<NumerologyResultData> mNumerologyResultData;

    public NumerologyResultAdapter(List<NumerologyResultData> numerologyResultData){
        this.mNumerologyResultData = numerologyResultData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_numerology_result_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NumerologyResultData numerologyResult = mNumerologyResultData.get(position);
        if(numerologyResult != null) {
            holder.numerologyItemNameTv.setText(numerologyResult.getName());
            holder.numerologyItemTotalValTv.setText(numerologyResult.getTotalValue() + "");
            holder.numerologyItemPyramidValTv.setText(numerologyResult.getPyramidValue() + "");
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mNumerologyResultData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView numerologyItemNameTv;
        public TextView numerologyItemTotalValTv;
        public TextView numerologyItemPyramidValTv;
        public View layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            numerologyItemNameTv = (TextView) itemView.findViewById(R.id.numerologyItemNameTv);
            numerologyItemTotalValTv = (TextView) itemView.findViewById(R.id.numerologyItemTotalValTv);
            numerologyItemPyramidValTv = (TextView) itemView.findViewById(R.id.numerologyItemPyramidValTv);
        }
    }
}
