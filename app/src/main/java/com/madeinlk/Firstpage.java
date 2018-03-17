package com.madeinlk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.madeinlk.firstmenu.AboutusActivity;
import com.madeinlk.firstmenu.JoinusActivity;

/**
 * Created by LiZJ on 2018/3/18.
 */

public class Firstpage extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
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
