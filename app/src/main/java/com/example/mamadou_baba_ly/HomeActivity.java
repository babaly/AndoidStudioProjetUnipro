package com.example.mamadou_baba_ly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_home);

    }

    public void nextClick1 (View view)
    {
        Intent nextWin = new Intent (this,NavigationActivity.class);
        startActivity(nextWin);
    }

    public void exitClick (Intent view)
    {
        Intent outApp = new Intent (this, HomeActivity.class);

        finish();
        System.exit(0);
    }


}
