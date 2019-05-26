package com.example.hroopendagtest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class game extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GamePanel(this));

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getBaseContext(), "You can't quit this game", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, MainActivity.class));
    }

}

