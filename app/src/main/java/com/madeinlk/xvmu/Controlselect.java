package com.madeinlk.xvmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.madeinlk.R;

public class Controlselect extends Activity {
    private Button mBtn;
    private RadioButton mRadioButton;
    private RadioGroup mRadioGroup1;
    public String instr=null;
    public int en=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlselect);
        //radiobutton事件
        mRadioGroup1 = (RadioGroup) findViewById(R.id.rg1);
        mRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                mRadioButton = (RadioButton) group.findViewById(checkedId);
                en =checkedId;
                switch(checkedId){
                    case R.id.Radio1:
                        instr = "饲喂器";
                        break;
                    case R.id.Radio2:
                        instr = "饲喂站";
                        break;
                    case R.id.Radio3:
                        instr = "环控";
                        break;
                    case R.id.Radio4:
                        instr = "料线";
                        break;
                    default:
                        instr = "请选择设备";
                        en=-1;
                }
            }
        });


        //确认设备事件
        mBtn = (Button) findViewById(R.id.con_select);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("instr",instr);
                Intent intent = new Intent(Controlselect.this,view_control.class);
                intent.putExtras(bundle);
                if(en !=-1){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Controlselect.this,"请选择设备",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
