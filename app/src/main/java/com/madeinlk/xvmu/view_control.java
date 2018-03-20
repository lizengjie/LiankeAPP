package com.madeinlk.xvmu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.madeinlk.R;

public class view_control extends Activity {
    private TextView mTextView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_control);
        mTextView1 = (TextView) findViewById(R.id.input_tv1);
        Bundle bundle = getIntent().getExtras();
        String string=bundle.getString("instr");
        mTextView1.setText(string);
    }
}
