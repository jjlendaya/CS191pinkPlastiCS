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
     Jeynald Endaya      3/20/2015      Created and setup the file.
*/

/*
     File Creation Date: 3/20/2015
     Development Group: Pink Plastics
     Client Group: 080419 Android
     Code Summary: Activity for handling the binary tree builder simulation.
*/

package com.pinkplastics.treesim;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BinaryTreeSimulation extends ActionBarActivity {

     final static int ADD_ACTION = 0;
     final static int DELETE_ACTION = 1;
     final static int SEARCH_ACTION = 2;
     final static int RESET_ACTION = 3;
     final static int CLEAR_ACTION = 4;

     boolean menu_enabled = true;

     @Override
     /**
      * onCreate
      * Creation Date: 03/20/2015
      * Purpose: Default onCreate function for android
      *
      * @param savedInstanceState  for returning to this particular screen
      */
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_binary_tree_simulation);

          final ImageView add = (ImageView)findViewById(R.id.binary_tree_menu_add);
          add.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {

                    // set animation
                    if (menu_enabled) {
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), ADD_ACTION);
                         add.setImageDrawable(animation);
                         animation.start();

                         // insert dialog box

                    }

               }
          });

          final ImageView delete = (ImageView)findViewById(R.id.binary_tree_menu_delete);
          delete.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {

                    if (menu_enabled) {
                         // set animation
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), DELETE_ACTION);
                         delete.setImageDrawable(animation);
                         animation.start();

                         // insert dialog box

                    }
               }
          });

          final ImageView search = (ImageView)findViewById(R.id.binary_tree_menu_search);
          search.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {

                    if (menu_enabled) {
                         // set animation
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), SEARCH_ACTION);
                         search.setImageDrawable(animation);
                         animation.start();

                         // insert dialog box

                    }
               }
          });

          final ImageView reset = (ImageView)findViewById(R.id.binary_tree_menu_reset);
          reset.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    if (menu_enabled) {
                         // set animation
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), RESET_ACTION);
                         reset.setImageDrawable(animation);
                         animation.start();

                         defaultBinaryTree();

                    }
               }
          });

          final ImageView clear = (ImageView)findViewById(R.id.binary_tree_menu_clear);
          clear.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    if (menu_enabled) {
                         // set animation
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), CLEAR_ACTION);
                         clear.setImageDrawable(animation);
                         animation.start();

                         clearBinaryTree();

                    }
               }
          });

          final ImageView menu = (ImageView)findViewById(R.id.binary_tree_menu_button);
          menu.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    if (menu_enabled) {
                         menu.setImageDrawable(getResources().getDrawable(R.drawable.linked_list_menu_button));
                         add.setImageDrawable(null);
                         delete.setImageDrawable(null);
                         search.setImageDrawable(null);
                         reset.setImageDrawable(null);
                         clear.setImageDrawable(null);
                         menu_enabled = false;
                    }
                    else {
                         menu.setImageDrawable(getResources().getDrawable(R.drawable.linked_list_menu_button_selected));
                         add.setImageDrawable(getResources().getDrawable(R.drawable.linked_list_menu_add_node));
                         delete.setImageDrawable(getResources().getDrawable(R.drawable.linked_list_menu_delete_node));
                         search.setImageDrawable(getResources().getDrawable(R.drawable.linked_list_menu_search_node));
                         reset.setImageDrawable(getResources().getDrawable(R.drawable.linked_list_menu_reset_to_default));
                         clear.setImageDrawable(getResources().getDrawable(R.drawable.linked_list_menu_clear_list));
                         menu_enabled = true;
                    }
               }
          });

     }

     @Override
     /**
      * onCreateOptionsMenu
      * Creation Date: 3/20/2015
      * Purpose: Default onCreateOptionsMenu for android activities
      *
      * @param menu the menu to be inflated
      * @return     boolean   always returns true if this method executes
      */
     public boolean onCreateOptionsMenu(Menu menu) {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.menu_binary_tree_simulation, menu);
          return true;
     }

     @Override
     /**
      * onOptionsItemSelected
      * Creation Date: 03/20/2015
      * Purpose: Default onOptionsItemSelected method for android activities
      *
      * @param      item      the menu item that was selected
      * @return     boolean   dependent on android item clicks
      */
     public boolean onOptionsItemSelected(MenuItem item) {
          // Handle action bar item clicks here. The action bar will
          // automatically handle clicks on the Home/Up button, so long
          // as you specify a parent activity in AndroidManifest.xml.
          int id = item.getItemId();

          //noinspection SimplifiableIfStatement
          if (id == R.id.action_settings) {
               return true;
          }

          return super.onOptionsItemSelected(item);
     }

     public void defaultBinaryTree() {
          ImageView tree = (ImageView) findViewById(R.id.binary_tree);
          Drawable tree_state = getResources().getDrawable(R.drawable.binary_tree_full);
          tree.setImageDrawable(tree_state);
     }

     public void clearBinaryTree() {
          ImageView tree = (ImageView) findViewById(R.id.binary_tree);
          Drawable tree_state = getResources().getDrawable(R.drawable.binary_tree_blank);
          tree.setImageDrawable(tree_state);
     }

}
