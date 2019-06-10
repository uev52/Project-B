package com.example.hroopendagtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.net.Uri;
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
import android.widget.TextView;

public class generalInformation extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    //contact and floorplan buttons
    Button contactBtn;
    Button floorplanBtn;
    //study program buttons
    Button commBtn;
    Button informaticaBtn;
    Button techinfoBtn;
    Button cmgtBtn;
    Button camdBtn;
    TextView phoneNumber;
    TextView Adress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Checks for dark theme and changes theme
        SharedPreferences preferences = getSharedPreferences(AppUtil.getPrefsName(), MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(AppUtil.getPrefDarkTheme(),  false);
        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        phoneNumber = (TextView) findViewById(R.id.Phone);
        phoneNumber.setPaintFlags(phoneNumber.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:0107944000"));
                startActivity(i);
            }
        });
        Adress = (TextView) findViewById(R.id.AdressInfo);
        Adress.setPaintFlags(Adress.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        Adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:51.917380,4.484382?q=51.917380,4.484382"));
                startActivity(i);
            }
        });
        contactBtn = (Button)findViewById(R.id.contactBtn);
        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), contact_form.class);
                startActivity(i);
            }
        });
        floorplanBtn = (Button)findViewById(R.id.floorplans);
        floorplanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), floor_plan.class);
                startActivity(i);
            }
        });
        commBtn = (Button)findViewById(R.id.commBtn);
        commBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), communicatie.class);
                startActivity(i);
            }
        });
        informaticaBtn = (Button)findViewById(R.id.informaticaBtn);
        informaticaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), study_program_screen.class);
                startActivity(i);
            }
        });
        techinfoBtn = (Button)findViewById(R.id.techinfoBtn);
        techinfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), technische_informatica.class);
                startActivity(i);
            }
        });
        cmgtBtn = (Button)findViewById(R.id.cmgtBtn);
        cmgtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), cmgt.class);
                startActivity(i);
            }
        });
        camdBtn = (Button)findViewById(R.id.camdBtn);
        camdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), camd.class);
                startActivity(i);
            }
        });
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
        startActivity(AppUtil.changeScreen(item.getItemId(), getBaseContext()));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
