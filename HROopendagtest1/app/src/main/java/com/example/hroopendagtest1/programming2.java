package com.example.hroopendagtest1;

import android.app.Activity;
import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
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
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.Subject;

public class programming2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText secondinput1;
    EditText secondinput2;
    Button   Check2;
    View     view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming2);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        secondinput1 = findViewById(R.id.input1);
        secondinput2 = findViewById(R.id.input2);

        //Get the view so I can later use it to change the background color
        view = this.getWindow().getDecorView();


        Check2 = findViewById(R.id.Check1);
        Check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstinput = secondinput1.getText().toString();
                String answer1 = "y=4";
                String secondinput = secondinput2.getText().toString();
                String answer2 = "j";

                if (firstinput.equals(answer1) && secondinput.equals(answer2)){
                    Toast.makeText(getApplicationContext(),  "Correct!", Toast.LENGTH_LONG).show();
                    view.setBackgroundResource(R.color.colorGreen1);
                    Check2.setText("Next");
                    Check2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getApplicationContext(), programming1.class);
                            startActivity(i);
                        }
                    });

                    return;
                }else{
                    Toast.makeText(getApplicationContext(),  "Wrong!", Toast.LENGTH_LONG).show();
                    view.setBackgroundResource(R.color.colorRed);
                    return;
                }

            }
        });




        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        startActivity(AppUtil.changeScreen(item.getItemId(), getBaseContext()));


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
