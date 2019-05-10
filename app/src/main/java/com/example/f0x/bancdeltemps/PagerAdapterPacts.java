package com.example.f0x.bancdeltemps;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterPacts extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterPacts(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PactsFragment tab1 = new PactsFragment();
                return tab1;
            case 1:
                PactsPropisFragment tab2 = new PactsPropisFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
