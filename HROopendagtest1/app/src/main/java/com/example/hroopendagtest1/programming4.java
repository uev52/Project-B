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
import android.widget.EditText;
import android.widget.Toast;

public class programming4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText fourthinput1;
    EditText fourthinput2;
    Button   fourthCheck;
    View     view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Checks for dark theme and changes theme
        SharedPreferences preferences = getSharedPreferences(AppUtil.getPrefsName(), MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(AppUtil.getPrefDarkTheme(),  false);
        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming4);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fourthinput1 = findViewById(R.id.input1);
        fourthinput2 = findViewById(R.id.input2);

        //Get the view so I can later use it to change the background color
        view = this.getWindow().getDecorView();


        fourthCheck = findViewById(R.id.Check1);
        fourthCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstinput = fourthinput1.getText().toString();
                firstinput = firstinput.replace(" ","");
                String answer1 = "False";
                String secondinput = fourthinput2.getText().toString();
                secondinput = secondinput.replace(" ","");
                String answer2 = "else";

                if (firstinput.equals(answer1) && secondinput.equals(answer2)){
                    Toast.makeText(getApplicationContext(),  "Correct!", Toast.LENGTH_LONG).show();
                    view.setBackgroundResource(R.color.colorGreen1);
                    fourthCheck.setText("Next");
                    fourthCheck.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getApplicationContext(), programming5.class);
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
