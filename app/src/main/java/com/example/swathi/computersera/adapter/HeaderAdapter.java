package com.example.swathi.computersera.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swathi.computersera.R;
import com.example.swathi.computersera.model.Header;

import java.util.List;

/**
 * Created by user on 9/30/2016.
 */
public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>{
    private List<Header> headers;
    private int rowLayout;
    private Context context;

   public HeaderAdapter(List<Header> headers, int rowLayout, Context context)
   {
       this.headers = headers;
       this.rowLayout = rowLayout;
       this.context = context;
   }

    @Override
    public HeaderAdapter.HeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeaderViewHolder holder, int position) {
        holder.headingTxt.setText(headers.get(position).getHeading());
    }

    @Override
    public int getItemCount() {
        return headers.size();
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        LinearLayout headerLayout;

        TextView headingTxt;

        public HeaderViewHolder(View itemView) {

            super(itemView);
            headerLayout = (LinearLayout) itemView.findViewById(R.id.header_layout);
            headingTxt = (TextView) itemView.findViewById(R.id.headingTxt);
        }
    }
}
