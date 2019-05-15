package com.example.hroopendagtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.github.chrisbanes.photoview.PhotoView;



public class wijnhaven107 extends AppCompatActivity implements View.OnClickListener {
    Button nextFloorwh99;
    Button previousFloorwh99;
    ViewFlipper viewFlipper;
    ViewFlipper viewFlippertext99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wijnhaven107);

        PhotoView photoView = (PhotoView) findViewById(R.id.cmi1070);
        photoView.setImageResource(R.mipmap.cmi1070);
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


    }

    @Override
    public void onClick (View v) {
        if (v == nextFloorwh99){
            viewFlipper.showNext();
            viewFlippertext99.showNext();
        }
        else if (v == previousFloorwh99){
            viewFlipper.showPrevious();
            viewFlippertext99.showPrevious();
        }
    }
}
