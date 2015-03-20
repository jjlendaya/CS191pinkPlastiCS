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
     Code Summary: Fragment for displaying the Inorder Tree Traversal option in demos.
*/

package com.pinkplastics.treesim;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;


public class InorderTraversalSimulation extends ActionBarActivity {

     final int NODE_OBJECT = 0;
     final int SHORT_ARROW = 1;
     final int LONG_ARROW = 2;
     final int SEARCH_NODE = 3;
     final int FOUND_NODE = 4;

     final int TRAVERSAL_UNVISITED = 1;
     final int TRAVERSAL_VISITED = 2;
     final int TRAVERSAL_FOUND = 3;

     final int animDuration = 1000;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.treetraversal);

          FrameLayout fl = (FrameLayout) findViewById(R.id.NodeLayout);
          /*Button btn = new Button(this);
          FrameLayout.LayoutParams btnParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          btnParams.setMargins(0,0,0,0);
          btn.setLayoutParams(btnParams);

          btn.setText("Play");
          fl.addView(btn);*/

          fl.setOnClickListener(
                  new View.OnClickListener() {
                       public void onClick(View v) {
                            inorderTraversal();
                       }
                  }
          );
     }


     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.menu_inorder_traversal_simulation, menu);
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
          Name: inorderTraversal
          Creation Date: 02/25/2015
          Purpose: Demonstrates the inorder tree traversal using animations and a default tree
          Arguments:
               View     View that calls the function
          Required File: treetraversal.xml, image_size.xml, TreeSimAnimation.java
          Return Value: none

     */

     public void inorderTraversal() {
          int currentDuration = animDuration;
          ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
          int node = 0;
          int line1l = 1;
          int line1r = 2;
          int line2l = 3;
          int line2r = 4;
          int line3l = 5;
          int line3r = 6;

          int[] type = {node, line1l, node, line2l, node, node, line3r,node,node,line3r,
                  line2l,node,line2r,node,line3l,node,node,line3l,node,line3r,
                  node,node,line3r,line2r,line1l,node,line1r,node,node,line2r,
                  node,line3l,node,node,line3l,node,line2r,line1r};
          int[] mode = {TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,
                  TRAVERSAL_VISITED,TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,TRAVERSAL_VISITED,TRAVERSAL_VISITED,
                  TRAVERSAL_VISITED,TRAVERSAL_VISITED,TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,
                  TRAVERSAL_UNVISITED,TRAVERSAL_VISITED,TRAVERSAL_VISITED,TRAVERSAL_VISITED,TRAVERSAL_UNVISITED,
                  TRAVERSAL_UNVISITED,TRAVERSAL_VISITED,TRAVERSAL_VISITED,TRAVERSAL_VISITED,TRAVERSAL_VISITED,
                  TRAVERSAL_VISITED,TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,TRAVERSAL_VISITED,TRAVERSAL_UNVISITED,
                  TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,TRAVERSAL_UNVISITED,TRAVERSAL_VISITED,TRAVERSAL_VISITED,
                  TRAVERSAL_VISITED,TRAVERSAL_VISITED,TRAVERSAL_VISITED};

          imageViews.add((ImageView) findViewById(R.id.traversal_A));
          imageViews.add((ImageView) findViewById(R.id.traversal_1));
          imageViews.add((ImageView) findViewById(R.id.traversal_B));
          imageViews.add((ImageView) findViewById(R.id.traversal_3));
          imageViews.add((ImageView) findViewById(R.id.traversal_D));
          imageViews.add((ImageView) findViewById(R.id.traversal_D));
          imageViews.add((ImageView) findViewById(R.id.traversal_6));
          imageViews.add((ImageView) findViewById(R.id.traversal_G));
          imageViews.add((ImageView) findViewById(R.id.traversal_G));
          imageViews.add((ImageView) findViewById(R.id.traversal_6));

          imageViews.add((ImageView) findViewById(R.id.traversal_3));
          imageViews.add((ImageView) findViewById(R.id.traversal_B));
          imageViews.add((ImageView) findViewById(R.id.traversal_4));
          imageViews.add((ImageView) findViewById(R.id.traversal_E));
          imageViews.add((ImageView) findViewById(R.id.traversal_7));
          imageViews.add((ImageView) findViewById(R.id.traversal_H));
          imageViews.add((ImageView) findViewById(R.id.traversal_H));
          imageViews.add((ImageView) findViewById(R.id.traversal_7));
          imageViews.add((ImageView) findViewById(R.id.traversal_E));
          imageViews.add((ImageView) findViewById(R.id.traversal_8));

          imageViews.add((ImageView) findViewById(R.id.traversal_I));
          imageViews.add((ImageView) findViewById(R.id.traversal_I));
          imageViews.add((ImageView) findViewById(R.id.traversal_8));
          imageViews.add((ImageView) findViewById(R.id.traversal_4));
          imageViews.add((ImageView) findViewById(R.id.traversal_1));
          imageViews.add((ImageView) findViewById(R.id.traversal_A));
          imageViews.add((ImageView) findViewById(R.id.traversal_2));
          imageViews.add((ImageView) findViewById(R.id.traversal_C));
          imageViews.add((ImageView) findViewById(R.id.traversal_C));
          imageViews.add((ImageView) findViewById(R.id.traversal_5));

          imageViews.add((ImageView) findViewById(R.id.traversal_F));
          imageViews.add((ImageView) findViewById(R.id.traversal_9));
          imageViews.add((ImageView) findViewById(R.id.traversal_J));
          imageViews.add((ImageView) findViewById(R.id.traversal_J));
          imageViews.add((ImageView) findViewById(R.id.traversal_9));
          imageViews.add((ImageView) findViewById(R.id.traversal_F));
          imageViews.add((ImageView) findViewById(R.id.traversal_5));
          imageViews.add((ImageView) findViewById(R.id.traversal_2));

          for (int i = 0; i<imageViews.size(); i++) {
               ImageView thisView = imageViews.get(i);
               AnimationDrawable animation;
               if (mode[i] == TRAVERSAL_VISITED) {
                    if (type[i] == node)
                         animation = TreeSimAnimation.animateTraversalNode(this, mode[i], currentDuration);
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
     }


}
