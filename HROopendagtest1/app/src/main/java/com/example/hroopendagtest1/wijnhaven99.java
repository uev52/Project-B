package com.example.hroopendagtest1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import com.github.chrisbanes.photoview.PhotoView;



public class wijnhaven99 extends AppCompatActivity implements View.OnClickListener {
    Button nextFloorwh99;
    Button previousFloorwh99;
    ViewFlipper viewFlipper;
    ViewFlipper viewFlippertext99;
    Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        // Checks for dark theme and changes theme
        SharedPreferences preferences = getSharedPreferences(AppUtil.getPrefsName(), MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(AppUtil.getPrefDarkTheme(),  false);
        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.wijnhaven99);

        spinner1 = findViewById(R.id.spinner1);

        PhotoView cmi1070 = findViewById(R.id.cmi1070);
        cmi1070.setImageResource(R.drawable.cmi990);
        PhotoView cmi1071 = findViewById(R.id.cmi1071);
        cmi1071.setImageResource(R.drawable.cmi991);
        PhotoView cmi1072 = findViewById(R.id.cmi1072);
        cmi1072.setImageResource(R.drawable.cmi992);
        PhotoView cmi1073 = findViewById(R.id.cmi1073);
        cmi1073.setImageResource(R.drawable.cmi993);
        PhotoView cmi1074 = findViewById(R.id.cmi1074);
        cmi1074.setImageResource(R.drawable.cmi994);
        PhotoView cmi1075 = findViewById(R.id.cmi1075);
        cmi1075.setImageResource(R.drawable.cmi995);

        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlippertext99 = findViewById(R.id.viewFlippertext99);
        nextFloorwh99 = findViewById(R.id.nextFloorwh99);
        previousFloorwh99 = findViewById(R.id.previousFloorwh99);

        nextFloorwh99.setOnClickListener(this);
        previousFloorwh99.setOnClickListener(this);

        viewFlipper.getDisplayedChild();

        ArrayAdapter<String> spinner2Adapter = new ArrayAdapter(wijnhaven99.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Floors));
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(spinner2Adapter);


        Bundle bundle = getIntent().getExtras();
        int floorNumber = bundle.getInt("floorNumber");
        viewFlipper.setDisplayedChild(floorNumber);
        viewFlippertext99.setDisplayedChild(floorNumber);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


//https://www.youtube.com/watch?v=peO5cUczncc
    }


    @Override
    public void onClick(View v) {

        if (v == nextFloorwh99) {
            viewFlipper.showNext();
            viewFlippertext99.showNext();
            spinner1.setSelection(spinner1.getSelectedItemPosition()+1);


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
                nextFloorwh99.setVisibility(View.INVISIBLE);
                previousFloorwh99.setVisibility(View.VISIBLE);
        }

         if (v == previousFloorwh99) {

             viewFlipper.showPrevious();
             viewFlippertext99.showPrevious();
             spinner1.setSelection(spinner1.getSelectedItemPosition()-1);

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