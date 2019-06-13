package com.example.hroopendagtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class floor_plan extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //YASIN
    Button Wijnhaven99;
    Button Wijnhaven103;
    Button Wijnhaven107;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Checks for dark theme and changes theme
        // SOUFYAN DARK MODE
        SharedPreferences preferences = getSharedPreferences(AppUtil.getPrefsName(), MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(AppUtil.getPrefDarkTheme(),  false);
        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark);
        }


        //SOUFYAN
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //YASIN
        Wijnhaven99 = findViewById(R.id.Wijnhaven99);
        Wijnhaven99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), wijnhaven99.class);
                i.putExtra("floorNumber", 0);
                startActivity(i);
            }
        });

        //YASIN
        Wijnhaven103 = findViewById(R.id.Wijnhaven103);
        Wijnhaven103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), wijnhaven103.class);
                i.putExtra("floorNumber", 0);
                startActivity(i);
            }
        });

        //YASIN
        Wijnhaven107 = findViewById(R.id.Wijnhaven107);
        Wijnhaven107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), wijnhaven107.class);
                i.putExtra("floorNumber", 0);
                startActivity(i);
            }
        });


        //SOUFYAN MENU DRAWER
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //SOUFYAN MENU DRAWER
    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //SOUFYAN MENU DRAWER
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        startActivity(AppUtil.changeScreen(item.getItemId(), getBaseContext()));


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
