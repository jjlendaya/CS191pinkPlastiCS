package com.pinkplastics.treesim;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jeynald on 2/27/2015.
 */
public class ScreenPagerAdapter extends FragmentPagerAdapter {
     public static final int NUM_OF_SCREENS = 3;

     public ScreenPagerAdapter(FragmentManager fm) {
          super(fm);
     }

     @Override
     public Fragment getItem(int position) {
          switch (position) {
               case 0:
                    return MCGIScreen.newInstance(Integer.toString(position));
               case 1:
                    return MCGVScreen.newInstance(Integer.toString(position));
               case 2:
                    return UsageTrackerScreen.newInstance(Integer.toString(position));
          }
          return null;
     }

     @Override
     public int getCount() {
          return NUM_OF_SCREENS;
     }

}