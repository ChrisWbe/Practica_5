package com.christianquintero.practica_5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Chris on 01/05/2016.
 */
public class PageAdapterSitios extends FragmentPagerAdapter{
    public PageAdapterSitios(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new sitio1_fragment();
            case 1: return new sitio2_fragment();
            case 2: return new sitio3_fragment();
            default: return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
