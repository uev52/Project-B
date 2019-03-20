package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Image_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_activity);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.myapplication.ITEM_INDEX", -1);


    }


}
