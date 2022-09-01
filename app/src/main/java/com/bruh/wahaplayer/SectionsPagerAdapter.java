package com.bruh.wahaplayer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bruh.wahaplayer.MainActivity;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    int totalTabs;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        this.totalTabs = MainActivity.tabsFragments.length;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        System.out.println(position);
        switch (position) {
            case 0:
                return MainActivity.tabsFragments[0];
            case 1:
                return MainActivity.tabsFragments[1];
            case 2:
                return MainActivity.tabsFragments[2];
            case 3:
                return MainActivity.tabsFragments[3];
            default:
                return MainActivity.tabsFragments[4];
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}