package com.example.amirz.tabview3d;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amirz on 2/12/2018.
 */

public class viewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> tabFragments = new ArrayList<>();
    private final List<String>   tabTitles = new ArrayList<>();


    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return tabFragments.get(position);
    }

    @Override
    public int getCount() {
        return tabFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);

    }

    public  void addFragments(Fragment fragment, String title){
        tabFragments.add(fragment);
        tabTitles.add(title);

    }
}
