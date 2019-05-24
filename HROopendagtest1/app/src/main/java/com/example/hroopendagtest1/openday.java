package com.example.hroopendagtest1;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class openday extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //set to phone calender functionality
    // in order to communicate using an API
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addToCalender(View view){
        Intent setcalendar = new Intent(Intent.ACTION_INSERT);
        setcalendar.setType("vnd.android.cursor.item/event");
        setcalendar.putExtra(CalendarContract.Events.TITLE, "OPENDAY CMI");
        setcalendar.putExtra(CalendarContract.Events.EVENT_LOCATION, "Wijnhaven 107, 3011 WN, Rotterdam ");
        setcalendar.putExtra(CalendarContract.Events.DESCRIPTION, "Following the openday of CMI at the Hogeschool Rotterdam");
        // set the begin time and date of the event
        Calendar begin = Calendar.getInstance();
        begin.set(2019,3,4, 16, 0);
        // set the end time and date of the event
        Calendar end = Calendar.getInstance();
        end.set(2019,3,4, 20, 0);

        setcalendar.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        //view begin time and date
        setcalendar.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                begin.getTimeInMillis());
        // view end time and date
        setcalendar.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                end.getTimeInMillis());
        // start calendar activity
        startActivity(setcalendar);
    }
    ImageView schedule;
    Button btn_sp1;
    Button btn_sp2;
    Button btn_sp3;
    Button btn_sp4;
    Button btn_sp5;

    TextView title;
    TextView note,note_text,time1,time2,time3,time4,time5,time6,time7,course1,course2,course3,course4,course5,course6,course7,room1,room2,room3,room4,room5,room6,room7;
    public int sp;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title=(TextView) findViewById(R.id.scheduleTitle);
        note= (TextView) findViewById(R.id.note);
        note_text = (TextView)findViewById(R.id.note_text);
        time1 = (TextView)findViewById(R.id.time_course1);
        time2= (TextView)findViewById(R.id.time_course2);
        time3= (TextView)findViewById(R.id.time_course3);
        time4= (TextView)findViewById(R.id.time_course4);
        time5= (TextView)findViewById(R.id.time_course5);
        time6= (TextView)findViewById(R.id.time_course6);
        time7= (TextView)findViewById(R.id.time_course7);
        course1= (TextView)findViewById(R.id.workshop1);
        course2= (TextView)findViewById(R.id.workshop2);
        course3= (TextView)findViewById(R.id.workshop3);
        course4= (TextView)findViewById(R.id.workshop4);
        course5= (TextView)findViewById(R.id.workshop5);
        course6= (TextView)findViewById(R.id.workshop6);
        course7= (TextView)findViewById(R.id.workshop7);
        room1= (TextView)findViewById(R.id.classroom1);
        room2= (TextView)findViewById(R.id.classroom2);
        room3= (TextView)findViewById(R.id.classroom3);
        room4= (TextView)findViewById(R.id.classroom4);
        room5= (TextView)findViewById(R.id.classroom5);
        room6= (TextView)findViewById(R.id.classroom6);
        room7= (TextView)findViewById(R.id.classroom7);
        schedule = (ImageView)findViewById(R.id.schedule);




        // Studyprogram button for Comunication (changes the day achedule)
        btn_sp1=(Button)findViewById(R.id.contactBtn);
        sp = 0;
        btn_sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp= 1;
                title.setText("Communicatie");
                makeSchedule();
                makeVisible();


            }

        });


        // Studyprogram button for Informatica (changes the day achedule)
        btn_sp2=(Button)findViewById(R.id.btn_sp2);

        btn_sp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = 2;
                title.setText("Informatica");
                makeSchedule();
                makeVisible();

            }

        });

        // Studyprogram button for Technisch informatica (changes the day achedule)
        btn_sp3=(Button)findViewById(R.id.btn_sp3);

        btn_sp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = 3;
                title.setText("Technisch Informatica");
                makeSchedule();
                makeVisible();


            }

        });
        // Studyprogram button for Creative Design & Game Technology (changes the day achedule)
        btn_sp4=(Button)findViewById(R.id.btn_sp4);

        btn_sp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = 4;
                title.setText("MD&GT");
                makeSchedule();
                makeVisible();

            }

        });

        // Studyprogram button for Ceative Media Design (changes the day achedule)
        btn_sp5=(Button)findViewById(R.id.btn_sp5);

        btn_sp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = 5;
                title.setText("CMD");
                makeSchedule();
                makeVisible();

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

    public void makeVisible(){
        note.setVisibility(note.INVISIBLE);
        note_text.setVisibility(note_text.INVISIBLE);
        time1.setVisibility(time1.VISIBLE);
        time2.setVisibility(time2.VISIBLE);
        time3.setVisibility(time3.VISIBLE);
        time4.setVisibility(time4.VISIBLE);
        time5.setVisibility(time5.VISIBLE);
        time6.setVisibility(time6.VISIBLE);
        time7.setVisibility(time7.VISIBLE);
        course1.setVisibility(course1.VISIBLE);
        course2.setVisibility(course2.VISIBLE);
        course3.setVisibility(course3.VISIBLE);
        course4.setVisibility(course4.VISIBLE);
        course5.setVisibility(course5.VISIBLE);
        course6.setVisibility(course6.VISIBLE);
        course7.setVisibility(course7.VISIBLE);
        room1.setVisibility(room1.VISIBLE);
        room2.setVisibility(room2.VISIBLE);
        room3.setVisibility(room3.VISIBLE);
        room4.setVisibility(room4.VISIBLE);
        room5.setVisibility(room5.VISIBLE);
        room6.setVisibility(room6.VISIBLE);
        room7.setVisibility(room7.VISIBLE);
    }

    public void makeSchedule(){
        time1.setText("16:00 - 16:45");
        time2.setText("16:45 - 17:00");
        time3.setText("17:00 - 18:00");
        time4.setText("18:00 - 18:45");
        time5.setText("18:45 - 19:15");
        time6.setText("19:15 - 20:00");

        if (sp == 1){
            course1.setText("Intro");
            course2.setText("Pauze");
            course3.setText("info Communicatie");
            course4.setText("Proefles");
            course5.setText("Pauze");
            course6.setText("miniproject A");
            room1.setText("H.0.310");
            room2.setText("H.0.310");
            room3.setText("H.1.308");
            room4.setText("H.1.403");
            room5.setText("H.0.310");
            room6.setText("H.2.211");

        }
        if (sp == 2){
            course1.setText("Intro");
            course2.setText("Pauze");
            course3.setText("Info Informatica");
            course4.setText("Python progtamming");
            course5.setText("Pauze");
            course6.setText("Keylogger maken");
            room1.setText("H.0.310");
            room2.setText("H.0.310");
            room3.setText("H.0.405");
            room4.setText("H.5.915");
            room5.setText("H.0.310");
            room6.setText("H.2.403");
        }
        if (sp == 3){
            course1.setText("Intro");
            course2.setText("pauze");
            course3.setText("Info TI");
            course4.setText("Python programming");
            course5.setText("Raspberry PI");
            course6.setText("Kluisjes opdracht");
            room1.setText("H.0.310");
            room2.setText("H.0.310");
            room3.setText("H.4.308");
            room4.setText("H.5.914");
            room5.setText("H.4.206");
            room6.setText("H.4.403");
        }
        if (sp == 4){
            course1.setText("Intro");
            course2.setText("Pauze");
            course3.setText("Info GT&GD");
            course4.setText("Unity");
            course5.setText("Pauze");
            course6.setText("Game maken");
            room1.setText("H.0.310");
            room2.setText("H.0.310");
            room3.setText("H.3.312");
            room4.setText("H.3.206");
            room5.setText("H.1.316");
            room6.setText("H.5.914");
        }
        if (sp == 5){
            course1.setText("Intro");
            course2.setText("Pauze");
            course3.setText("Info CMD");
            course4.setText("Proefles");
            course5.setText("Pauze");
            course6.setText("Miniproject B");
            room1.setText("H.0.310");
            room2.setText("H.0.310");
            room3.setText("H.2.211");
            room4.setText("H.2.403");
            room5.setText("H.1.316");
            room6.setText("H.2.204");
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
                String messageBody = "Hi there,\n\nThere is an openday at the Hogeschool Rotterdam on 4th of April.\nThe openday starts at 16:00 until 20:00 and takes places at Wijnhaven 107 in Rotterdam\nI will be there, would you like to join me?";
                String messageSubject = "OPENDAY CMI";
// the sharing text/ body is set here
                shareIntent.putExtra(Intent.EXTRA_TEXT,messageBody);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,messageSubject);
// the sharing box title is set here
                startActivity(Intent.createChooser(shareIntent,"Share with"));
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
