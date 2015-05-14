/*

“This is a course requirement for CS 192 Software Engineering II under the supervision of Asst.
Prof. Ma. Rowena C. Solamo of the Department of Computer Science, College of Engineering,
University of the Philippines, Diliman for the AY 2014-2015”

Copyright (c) 2015, Members of Pink Plastics Development
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted
provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions
and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse
or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER
 OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 POSSIBILITY OF SUCH DAMAGE.
 */

/*
     Code History:
     3/13/2015: Created initial version from the first ScreenPagerAdapter class
     3/20/2015: Enabled semi-infinite scrolling.
*/

/*
     File Creation Date: 2/27/2015
     Development Group: Pink Plastics
     Client Group: 080419 Android
     Code Summary: Auto-generated class for screen swiping within the Demos.
 */

package com.pinkplastics.treesim;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jeynald on 2/27/2015.
 */
public class BuilderScreenPagerAdapter extends FragmentPagerAdapter {
     public static final int NUM_OF_SCREENS = 2;

     /**
      * Constructor
      * Creation Date: 2/27/2015
      * Purpose: Auto-generated function
      *
      * @param     fm         the fragment manager for handling fragment transactions
      */
     public BuilderScreenPagerAdapter(FragmentManager fm) {
          super(fm);
     }

     @Override
     /**
      * getItem
      * Creation Date: 2/27/2015
      * Purpose: Auto-generated function
      *
      * @param     position   the page number of a fragment
      * @return    Fragment   the fragment to be displayed
      */
     public Fragment getItem(int position) {
          switch (position) {
               case 0:
                    return LinkedListScreen.newInstance(Integer.toString(position));
               case 1:
                    return BinaryTreeScreen.newInstance(Integer.toString(position));
          }
          return null;
     }


     @Override
     /**
      * getCount
      * Creation Date: 2/27/2015
      * Purpose: Auto-generated function for getting the number of screens
      *
      * @return    int   the number of screens the menu has
      */
     public int getCount() {
          return NUM_OF_SCREENS;
     }

}