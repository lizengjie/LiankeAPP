package com.madeinlk.firstmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.madeinlk.R;

public class AboutusActivity extends Activity {
    private View mback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        mback = findViewById(R.id.aboutus_main);
        mback.getBackground().setAlpha(100);
    }
}
