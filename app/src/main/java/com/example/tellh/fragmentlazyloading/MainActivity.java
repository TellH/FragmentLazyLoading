package com.example.tellh.fragmentlazyloading;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.viewPager2)
    ViewPager viewPager2;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        titleList = new ArrayList<>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");
        fragmentList = new ArrayList<>();
        fragmentList.add(MoreFragment.newInstance(1));
        fragmentList.add(MoreFragment.newInstance(2));
        fragmentList.add(MoreFragment.newInstance(3));
        fragmentList.add(MoreFragment.newInstance(4));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(supportFragmentManager, fragmentList, titleList);
        viewPager2.setAdapter(myFragmentPagerAdapter);

        viewPager2.setOffscreenPageLimit(3);
    }

}
