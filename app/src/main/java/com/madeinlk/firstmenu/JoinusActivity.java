package com.madeinlk.firstmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.madeinlk.Jobs.jijiagong;
import com.madeinlk.Jobs.xvmu;
import com.madeinlk.Jobs.zhusu;
import com.madeinlk.Jobs.zidonghua;
import com.madeinlk.R;



public class JoinusActivity extends Activity {
    private Button mJoinus_btn1, mJoinus_btn2 ,mJoinus_btn3 ,mJoinus_btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinus);
        mJoinus_btn1 = (Button) findViewById(R.id.joinus_btn1);
        mJoinus_btn2 = (Button) findViewById(R.id.joinus_btn2);
        mJoinus_btn3 = (Button) findViewById(R.id.joinus_btn3);
        mJoinus_btn4 = (Button) findViewById(R.id.joinus_btn4);
        setlisterns();

    }
    private void setlisterns(){
        Click click =new Click();
        mJoinus_btn1.setOnClickListener(click);
        mJoinus_btn2.setOnClickListener(click);
        mJoinus_btn3.setOnClickListener(click);
        mJoinus_btn4.setOnClickListener(click);
    }
    private class Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.joinus_btn1:
                    intent = new Intent(JoinusActivity.this,jijiagong.class);
                    break;
                case R.id.joinus_btn2:
                    intent = new Intent(JoinusActivity.this,zhusu.class);
                    break;
                case R.id.joinus_btn3:
                    intent = new Intent(JoinusActivity.this,xvmu.class);
                    break;
                case R.id.joinus_btn4:
                    intent = new Intent(JoinusActivity.this, zidonghua.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
