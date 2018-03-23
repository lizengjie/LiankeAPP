package com.madeinlk.xvmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.madeinlk.R;

import java.util.ArrayList;

public class Controlselect extends Activity {
    private Button mBtn;
    private RadioButton mRadioButton;
    private RadioGroup mRadioGroup1;
    private ImageView mImageView;
    private Spinner mSpinner1,mSpinner2;
    private TextView mTextView;
    public String instr=null;
    private int num_sel1,num_sel2;
    public int sel_id;
    public int cate=-1;
    int[] num={0,1,2,3,4,5,6,7,8,9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlselect);
        //radiobutton事件
        mImageView = (ImageView) findViewById(R.id.control_select_IM1);
        mRadioGroup1 = (RadioGroup) findViewById(R.id.rg1);
        mRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch(checkedId){
                    case R.id.Radio1:
                        instr = "饲喂器";
                        cate=0;
                        mImageView.setImageResource(R.drawable.siweiqi);
                        break;
                    case R.id.Radio2:
                        instr = "饲喂站";
                        cate=1;
                        mImageView.setImageResource(R.drawable.siweizhan);
                        break;
                    case R.id.Radio3:
                        instr = "环控";
                        cate=2;
                        mImageView.setImageResource(R.drawable.huankong);
                        break;
                    case R.id.Radio4:
                        instr = "料线";
                        cate=3;
                        mImageView.setImageResource(R.drawable.liaoxian);
                        break;
                    default:
                        instr = "请选择设备";
                        cate=-1;
                }
            }
        });
        mSpinner1= (Spinner) findViewById(R.id.spinner1);
        mSpinner2= (Spinner) findViewById(R.id.spinner2);
        final ArrayList arrayList=new ArrayList();
        for(int i=0;i<num.length;i++)
        {
            arrayList.add(num[i]);
        }
        final ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner1.setAdapter(arrayAdapter);
        mSpinner2.setAdapter(arrayAdapter);
        mSpinner1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                num_sel1 = (int) mSpinner1.getSelectedItem();
                mTextView= (TextView) findViewById(R.id.dis_id);
                sel_id=num_sel1*10+num_sel2;
                mTextView.setText("设备ID是" + sel_id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        mSpinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                num_sel2 = (int) mSpinner2.getSelectedItem();
                mTextView= (TextView) findViewById(R.id.dis_id);
                sel_id=num_sel1*10+num_sel2;
                mTextView.setText("设备ID是" + sel_id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        //确认设备事件
        mBtn = (Button) findViewById(R.id.con_select);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("cata",instr);
                bundle.putInt("id",sel_id);
                Intent intent = new Intent(Controlselect.this,view_control.class);
                intent.putExtras(bundle);
                if(cate<0 ||cate>3){
                    Toast.makeText(Controlselect.this,"请选择设备",Toast.LENGTH_SHORT).show();
                }
                else if(sel_id==0){
                    Toast.makeText(Controlselect.this,"请选择ID",Toast.LENGTH_SHORT).show();
                }
                else if((cate>=0&&cate<=3)&&sel_id!=0){
                    startActivity(intent);
                }

            }
        });
    }
}
