package com.example.admin.sowetotourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Admin on 7/28/2017.
 */

public class TourGuidePagerAdapter  extends FragmentPagerAdapter {

        private final int PAGE_COUNT = 4;

        private String tabTitles[] = new String[]{
                Entertainment.NAME,
                School.NAME,
                Mall.NAME,
                Restaurant.NAME};

        private Context mContext;

        public TourGuidePagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext = context;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = Fragment.instantiate(mContext, Entertainment.class.getName());
                    break;
                case 1:
                    fragment = Fragment.instantiate(mContext, School.class.getName());
                    break;
                case 2:
                    fragment = Fragment.instantiate(mContext, Mall.class.getName());
                    break;
                case 3:
                    fragment = Fragment.instantiate(mContext, Restaurant.class.getName());
                    break;
            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
}
