package com.example.swathi.computersera.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swathi.computersera.R;
import com.example.swathi.computersera.model.Header;

import java.util.List;

/**
 * Created by user on 10/3/2016.
 */
public class HeaderSpinnerAdapter extends BaseAdapter {

    private List<Header> headers;
    private Context context;
    public HeaderSpinnerAdapter(List<Header> headers, Context context)
    {
        this.headers = headers;
        this.context = context;

    }
    @Override
    public int getCount() {
        return headers.size();
    }

    @Override
    public Object getItem(int position) {
        return headers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        HeaderViewHolderNew holder;
        if(row == null) {
            //Log.d("heading",headers[position]);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.simple_header_dropdown_item, parent, false);
            holder = new HeaderViewHolderNew(row);
            row.setTag(holder);
        }
        else
        {
            holder = (HeaderViewHolderNew) row.getTag();
        }
        holder.headingTxt.setText(headers.get(position).getHeading());


        //TextView headerTxt = (TextView) row.findViewById(R.id.headerTxt);
        //headerTxt.setText(headers.get(position).getHeading());
        //Log.d("hesder",headerTxt.getText().toString());
        return row;
    }

    public class HeaderViewHolderNew{
        TextView headingTxt;

        public HeaderViewHolderNew(View itemView) {

            headingTxt = (TextView) itemView.findViewById(R.id.headerTxt);
            headingTxt.setTextColor(ContextCompat.getColor(context,R.color.gray));

            //headingTxt.setBackgroundColor(ContextCompat.getColor(context,R.color.spinnerBG));
        }
    }
}
