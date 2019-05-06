package com.example.hroopendagtest1;

import android.app.Activity;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class AppUtil{
    private static String PREFS_NAME = "prefs";
    private static String PREF_DARK_THEME = "dark_theme";

    public static String getPrefsName(){
        return PREFS_NAME;
    }
    public static void setPrefsName(String s){
        PREFS_NAME = s;
    }
    public static String getPrefDarkTheme(){
        return PREF_DARK_THEME;
    }
    public static void setPrefDarkTheme(String s){
        PREF_DARK_THEME = s;
    }
}
