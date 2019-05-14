package com.example.hroopendagtest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ImageViewCompat;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.hroopendagtest1.R;
import com.github.chrisbanes.photoview.PhotoView;

//https://www.youtube.com/watch?v=kXv2_pMZMU0
public class wijnhaven103 extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipperimage99;
    ViewFlipper viewFlippertext99;
    Button nextFloorwh99;
    Button previousFloorwh99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wijnhaven103);

        viewFlipperimage99 = (ViewFlipper)findViewById(R.id.viewFlipperimage99);
        viewFlippertext99 = (ViewFlipper)findViewById(R.id.viewFlippertext99);
        nextFloorwh99 = (Button) findViewById(R.id.nextFloorwh99);
        previousFloorwh99 = (Button) findViewById(R.id.previousFloorwh99);

        nextFloorwh99.setOnClickListener(this);
        previousFloorwh99.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v == nextFloorwh99) {
            viewFlipperimage99.showNext();
            viewFlippertext99.showNext();

        }
        else if (v == previousFloorwh99) {
            viewFlipperimage99.showPrevious();
            viewFlippertext99.showPrevious();
        }
    }
}
