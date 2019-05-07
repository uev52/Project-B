package com.example.hroopendagtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.hroopendagtest1.R;

public class settings extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
    public Button btn_reset;
    public Switch swtch_nightmode;

    public static final String PREFS_NAME = AppUtil.getPrefsName();
    public static final String PREF_DARK_THEME = AppUtil.getPrefDarkTheme();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Checks for dark theme and changes theme
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(PREF_DARK_THEME,  false);
        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // MY CODE

        swtch_nightmode = (Switch) findViewById(R.id.swtch_nightmode);
        swtch_nightmode.setChecked(useDarkTheme);
        swtch_nightmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                toggleTheme(isChecked);
            }
        });

        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Succesfully reset", Toast.LENGTH_LONG).show();
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
        int id = item.getItemId();

        Intent i;
        switch(id){
            case R.id.nav_home:
                i = new Intent(this, MainActivity.class);
                break;

            case R.id.nav_openday:
                i = new Intent(this, openday.class);
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

    private void toggleTheme(boolean darkTheme) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean(PREF_DARK_THEME, darkTheme);
        editor.apply();

        Intent i = getIntent();
        startActivity(i);
        finish();
    }


    public void resetSettings(View v){
        Toast.makeText(this, "The settings have been reset!", Toast.LENGTH_LONG).show();
    }

}