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
     Jeynald Endaya      3/13/2015      Created and edited the file.
*/

/*
     File Creation Date: 3/13/2015
     Development Group: Pink Plastics
     Client Group: 080419 Android
     Code Summary: Fragment for displaying the Preorder Tree Traversal option in demos.
*/

package com.pinkplastics.treesim;

import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class PreorderTraversalSimulation extends ActionBarActivity {

     final int NODE_OBJECT = 0;
     final int SHORT_ARROW = 1;
     final int LONG_ARROW = 2;
     final int SEARCH_NODE = 3;
     final int FOUND_NODE = 4;

     final int TRAVERSAL_UNVISITED = 1;
     final int TRAVERSAL_VISITED = 2;
     final int TRAVERSAL_FOUND = 3;

     final int animDuration = 1000;

     boolean traversal_playing = false;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.treetraversal);
          //ViewGroup layout = (ViewGroup)findViewById(R.id.activity_preorder_layout);

          //layout.addView(fl);
          FrameLayout fl = (FrameLayout) findViewById(R.id.NodeLayout);

          Typeface heroFont = Typeface.createFromAsset(getAssets(), "fonts/hero.otf");

          TextView reminder = (TextView) findViewById(R.id.traversal_tapscreen);
          reminder.setTypeface(heroFont);

          fl.setOnClickListener(
                  new View.OnClickListener() {
                       public void onClick(View v) {
                            preorderTraversal();
                       }
                  }
          );
     }


     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.menu_preorder_traversal_simulation, menu);
          return true;
     }

     @Override
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

     /*
          Name: preOrderTraversal
          Creation Date: 03/18/2015
          Purpose: Demonstrates the preorder tree traversal using animations and a default tree
          Arguments:
               View     View that calls the function
          Required File: treetraversal.xml, image_size.xml, TreeSimAnimation.java
          Return Value: none

     */

     public void preorderTraversal() {
          int currentDuration = animDuration;
          ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
          final ArrayList<TextView> textViews = new ArrayList<TextView>();
          int node = 0;
          int line1l = 1;
          int line1r = 2;
          int line2l = 3;
          int line2r = 4;
          int line3l = 5;
          int line3r = 6;

          int[] type = {node, line1l, node, line2l, node, line3r,
                  node, line3r, line2l, line2r, node, line3l,
                  node, line3l, line3r, node, line3r, line2r,
                  line1l, line1r, node, line2r, node, line3l,
                  node, line3l, line2r, line1r};
          int[] mode = {node, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED,
                  node, TRAVERSAL_VISITED, TRAVERSAL_VISITED, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED,
                  node, TRAVERSAL_VISITED, TRAVERSAL_UNVISITED, node, TRAVERSAL_VISITED, TRAVERSAL_VISITED,
                  TRAVERSAL_VISITED, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED,
                  node, TRAVERSAL_VISITED, TRAVERSAL_VISITED, TRAVERSAL_VISITED};

          imageViews.add((ImageView) findViewById(R.id.traversal_A));
          imageViews.add((ImageView) findViewById(R.id.traversal_1));
          imageViews.add((ImageView) findViewById(R.id.traversal_B));
          imageViews.add((ImageView) findViewById(R.id.traversal_3));
          imageViews.add((ImageView) findViewById(R.id.traversal_D));
          imageViews.add((ImageView) findViewById(R.id.traversal_6));
          imageViews.add((ImageView) findViewById(R.id.traversal_G));
          imageViews.add((ImageView) findViewById(R.id.traversal_6));
          imageViews.add((ImageView) findViewById(R.id.traversal_3));
          imageViews.add((ImageView) findViewById(R.id.traversal_4));
          imageViews.add((ImageView) findViewById(R.id.traversal_E));
          imageViews.add((ImageView) findViewById(R.id.traversal_7));
          imageViews.add((ImageView) findViewById(R.id.traversal_H));
          imageViews.add((ImageView) findViewById(R.id.traversal_7));
          imageViews.add((ImageView) findViewById(R.id.traversal_8));
          imageViews.add((ImageView) findViewById(R.id.traversal_I));
          imageViews.add((ImageView) findViewById(R.id.traversal_8));
          imageViews.add((ImageView) findViewById(R.id.traversal_4));
          imageViews.add((ImageView) findViewById(R.id.traversal_1));
          imageViews.add((ImageView) findViewById(R.id.traversal_2));
          imageViews.add((ImageView) findViewById(R.id.traversal_C));
          imageViews.add((ImageView) findViewById(R.id.traversal_5));
          imageViews.add((ImageView) findViewById(R.id.traversal_F));
          imageViews.add((ImageView) findViewById(R.id.traversal_9));
          imageViews.add((ImageView) findViewById(R.id.traversal_J));
          imageViews.add((ImageView) findViewById(R.id.traversal_9));
          imageViews.add((ImageView) findViewById(R.id.traversal_5));
          imageViews.add((ImageView) findViewById(R.id.traversal_2));

          textViews.add((TextView) findViewById(R.id.traversal_A_text));
          textViews.add((TextView) findViewById(R.id.traversal_B_text));
          textViews.add((TextView) findViewById(R.id.traversal_D_text));
          textViews.add((TextView) findViewById(R.id.traversal_G_text));
          textViews.add((TextView) findViewById(R.id.traversal_E_text));
          textViews.add((TextView) findViewById(R.id.traversal_H_text));
          textViews.add((TextView) findViewById(R.id.traversal_I_text));
          textViews.add((TextView) findViewById(R.id.traversal_C_text));
          textViews.add((TextView) findViewById(R.id.traversal_F_text));
          textViews.add((TextView) findViewById(R.id.traversal_J_text));

          final TextView found_list = (TextView) findViewById(R.id.traversal_found_list);
          found_list.setText("Found:  ");

          for (int i = 0; i < textViews.size(); i++) {
               final TextView node_text = textViews.get(i);
               node_text.setTextColor(getResources().getColor(R.color.traversal_gray));
          }

          Runnable runnables[] = new Runnable[textViews.size()];
          for (int i = 0; i < textViews.size(); i++) {
               runnables[i] = new Runnable(){
                    public void run(){
                    }
               };
          }

          Handler h = new Handler();
          Drawable play_stop_image = null;
          final ImageView play_stop = (ImageView) findViewById(R.id.traversal_play_stop);

          if (traversal_playing) {
               play_stop_image = getResources().getDrawable(R.drawable.traversal_play);
               stopTraversal(imageViews,h,runnables);
          }
          else {
               traversal_playing = true;
               play_stop_image = getResources().getDrawable(R.drawable.traversal_stop);
               int j = 0;
               for (int i = 0; i < imageViews.size(); i++) {
                    ImageView thisView = imageViews.get(i);
                    AnimationDrawable animation;
                    if (mode[i] == TRAVERSAL_VISITED || mode[i] == node) {
                         if (type[i] == node) {
                              final TextView node_text = textViews.get(j);
                              animation = TreeSimAnimation.animateTraversalNode(this, TRAVERSAL_VISITED, currentDuration);

                              runnables[j] = new Runnable(){
                                   public void run() {
                                        if (traversal_playing) {
                                             node_text.setTextColor(getResources().getColor(R.color.traversal_dpink));
                                             String node_letter = node_text.getText().toString();
                                             found_list.append(node_letter + "  ");
                                        }
                                   }
                              };

                              h.postDelayed(runnables[j], currentDuration);
                              j++;
                         }
                         else if (type[i] == line1l)
                              animation = TreeSimAnimation.animateTraversalLine1L(this, mode[i], currentDuration);
                         else if (type[i] == line2l)
                              animation = TreeSimAnimation.animateTraversalLine2L(this, mode[i], currentDuration);
                         else if (type[i] == line3l)
                              animation = TreeSimAnimation.animateTraversalLine3L(this, mode[i], currentDuration);
                         else if (type[i] == line1r)
                              animation = TreeSimAnimation.animateTraversalLine1R(this, mode[i], currentDuration);
                         else if (type[i] == line2r)
                              animation = TreeSimAnimation.animateTraversalLine2R(this, mode[i], currentDuration);
                         else
                              animation = TreeSimAnimation.animateTraversalLine3R(this, mode[i], currentDuration);
                         currentDuration += animDuration;
                         thisView.setImageDrawable(animation);
                         animation.start();
                    }
               }

               Runnable r = new Runnable(){
                    public void run() {
                         traversal_playing = false;
                         play_stop.setImageDrawable(getResources().getDrawable(R.drawable.traversal_play));
                    }
               };

               h.postDelayed(r, currentDuration);

          }

          if (traversal_playing) play_stop.setImageDrawable(play_stop_image);
     }

     /*
          Name: stopTraversal
          Creation Date: 04/16/2015
          Purpose: Stops an ongoing tree traversal
          Arguments:
               ArrayList<ImageView>  ArrayList of imageViews that contain the UI elements of the tree
               Handler handler  Handler that holds all the Runnables for the traversal
               Runnable[]  Array of Runnables
          Required File: treetraversal.xml, image_size.xml, TreeSimAnimation.java
          Return Value: none

     */

     public void stopTraversal(ArrayList<ImageView> imageViews, Handler handler, Runnable[] runnables) {

          int node = 0;
          int line1l = 1;
          int line1r = 2;
          int line2l = 3;
          int line2r = 4;
          int line3l = 5;
          int line3r = 6;

          int[] type = {node, line1l, node, line2l, node, line3r,
                  node, line3r, line2l, line2r, node, line3l,
                  node, line3l, line3r, node, line3r, line2r,
                  line1l, line1r, node, line2r, node, line3l,
                  node, line3l, line2r, line1r};
          int[] mode = {node, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED,
                  node, TRAVERSAL_VISITED, TRAVERSAL_VISITED, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED,
                  node, TRAVERSAL_VISITED, TRAVERSAL_UNVISITED, node, TRAVERSAL_VISITED, TRAVERSAL_VISITED,
                  TRAVERSAL_VISITED, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED, node, TRAVERSAL_UNVISITED,
                  node, TRAVERSAL_VISITED, TRAVERSAL_VISITED, TRAVERSAL_VISITED};

          for (int i = 0; i < imageViews.size(); i++) {
               ImageView thisView = imageViews.get(i);
               if (mode[i] == TRAVERSAL_VISITED || mode[i] == node) {
                    if (type[i] == node)
                         thisView.setImageDrawable(getResources().getDrawable(R.drawable.traversal_node_visited));
                    else if (type[i] == line1l)
                         thisView.setImageDrawable(getResources().getDrawable(R.drawable.traversal_line_1l_visited));
                    else if (type[i] == line2l)
                         thisView.setImageDrawable(getResources().getDrawable(R.drawable.traversal_line_2l_visited));
                    else if (type[i] == line3l)
                         thisView.setImageDrawable(getResources().getDrawable(R.drawable.traversal_line_3l_visited));
                    else if (type[i] == line1r)
                         thisView.setImageDrawable(getResources().getDrawable(R.drawable.traversal_line_1r_visited));
                    else if (type[i] == line2r)
                         thisView.setImageDrawable(getResources().getDrawable(R.drawable.traversal_line_2r_visited));
                    else
                         thisView.setImageDrawable(getResources().getDrawable(R.drawable.traversal_line_3r_visited));
               }
          }

          for (int i = 0; i < runnables.length; i++) {

               Runnable r = runnables[i];
               handler.removeCallbacks(r,null);

               runnables[i] = null;
          }
          handler.removeCallbacksAndMessages(null);

          handler = null;
          runnables = null;

          traversal_playing = false;

          final ImageView play_stop = (ImageView) findViewById(R.id.traversal_play_stop);
          play_stop.setImageDrawable(getResources().getDrawable(R.drawable.traversal_play));

     }

}
