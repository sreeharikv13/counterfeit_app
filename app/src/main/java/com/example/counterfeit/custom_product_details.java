package com.example.counterfeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class custom_product_details extends BaseAdapter {
    String[] ph,productname,quantity,rate,date,expire_date,pid;
    private Context context;

    public custom_product_details(Context applicationContext, String[] ph, String[] productname, String[] quantity, String[] rate, String[] date, String[] expire_date, String[] pid) {
        this.context = applicationContext;
        this.ph = ph;
        this.productname = productname;
        this.quantity = quantity;
        this.rate = rate;
        this.date = date;
        this.expire_date = expire_date;
        this.pid = pid;
    }



    @Override
    public int getCount() {
        return productname.length;
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
            gridView = inflator.inflate(R.layout.activity_custom_product_details, null);//same class name

        } else {
            gridView = (View) view;

        }
        TextView tv1= (TextView) gridView.findViewById(R.id.textView11);
        TextView tv2 = (TextView) gridView.findViewById(R.id.textView13);
        TextView tv3 = (TextView) gridView.findViewById(R.id.textView15);
        TextView tv4 = (TextView) gridView.findViewById(R.id.textView18);
        TextView tv5 = (TextView) gridView.findViewById(R.id.textView19);



        tv1.setTextColor(Color.BLACK);
        tv2.setTextColor(Color.BLACK);
        tv3.setTextColor(Color.BLACK);
        tv4.setTextColor(Color.BLACK);
        tv5.setTextColor(Color.BLACK);


        tv1.setText(productname[i]);
        tv2.setText(quantity[i]);
        tv3.setText(rate[i]);
        tv4.setText(date[i]);
        tv5.setText(expire_date[i]);
        ImageView im = (ImageView) gridView.findViewById(R.id.imageView2);
        String image = ph[i];
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(context);
        String ip = sh.getString("ip", "");
        String url = "http://" + ip + ":5000" + image;
        Picasso.with(context).load(url).transform(new CircleTransform()).into(im);//circle



//
        return gridView;

    }
}