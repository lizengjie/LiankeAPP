package com.madeinlk.xvmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.madeinlk.R;

public class MainActivity extends Activity {
    private Button mButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_xvmu);
        mButton1 = (Button) findViewById(R.id.control);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Controlselect.class);
                startActivity(intent);
            }
        });
    }
}
