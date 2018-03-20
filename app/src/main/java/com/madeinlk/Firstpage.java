package com.madeinlk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.madeinlk.firstmenu.AboutusActivity;
import com.madeinlk.firstmenu.JoinusActivity;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by LiZJ on 2018/3/18.
 */

public class Firstpage extends AppCompatActivity {
    private Button mBtn_xvmu;
    private int imageIds[];
    private String[] titles;
    private ArrayList<ImageView> images;
    private ArrayList<View> dots;
    private TextView title;
    private ViewPager mViewPager;
    private ViewPagerAdapter adapter;

    private int oldPosition = 0;//记录上一次点的位置
    private int currentItem; //当前页面
    private ScheduledExecutorService scheduledExecutorService;
    private MarqueeTextView marqueeTv;
    private String [] textArrays = new String[]{"连科制造盛装亮相东盟博览会","猪e管功能正在功能完善中","畜牧设备持续更新中"};
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
        marqueeTv = (MarqueeTextView) findViewById(R.id.marqueeTv);

        marqueeTv.setTextArraysAndClickListener(textArrays, new MarqueeTextViewClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Firstpage.this,NewsActivity.class));
            }
        });
        //图片ID
        imageIds = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e
        };

        //图片标题
        titles = new String[]{
                "LKAMS—母猪自动饲喂管理系统",
                "LKATS—种猪测定系统",
                "全限位栏 ",
                "保育围栏 ",
                "猪e管数字化养殖系统"
        };

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i =0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);

            images.add(imageView);
        }

        //显示的点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));
        dots.add(findViewById(R.id.dot_4));

        title = (TextView) findViewById(R.id.title);
        title.setText(titles[0]);

        mViewPager = (ViewPager) findViewById(R.id.vp);

        adapter = new ViewPagerAdapter();
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                title.setText(titles[position]);

                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
                dots.get(position).setBackgroundResource(R.drawable.dot_focused);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });


    }
    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return images.size();
        }

        //是否是同一张图片
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
            //            super.destroyItem(container, position, object);
            //            view.removeViewAt(position);
            view.removeView(images.get(position));

        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));

            return images.get(position);
        }
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        //每隔2秒钟切换一张图片
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(), 2, 2, TimeUnit.SECONDS);
    }

    //切换图片
    private class ViewPagerTask implements Runnable {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            currentItem = (currentItem +1) % imageIds.length;
            //更新界面
            //            handler.sendEmptyMessage(0);
            handler.obtainMessage().sendToTarget();
        }

    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            //设置当前页面
            mViewPager.setCurrentItem(currentItem);
        }

    };

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
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
    @Override
    protected void onDestroy() {
        marqueeTv.releaseResources();
        super.onDestroy();
    }
}
