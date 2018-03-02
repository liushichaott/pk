package com.liu.pk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import pk.liu.com.pklibrary.CipherUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Log.e("----------",CipherUtil.encrypt("jkfddsk","1232222222222222"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
