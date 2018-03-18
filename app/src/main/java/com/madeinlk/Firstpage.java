package com.madeinlk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.madeinlk.firstmenu.AboutusActivity;
import com.madeinlk.firstmenu.JoinusActivity;

/**
 * Created by LiZJ on 2018/3/18.
 */

public class Firstpage extends AppCompatActivity {
    private Button mBtn_xvmu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        mBtn_xvmu = (Button) findViewById(R.id.Btn_xvmu);
        mBtn_xvmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Firstpage.this, com.madeinlk.xvmu.MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_first,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i=null;
        switch (item.getItemId()){
            case R.id.aboutUs:
                 i =new Intent(Firstpage.this,AboutusActivity.class);
                break;
            case R.id.joinUs:
                i =new Intent(Firstpage.this,JoinusActivity.class);
                break;
        }
        startActivity(i);
        return true;
    }
}
