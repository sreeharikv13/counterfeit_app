package com.example.counterfeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class custom_view_complaint extends BaseAdapter {

    String[] complaint, com_date, reply, replydate;
    private Context context;

    public custom_view_complaint(Context applicationContext, String[] complaint, String[] com_date, String[] reply, String[] replydate) {
        this.context = applicationContext;
        this.complaint = complaint;
        this.com_date = com_date;
        this.reply = reply;
        this.replydate = replydate;
    }


    @Override
    public int getCount() {
        return complaint.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (view == null) {
            gridView = new View(context);
            //gridView=inflator.inflate(R.layout.customview, null);
            gridView = inflator.inflate(R.layout.activity_custom_view_complaint, null);//same class name

        } else {
            gridView = (View) view;

        }
        TextView tv1 = (TextView) gridView.findViewById(R.id.textView3);
        TextView tv2 = (TextView) gridView.findViewById(R.id.textView5);
        TextView tv3 = (TextView) gridView.findViewById(R.id.textView7);
        TextView tv4 = (TextView) gridView.findViewById(R.id.textView9);


        tv1.setTextColor(Color.RED);//color setting
        tv2.setTextColor(Color.BLACK);
        tv3.setTextColor(Color.BLACK);
        tv4.setTextColor(Color.BLACK);


        tv1.setText(complaint[i]);
        tv2.setText(com_date[i]);
        tv3.setText(reply[i]);
        tv4.setText(replydate[i]);
//
        return gridView;

    }


}