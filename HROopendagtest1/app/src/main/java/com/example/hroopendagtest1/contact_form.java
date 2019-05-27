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

public class contact_form extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //----------------

        //In the Java programming language, the !final! keyword is used in several contexts to define
        // an entity that can only be assigned once. Once a final variable has been assigned,
        // it always contains the same value.

        final EditText editName        =  findViewById(R.id.editName);
        final EditText editYouremail   =  findViewById(R.id.editYouremail);
        final EditText editSubject     =  findViewById(R.id.editSubject);
        final EditText editContent     =  findViewById(R.id.editContent);

        Button email =  findViewById(R.id.sendButton);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // public means that the method is visible and can be called from other objects of other types.
                // void means that the method has no return value
                String name     = editName.getText().toString();
                String email    = editYouremail.getText().toString();
                String subject  = editSubject.getText().toString();
                String content  = editContent.getText().toString();


                //https://stackoverflow.com/questions/12947620/email-address-validation-in-android-on-edittext
                //http://androidmkab.com/2016/12/13/create-android-contact-form-beginne/
                //https://www.youtube.com/watch?v=tZ2YEw6SoBU


                //if name input is empty... checker
                if (TextUtils.isEmpty(name)){
                    editName.setError("Enter Your Name"); // error message with exclamation mark
                    editName.requestFocus(); // brings the  cursor to this field
                    return;
                }



                if (!isValidEmail(email)) {
                    editYouremail.setError("Invalid Email");
                    return;
                }


                if (TextUtils.isEmpty(subject)){
                    editSubject.setError("Enter Your Subject");
                    editSubject.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(content)){
                    editContent.setError("Enter Your Message");
                    editContent.requestFocus();
                    return;
                }


                    //start maling activity, everything next is sending data from one application to another
                    Intent Mailing = new Intent(android.content.Intent.ACTION_SEND);

                    //sharingapps that need to be shown:
                    Mailing.setType("plain/text");

                    //who is the mail being sended to
                    Mailing.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"0946639@hr.nl"});

                    //what is the subject
                    Mailing.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);

                    //mail content and other information
                    Mailing.putExtra(android.content.Intent.EXTRA_TEXT, "Name:" + name + '\n' + "Email:" + email + '\n' + "Content:" + '\n' + content);

                    //sharingfunctionality of the button
                    startActivity(Intent.createChooser(Mailing, "Choose mail application"));



            }
        });


    }
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
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


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


