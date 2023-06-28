package com.example.counterfeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.EditorBoundsInfo;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed_ip;
    Button sr;
    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_ip = findViewById(R.id.editTextTextPersonName);
        sr = findViewById(R.id.button);
        sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ed_ip.setText(sh.getString("ip",""));
        sr.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        String ipaddress=ed_ip.getText().toString();
//        Toast.makeText(this, ipaddress+",", Toast.LENGTH_SHORT).show();
        String url1 = "http://" + ipaddress + ":5000/";
        SharedPreferences.Editor ed=sh.edit();
        ed.putString("ip",ipaddress);
        ed.putString("url",url1);
        ed.commit();
        Intent i=new Intent(getApplicationContext(),login.class);
        startActivity(i);
    }
}