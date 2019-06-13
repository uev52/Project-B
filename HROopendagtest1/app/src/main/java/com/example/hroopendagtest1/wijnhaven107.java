package com.example.hroopendagtest1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import com.github.chrisbanes.photoview.PhotoView;



public class wijnhaven107 extends AppCompatActivity implements View.OnClickListener {
    Button nextFloorwh99;
    Button previousFloorwh99;
    ViewFlipper viewFlipper;
    ViewFlipper viewFlippertext99;
    Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // SOUFYAN DARK MODE
        // Checks for dark theme and changes theme
        SharedPreferences preferences = getSharedPreferences(AppUtil.getPrefsName(), MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(AppUtil.getPrefDarkTheme(),  false);
        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark);
        }

        //YASIN
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wijnhaven107);

        //SEVVEN
        spinner3 = findViewById(R.id.spinner3);

        //YASIN
        PhotoView cmi1070 = findViewById(R.id.cmi1070);
        cmi1070.setImageResource(R.drawable.cmi1070);
        PhotoView cmi1071 = findViewById(R.id.cmi1071);
        cmi1071.setImageResource(R.drawable.cmi1071);
        PhotoView cmi1072 = findViewById(R.id.cmi1072);
        cmi1072.setImageResource(R.drawable.cmi1072);
        PhotoView cmi1073 = findViewById(R.id.cmi1073);
        cmi1073.setImageResource(R.drawable.cmi1073);
        PhotoView cmi1074 = findViewById(R.id.cmi1074);
        cmi1074.setImageResource(R.drawable.cmi1074);
        PhotoView cmi1075 = findViewById(R.id.cmi1075);
        cmi1075.setImageResource(R.drawable.cmi1075);
        PhotoView cmi1076 = findViewById(R.id.cmi1076);
        cmi1076.setImageResource(R.drawable.cmi1076);

        //SEVVEN
        ArrayAdapter<String> spinner2Adapter = new ArrayAdapter(wijnhaven107.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Floors2));
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //SEVVEN
        spinner3.setAdapter(spinner2Adapter);

        //YASIN
        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlippertext99 = findViewById(R.id.viewFlippertext99);
        nextFloorwh99 = findViewById(R.id.nextFloorwh99);
        previousFloorwh99 = findViewById(R.id.previousFloorwh99);

        //YASIN
        nextFloorwh99.setOnClickListener(this);
        previousFloorwh99.setOnClickListener(this);

        //YASIN
        viewFlipper.getDisplayedChild();

        //YASIN
        if (viewFlipper.getDisplayedChild() == 0)
            nextFloorwh99.setVisibility(View.VISIBLE);
            previousFloorwh99.setVisibility(View.INVISIBLE);

        //SEVVEN
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

                switch(i){
                    case 0:
                        viewFlipper.setDisplayedChild(0);
                        viewFlippertext99.setDisplayedChild(0);
                        nextFloorwh99.setVisibility(View.VISIBLE);
                        previousFloorwh99.setVisibility(View.INVISIBLE);

                        break;
                    case 1:
                        viewFlipper.setDisplayedChild(1);
                        viewFlippertext99.setDisplayedChild(1);
                        nextFloorwh99.setVisibility(View.VISIBLE);
                        previousFloorwh99.setVisibility(View.VISIBLE);

                        break;
                    case 2:
                        viewFlipper.setDisplayedChild(2);
                        viewFlippertext99.setDisplayedChild(2);
                        nextFloorwh99.setVisibility(View.VISIBLE);
                        previousFloorwh99.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        viewFlipper.setDisplayedChild(3);
                        viewFlippertext99.setDisplayedChild(3);
                        nextFloorwh99.setVisibility(View.VISIBLE);
                        previousFloorwh99.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        viewFlipper.setDisplayedChild(4);
                        viewFlippertext99.setDisplayedChild(4);
                        nextFloorwh99.setVisibility(View.VISIBLE);
                        previousFloorwh99.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        viewFlipper.setDisplayedChild(5);
                        viewFlippertext99.setDisplayedChild(5);
                        nextFloorwh99.setVisibility(View.VISIBLE);
                        previousFloorwh99.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        viewFlipper.setDisplayedChild(6);
                        viewFlippertext99.setDisplayedChild(6);
                        nextFloorwh99.setVisibility(View.INVISIBLE);
                        previousFloorwh99.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//
//
//


        Bundle bundle = getIntent().getExtras();
        int floorNumber = bundle.getInt("floorNumber");

        for(int i = 0; i < floorNumber; i++){
            viewFlipper.showNext();
            viewFlippertext99.showNext();
            spinner3.setSelection(spinner3.getSelectedItemPosition()+1);
        }

        viewFlipper.setDisplayedChild(floorNumber);
        viewFlippertext99.setDisplayedChild(floorNumber);
        nextFloorwh99.setVisibility(View.VISIBLE);
        previousFloorwh99.setVisibility(View.VISIBLE);

//https://www.youtube.com/watch?v=peO5cUczncc
    }


    //YASIN
    @Override
    public void onClick(View v) {

        if (v == nextFloorwh99) {
            viewFlipper.showNext();
            viewFlippertext99.showNext();
            spinner3.setSelection(spinner3.getSelectedItemPosition()+1);


            if (viewFlipper.getDisplayedChild() == 1)
                nextFloorwh99.setVisibility(View.VISIBLE);
            previousFloorwh99.setVisibility(View.VISIBLE);

            if (viewFlipper.getDisplayedChild() == 2)
                nextFloorwh99.setVisibility(View.VISIBLE);
            previousFloorwh99.setVisibility(View.VISIBLE);

            if (viewFlipper.getDisplayedChild() == 3)
                nextFloorwh99.setVisibility(View.VISIBLE);
            previousFloorwh99.setVisibility(View.VISIBLE);

            if (viewFlipper.getDisplayedChild() == 4)
                nextFloorwh99.setVisibility(View.VISIBLE);
            previousFloorwh99.setVisibility(View.VISIBLE);

            if (viewFlipper.getDisplayedChild() == 5)
                nextFloorwh99.setVisibility(View.VISIBLE);
            previousFloorwh99.setVisibility(View.VISIBLE);

            if (viewFlipper.getDisplayedChild() == 6)
                nextFloorwh99.setVisibility(View.INVISIBLE);
            previousFloorwh99.setVisibility(View.VISIBLE);
        }

        if (v == previousFloorwh99) {

            viewFlipper.showPrevious();
            viewFlippertext99.showPrevious();
            spinner3.setSelection(spinner3.getSelectedItemPosition()-1);

            if (viewFlipper.getDisplayedChild() == 0) {
                nextFloorwh99.setVisibility(View.VISIBLE);
                previousFloorwh99.setVisibility(View.INVISIBLE);
            }

            if (viewFlipper.getDisplayedChild() == 1) {
                nextFloorwh99.setVisibility(View.VISIBLE);
                previousFloorwh99.setVisibility(View.VISIBLE);
            }

            if (viewFlipper.getDisplayedChild() == 2) {
                nextFloorwh99.setVisibility(View.VISIBLE);
                previousFloorwh99.setVisibility(View.VISIBLE);
            }
            if (viewFlipper.getDisplayedChild() == 3) {
                nextFloorwh99.setVisibility(View.VISIBLE);
                previousFloorwh99.setVisibility(View.VISIBLE);
            }

            if (viewFlipper.getDisplayedChild() == 4) {
                nextFloorwh99.setVisibility(View.VISIBLE);
                previousFloorwh99.setVisibility(View.VISIBLE);
            }

            if (viewFlipper.getDisplayedChild() == 5) {
                nextFloorwh99.setVisibility(View.VISIBLE);
                previousFloorwh99.setVisibility(View.VISIBLE);
            }


        }
    }
}