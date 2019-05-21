package com.example.hroopendagtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.github.chrisbanes.photoview.PhotoView;



public class wijnhaven103 extends AppCompatActivity implements View.OnClickListener {
    Button nextFloorwh99;
    Button previousFloorwh99;
    ViewFlipper viewFlipper;
    ViewFlipper viewFlippertext99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wijnhaven103);

        PhotoView cmi1070 = (PhotoView) findViewById(R.id.cmi1070);
        cmi1070.setImageResource(R.mipmap.cmi1070);
        PhotoView cmi1071 = (PhotoView) findViewById(R.id.cmi1071);
        cmi1071.setImageResource(R.mipmap.cmi1071);
        PhotoView cmi1072 = (PhotoView) findViewById(R.id.cmi1072);
        cmi1072.setImageResource(R.mipmap.cmi1072);
        PhotoView cmi1073 = (PhotoView) findViewById(R.id.cmi1073);
        cmi1073.setImageResource(R.mipmap.cmi1073);
        PhotoView cmi1074 = (PhotoView) findViewById(R.id.cmi1074);
        cmi1074.setImageResource(R.mipmap.cmi1074);
        PhotoView cmi1075 = (PhotoView) findViewById(R.id.cmi1075);
        cmi1075.setImageResource(R.mipmap.cmi1075);
        PhotoView cmi1076 = (PhotoView) findViewById(R.id.cmi1076);
        cmi1076.setImageResource(R.mipmap.cmi1076);
        PhotoView cmi1077 = (PhotoView) findViewById(R.id.cmi1077);
        cmi1077.setImageResource(R.mipmap.cmi1077);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlippertext99 = (ViewFlipper)findViewById(R.id.viewFlippertext99);
        nextFloorwh99 = (Button) findViewById(R.id.nextFloorwh99);
        previousFloorwh99 = (Button) findViewById(R.id.previousFloorwh99);

        nextFloorwh99.setOnClickListener(this);
        previousFloorwh99.setOnClickListener(this);

        if (viewFlipper.getDisplayedChild() == 0)
            nextFloorwh99.setVisibility(View.VISIBLE);
            previousFloorwh99.setVisibility(View.INVISIBLE);


        viewFlipper.getDisplayedChild();

        if (viewFlipper.getDisplayedChild() == 0)
            nextFloorwh99.setVisibility(View.VISIBLE);
        previousFloorwh99.setVisibility(View.INVISIBLE);
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
                nextFloorwh99.setVisibility(View.VISIBLE);
            previousFloorwh99.setVisibility(View.VISIBLE);

            if (viewFlipper.getDisplayedChild() == 7)
                nextFloorwh99.setVisibility(View.INVISIBLE);
            previousFloorwh99.setVisibility(View.VISIBLE);
        }

        if (v == previousFloorwh99) {

            viewFlipper.showPrevious();
            viewFlippertext99.showPrevious();

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

            if (viewFlipper.getDisplayedChild() == 6) {
                nextFloorwh99.setVisibility(View.VISIBLE);
                previousFloorwh99.setVisibility(View.VISIBLE);
            }

        }
    }
}