package com.example.hroopendagtest1;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class openday2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView schedule;
    Button btn_sp1;
    Button btn_sp2;
    Button btn_sp3;
    Button btn_sp4;
    Button btn_sp5;

    Button btn_sp1_info;
    Button btn_sp2_info;
    Button btn_sp3_info;
    Button btn_sp4_info;
    Button btn_sp5_info;
    TextView title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openday2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title=(TextView) findViewById(R.id.scheduleTitle);
        schedule = (ImageView)findViewById(R.id.schedule);
        // Studyprogram button for Comunication (changes the day achedule)
        btn_sp1=(Button)findViewById(R.id.contactBtn);

        btn_sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Communicatie");
                schedule.setImageResource(R.drawable.day_schedule);

            }

        });


        // Studyprogram button for Informatica (changes the day achedule)
        btn_sp2=(Button)findViewById(R.id.btn_sp2);

        btn_sp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Informatica");
                schedule.setImageResource(R.drawable.day_schedule_informatica);

            }

        });

        // Studyprogram button for Technisch informatica (changes the day achedule)
        btn_sp3=(Button)findViewById(R.id.btn_sp3);

        btn_sp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Technisch Informatica");
                schedule.setImageResource(R.drawable.day_schedule);

            }

        });
        // Studyprogram button for Creative Design & Game Technology (changes the day achedule)
        btn_sp4=(Button)findViewById(R.id.btn_sp4);

        btn_sp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("MD&GT");
                schedule.setImageResource(R.drawable.day_schedule_informatica);

            }

        });

        // Studyprogram button for Ceative Media Design (changes the day achedule)
        btn_sp5=(Button)findViewById(R.id.btn_sp5);

        btn_sp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("CMD");
                schedule.setImageResource(R.drawable.day_schedule);

            }

        });

        // information button. by clicking the current screen will switch to the study program screen of Communication that provide more detailed information
        btn_sp1_info=(Button)findViewById(R.id.btn_sp1_info);

        btn_sp1_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), communicatie.class);
                startActivity(i);
            }
        });

        // information button. by clicking the current screen will switch to the study program screen of Informatica that provide more detailed information
        btn_sp2_info=(Button)findViewById(R.id.btn_sp2_info);

        btn_sp2_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), study_program_screen.class);
                startActivity(i);
            }
        });

        // information button. by clicking the current screen will switch to the study program screen of ? that provide more detailed information
        btn_sp3_info=(Button)findViewById(R.id.btn_sp3_info);

        btn_sp3_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), technische_informatica.class);
                startActivity(i);
            }
        });

        // information button. by clicking the current screen will switch to the study program screen of ? that provide more detailed information
        btn_sp4_info=(Button)findViewById(R.id.btn_sp4_info);

        btn_sp4_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), cmgt.class);
                startActivity(i);
            }
        });

        // information button. by clicking the current screen will switch to the study program screen of ? that provide more detailed information
        btn_sp5_info=(Button)findViewById(R.id.btn_sp5_info);

        btn_sp5_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), camd.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
    //the menu with the share button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.openday_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    // the sharing funtionaltiy
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
// here we make an intent that gives an string/ contectext with the message
            case R.id.share_button:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String messageBody = "your body here";
                String messageSubject = "your subject";
// the sharing text/ body is set here
                shareIntent.putExtra(Intent.EXTRA_TEXT,messageBody);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,messageSubject);
// the sharing box/ sharing possibilities are set here
                startActivity(Intent.createChooser(shareIntent,"Share with"));
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
