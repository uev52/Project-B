package com.example.hroopendagtest1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class AppUtil {
    private static String PREFS_NAME = "prefs";
    private static String PREF_DARK_THEME = "dark_theme";

    public static String getPrefsName() {
        return PREFS_NAME;
    }

    public static void setPrefsName(String s) {
        PREFS_NAME = s;
    }

    public static String getPrefDarkTheme() {
        return PREF_DARK_THEME;
    }

    public static void setPrefDarkTheme(String s) {
        PREF_DARK_THEME = s;
    }

    public static Intent changeScreen(int id, Context context) {
        Intent i;
        switch (id) {
            case R.id.nav_home:
                i = new Intent(context, MainActivity.class);
                break;

            case R.id.nav_generalInformation:
                i = new Intent(context, generalInformation.class);
                break;

            case R.id.nav_contact:
                i = new Intent(context, contact_form.class);
                break;

            case R.id.nav_floorPlans:
                i = new Intent(context, floor_plan.class);
                break;

            case R.id.game:
                i = new Intent(context, game.class);
                break;


            default:
                i = new Intent(context, MainActivity.class);
                break;
        }

        return i;
    }
}
