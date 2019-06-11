package com.example.hroopendagtest1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.util.Base64;
import android.util.Log;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class openday3 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //set to phone calender functionality
    // in order to communicate using an API
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addToCalender(View view) {
        Intent setcalendar = new Intent(Intent.ACTION_INSERT);
        setcalendar.setType("vnd.android.cursor.item/event");
        setcalendar.putExtra(CalendarContract.Events.TITLE, "OPENDAY CMI");
        setcalendar.putExtra(CalendarContract.Events.EVENT_LOCATION, "Wijnhaven 107, 3011 WN, Rotterdam ");
        setcalendar.putExtra(CalendarContract.Events.DESCRIPTION, "Following the openday of CMI at the Hogeschool Rotterdam");

        // set the begin time and date of the event
        Calendar begin = Calendar.getInstance();
        begin.set(2019, 5, 4, 16, 0);
        // set the end time and date of the event
        Calendar end = Calendar.getInstance();
        end.set(2019, 5, 4, 20, 0);

        //view begin time and date
        setcalendar.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                begin.getTimeInMillis());
        // view end time and date
        setcalendar.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                end.getTimeInMillis());
        // start calendar activity

        startActivity(setcalendar);
    }

    //schedule and schedule classroom rows items
    ImageView schedule, blur, floor0, floor1, floor2, floor3, floor4, floor5;

    //studie program buttons
    Button btn_sp1;
    Button btn_sp2;
    Button btn_sp3;
    Button btn_sp4;
    Button btn_sp5;
    ImageButton close;

    // openday schedule cullom and row items
    TextView title, note, note_text, time1, time2, time3, time4, time5, time6, time7, course1, course2, course3, course4, course5, course6, course7, room1, room2, room3, room4, room5, room6, room7;

    // current study program checker for day schedule
    public int sp;

    // Classroom information popup light box
    Dialog pop;
    Dialog sharepop;

    // facebook
    CallbackManager callbackManager;
    ShareDialog shareDialog;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Checks for dark theme and changes theme
        SharedPreferences preferences = getSharedPreferences(AppUtil.getPrefsName(), MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(AppUtil.getPrefDarkTheme(),  false);
        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openday3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        printKeyHash();

//        private void printKeyHash() {
//            try {
//                PackageInfo info = getPackageManager().getPackageInfo("com.example.hroopendagtest1",
//                        PackageManager.GET_SIGNATURES);
//                for (Signature signature : info.signatures) {
//                    MessageDigest md = MessageDigest.getInstance("SHA");
//                    md.update(signature.toByteArray());
//                    Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT))
//                }
//
//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//        }
        // create dayschedule items
        title = (TextView) findViewById(R.id.scheduleTitle);
        note = (TextView) findViewById(R.id.note);
        note_text = (TextView) findViewById(R.id.note_text);
        time1 = (TextView) findViewById(R.id.time_course1);
        time2 = (TextView) findViewById(R.id.time_course2);
        time3 = (TextView) findViewById(R.id.time_course3);
        time4 = (TextView) findViewById(R.id.time_course4);
        time5 = (TextView) findViewById(R.id.time_course5);
        time6 = (TextView) findViewById(R.id.time_course6);

        course1 = (TextView) findViewById(R.id.workshop1);
        course2 = (TextView) findViewById(R.id.workshop2);
        course3 = (TextView) findViewById(R.id.workshop3);
        course4 = (TextView) findViewById(R.id.workshop4);
        course5 = (TextView) findViewById(R.id.workshop5);
        course6 = (TextView) findViewById(R.id.workshop6);

        room1 = (TextView) findViewById(R.id.classroom1);
        room2 = (TextView) findViewById(R.id.classroom2);
        room3 = (TextView) findViewById(R.id.classroom3);
        room4 = (TextView) findViewById(R.id.classroom4);
        room5 = (TextView) findViewById(R.id.classroom5);
        room6 = (TextView) findViewById(R.id.classroom6);

        schedule = (ImageView) findViewById(R.id.schedule);
        blur = (ImageView) findViewById(R.id.imageView4);
        floor0 = (ImageView) findViewById(R.id.cmi1070);
        floor1 = (ImageView) findViewById(R.id.cmi1071);
        floor2 = (ImageView) findViewById(R.id.cmi1072);
        floor3 = (ImageView) findViewById(R.id.cmi1073);
        floor4 = (ImageView) findViewById(R.id.cmi1074);
        floor5 = (ImageView) findViewById(R.id.cmi1075);

        pop = new Dialog(this);


        // Studyprogram button for Comunication (changes the day achedule)
        btn_sp1 = (Button) findViewById(R.id.contactBtn);
        sp = 0;
        btn_sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = 1;
                title.setText("Communicatie");
                makeSchedule();
                makeVisible();
            }

        });

        // Studyprogram button for Informatica (changes the day achedule)
        btn_sp2 = (Button) findViewById(R.id.btn_sp2);

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
        btn_sp3 = (Button) findViewById(R.id.btn_sp3);

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
        btn_sp4 = (Button) findViewById(R.id.btn_sp4);

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
        btn_sp5 = (Button) findViewById(R.id.btn_sp5);

        btn_sp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = 5;
                title.setText("CMD");
                makeSchedule();
                makeVisible();
            }

        });

        // classroom popup linking when clicked on text in row 1
        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomPlan();
            }

        });


        // classroom popup linking when clicked on text in row 2
        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomPlan();
            }

        });

        // classroom popup linking when clicked on text in row 3
        room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomPlan();
            }

        });

        // classroom popup linking when clicked on text in row 4
        room4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomPlan();
            }

        });

        // classroom popup linking when clicked on text in row 5
        room5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomPlan();
            }

        });

        // classroom popup linking when clicked on text in row 6
        room6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomPlan();
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


//        close = (ImageButton) findViewById(R.id.close);
//
//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//

    // custom function makes items in dayschedule visible or invisible when needed
    public void makeVisible() {
        blur.setVisibility(blur.INVISIBLE);
        note.setVisibility(note.INVISIBLE);
        note_text.setVisibility(note_text.INVISIBLE);
        time1.setVisibility(time1.VISIBLE);
        time2.setVisibility(time2.VISIBLE);
        time3.setVisibility(time3.VISIBLE);
        time4.setVisibility(time4.VISIBLE);
        time5.setVisibility(time5.VISIBLE);
        time6.setVisibility(time6.VISIBLE);

        course1.setVisibility(course1.VISIBLE);
        course2.setVisibility(course2.VISIBLE);
        course3.setVisibility(course3.VISIBLE);
        course4.setVisibility(course4.VISIBLE);
        course5.setVisibility(course5.VISIBLE);
        course6.setVisibility(course6.VISIBLE);

        room1.setVisibility(room1.VISIBLE);
        room2.setVisibility(room2.VISIBLE);
        room3.setVisibility(room3.VISIBLE);
        room4.setVisibility(room4.VISIBLE);
        room5.setVisibility(room5.VISIBLE);
        room6.setVisibility(room6.VISIBLE);

    }

    // custom function for checking for the current chosen study program an showing popup activity when pressed on classroom
    public void roomPlan() {
        if (sp == 1) {
            showPopupRoom();

        }
        if (sp == 2) {
            showPopupRoom();


        }
        if (sp == 3) {
            showPopupRoom();

        }
        if (sp == 4) {
            showPopupRoom();


        }
        if (sp == 5) {
            showPopupRoom();

        }
    }

    // custom function thes sets the popup class
    public void showPopupRoom() {
        Intent i = new Intent(this, wijnhaven99.class);
        startActivity(i);

    }

    public void showshare(final View v) {
        pop.setContentView(R.layout.share_popup);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        //Share with facebook link : https://www.youtube.com/watch?v=2ZdzG_XObDM&t=27s

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        ImageButton sharefacebook=pop.findViewById(R.id.sharefacebook);


        sharefacebook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String messageBody1 = "Hi there,\n\nThere is an openday at the Hogeschool Rotterdam on 4th of June.\nThe openday starts at 16:00 until 20:00 and takes places at Wijnhaven 107 in Rotterdam\nI will be there, would you like to join me?";
                ShareLinkContent linkContent = new ShareLinkContent.Builder().setQuote(messageBody1).setContentUrl(Uri.parse("https://www.hogeschoolrotterdam.nl/voorlichting/hulp-bij-studiekeuze/open-dag/")).build();
                if(ShareDialog.canShow(ShareLinkContent.class)){
                    shareDialog.show(linkContent);
                }


            }
        });

        ImageButton sharewhatsapp=pop.findViewById(R.id.sharewhatsapp);
        sharewhatsapp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // here must come the send intent of the whatsapp application
                Toast.makeText(openday3.this,"an inventation is sending with whatsapp",Toast.LENGTH_SHORT).show();
                Intent shareIntent1 = new Intent(Intent.ACTION_SEND);
                shareIntent1.setType("text/plain");
                String messageBody1 = "Hi there,\n\nThere is an openday at the Hogeschool Rotterdam on 4th of June.\nThe openday starts at 16:00 until 20:00 and takes places at Wijnhaven 107 in Rotterdam\nI will be there, would you like to join me?";
                String messageSubject1 = "OPENDAY CMI";
                // the sharing text/ body is set here
                shareIntent1.putExtra(Intent.EXTRA_TEXT,messageBody1);
                shareIntent1.putExtra(Intent.EXTRA_SUBJECT,messageSubject1);
                shareIntent1.setPackage("com.whatsapp");
                startActivity(shareIntent1);
            }
        });

        ImageButton sharetwitter=pop.findViewById(R.id.sharetwitter);
        sharetwitter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String messageBody1 = "Hi there,\n\nThere is an openday at the Hogeschool Rotterdam on 4th of June.\nThe openday starts at 16:00 until 20:00 and takes places at Wijnhaven 107 in Rotterdam\nI will be there, would you like to join me?";


                // https://stackoverflow.com/questions/14317512/how-can-i-post-on-twitter-with-intent-action-send
                Intent tweetIntent = new Intent(Intent.ACTION_SEND);
                tweetIntent.putExtra(Intent.EXTRA_TEXT, messageBody1);
                tweetIntent.setType("text/plain");

                PackageManager packManager = getPackageManager();
                List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

                boolean resolved = false;
                for (ResolveInfo resolveInfo : resolvedInfoList) {
                    if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                        tweetIntent.setClassName(
                                resolveInfo.activityInfo.packageName,
                                resolveInfo.activityInfo.name);
                        resolved = true;
                        break;
                    }
                }

                if (resolved) {
                    startActivity(tweetIntent);
                } else {
                    Intent i = new Intent();
                    i.putExtra(Intent.EXTRA_TEXT, messageBody1);
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://twitter.com/intent/tweet?text=" + urlEncode(messageBody1)));
                    startActivity(i);
                    Toast.makeText(openday3.this, "Twitter app isn't found", Toast.LENGTH_LONG).show();
                }
            }
            private String urlEncode(String s) {
                try {
                    return URLEncoder.encode(s, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    Log.wtf( "UTF-8 should always be supported", e);
                    return "";
                }
            }


        });

        ImageButton shareemail=pop.findViewById(R.id.shareemail);
        shareemail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // here must come the send intent of the facebook application
                String messageBody1 = "Hi there,\n\nThere is an openday at the Hogeschool Rotterdam on 4th of June.\nThe openday starts at 16:00 until 20:00 and takes places at Wijnhaven 107 in Rotterdam\nI will be there, would you like to join me?";
                String messageSubject1 = "OPENDAY CMI";
                String data = "mailto:" + "?cc=" + "" + "&subject=" + Uri.encode(messageSubject1) + "&body=" + Uri.encode(messageBody1);

                Intent sharemail = new Intent(Intent.ACTION_SENDTO);
                sharemail.setData(Uri.parse(data));
                startActivity(sharemail);

            }
        });


        pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pop.show();
    }

    private void printKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.hroopendagtest1",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // custom funtion that sets the required day schedule items to the corresponding study program
    public void makeSchedule(){

        // values in the fist column that are always the same
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
            room6.setText("H.2.111");


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
            room4.setText("H.5.314");
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
            room4.setText("H.5.314");
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
            room6.setText("H.5.314");
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
            room3.setText("H.2.111");
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

}
