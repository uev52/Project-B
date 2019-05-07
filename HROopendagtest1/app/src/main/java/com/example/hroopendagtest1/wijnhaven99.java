package com.example.hroopendagtest1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ZoomControls;


public class wijnhaven99 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView Floor;
    Button Button_GF;
    Button Button_FF;
    Button Button_SF;
    Button Button_TF;;
    TextView title;
    ZoomControls ZoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wijnhaven99);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title=(TextView) findViewById(R.id.FloorTitle);
        Floor = (ImageView)findViewById(R.id.ImageView99);
        ZoomControls = (ZoomControls)findViewById(R.id.ZoomControls);

        ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = Floor.getScaleX();
                float y = Floor.getScaleY();

                Floor.setScaleX((int) (x+1));
                Floor.setScaleY((int) (y+1));

            }
        });

        ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = Floor.getScaleX();
                float y = Floor.getScaleY();

                Floor.setScaleX((int) (x));
                Floor.setScaleX((int) (y));
            }
        });



        Button_GF=(Button)findViewById(R.id.Button_GF);
        Button_GF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Ground Floor");
                Floor.setImageResource(R.drawable.cmi900);


            }});



        Button_FF=(Button)findViewById(R.id.Button_FF);
        Button_FF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("First Floor");
                Floor.setImageResource(R.drawable.wh994);

            }

        });


        Button_SF=(Button)findViewById(R.id.Button_SF);
        Button_SF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Second Floor");
                Floor.setImageResource(R.drawable.wh992);

            }

        });

        Button_TF=(Button)findViewById(R.id.Button_TF);

        Button_TF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Third Floor");
                Floor.setImageResource(R.drawable.wh993);

            }

        });







        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent i;
        switch(id){
            case R.id.nav_home:
                i = new Intent(this, MainActivity.class);
                break;

            case R.id.nav_openday:
                i = new Intent(this, openday.class);
                break;

            case R.id.nav_information:
                i = new Intent(this, study_program_screen.class);
                break;

            case R.id.nav_generalInformation:
                i = new Intent(this, generalInformation.class);
                break;

            case R.id.nav_contact:
                i = new Intent(this, contact_form.class);
                break;

            case R.id.nav_floorPlans:
                i = new Intent(this, floor_plan.class);
                break;

            case R.id.nav_settings:
                i = new Intent(this, settings.class);
                break;

            default:
                i = new Intent(this, MainActivity.class);
                break;

        }

        startActivity(i);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
