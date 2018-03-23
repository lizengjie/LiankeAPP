package com.madeinlk.xvmu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.madeinlk.R;

public class view_control extends Activity {
    private TextView mTextView1,mTextView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_control);
        mTextView1 = (TextView) findViewById(R.id.input_tv1);
        mTextView2 = (TextView) findViewById(R.id.input_tv2);
        Bundle bundle = getIntent().getExtras();
        String string=bundle.getString("cata");
        int id = bundle.getInt("id");
        String string2= String.valueOf(id);
        mTextView1.setText(string);
        mTextView2.setText(string2);
    }
}
