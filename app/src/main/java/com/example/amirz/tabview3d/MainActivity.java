package com.example.amirz.tabview3d;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private viewPagerAdapter viewPagerAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager =(ViewPager)findViewById(R.id.viewPager_id);

        viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new tab1(),"Songs");
        viewPagerAdapter.addFragments(new tab2(),"Albums");
        viewPagerAdapter.addFragments(new tab3(),"Artist");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
         tabLayout.getTabAt(0).setIcon(R.drawable.ic_library_music_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_album_white_24dp);
         tabLayout.getTabAt(2).setIcon(R.drawable.ic_sort_white_24dp);
    }
}
