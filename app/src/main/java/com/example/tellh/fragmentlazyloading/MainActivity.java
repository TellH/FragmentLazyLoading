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
    ViewPager viewPager;
    private List<Fragment> fragmentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        fragmentList = new ArrayList<>();
        fragmentList.add(MoreFragment.newInstance(1,false));
        fragmentList.add(MoreFragment.newInstance(2,true));
        fragmentList.add(MoreFragment.newInstance(3,true));
        fragmentList.add(MoreFragment.newInstance(4,true));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(supportFragmentManager, fragmentList);
        viewPager.setAdapter(myFragmentPagerAdapter);

        viewPager.setOffscreenPageLimit(4);
    }

}
