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
     Abbey Quinones      3/17/2015      Created and edited the file.
*/

/*
     File Creation Date: 3/13/2015
     Development Group: Pink Plastics
     Client Group: 080419 Android
     Code Summary: File containing animations for the tree traversals.
*/


package com.pinkplastics.treesim;

        import android.content.Context;
        import android.graphics.drawable.AnimationDrawable;

/**
 * Created by Abbey on 3/18/2015.
 */

public class TreeSimAnimation {

     final static int NODE_OBJECT = 0;
     final static int SHORT_ARROW = 1;
     final static int LONG_ARROW = 2;
     final static int SEARCH_NODE = 3;
     final static int FOUND_NODE = 4;

     final static int TRAVERSAL_UNVISITED = 1;
     final static int TRAVERSAL_VISITED = 2;
     final static int TRAVERSAL_FOUND = 3;

     final static int animDuration = 1000;

     public static AnimationDrawable animateNode(Context context, int mode, int duration) {
          //ImageView img1 = (ImageView)findViewById(R.id.try_node_animation1);
          //img1.setBackgroundResource(R.drawable.node_animate);
          AnimationDrawable nodeAnimation = new AnimationDrawable();

          nodeAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_node), duration);
          if (mode == SEARCH_NODE) nodeAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_node_selected), animDuration);
          else if (mode == FOUND_NODE) nodeAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_node_found), animDuration*(3/2));
          nodeAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_node), animDuration);
          nodeAnimation.setOneShot(true);

          return nodeAnimation;
     }

     public static AnimationDrawable animateArrow(Context context, int type, int duration) {

          AnimationDrawable arrowAnimation = new AnimationDrawable();
          if (type == SHORT_ARROW) {
               arrowAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_arrow), duration);
               arrowAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_arrow_selected), animDuration);
               arrowAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_arrow), animDuration);
          }
          else if (type == LONG_ARROW) {
               arrowAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_long_arrow), duration);
               arrowAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_long_arrow_selected), animDuration);
               arrowAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_long_arrow), animDuration);
          }
          arrowAnimation.setOneShot(true);

          //arrowAnimation.start();
          return arrowAnimation;
     }

     public static AnimationDrawable animateLambda(Context context, int duration) {
          AnimationDrawable lambdaAnimation = new AnimationDrawable();
          lambdaAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_lambda), duration);
          lambdaAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_lambda_selected), animDuration*(3/2));
          lambdaAnimation.addFrame(context.getResources().getDrawable(R.drawable.linked_list_lambda), animDuration);

          return lambdaAnimation;
     }

     public static AnimationDrawable animateTraversalNode(Context context, int mode, int duration) {
          AnimationDrawable traversalAnimation = new AnimationDrawable();
          if (mode == TRAVERSAL_UNVISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_node_unvisited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_node_visited), animDuration);
          }
          else if (mode == TRAVERSAL_VISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_node_visited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_node_found), animDuration);
          }
          return traversalAnimation;
     }

     public static AnimationDrawable animateTraversalLine1L(Context context, int mode, int duration) {
          AnimationDrawable traversalAnimation = new AnimationDrawable();
          if (mode == TRAVERSAL_UNVISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_1l_unvisited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_1l_visited), animDuration);
          }
          else if (mode == TRAVERSAL_VISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_1l_visited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_1l_found), animDuration);
          }
          return traversalAnimation;
     }

     public static AnimationDrawable animateTraversalLine2L(Context context, int mode, int duration) {
          AnimationDrawable traversalAnimation = new AnimationDrawable();
          if (mode == TRAVERSAL_UNVISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_2l_unvisited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_2l_visited), animDuration);
          }
          else if (mode == TRAVERSAL_VISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_2l_visited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_2l_found), animDuration);
          }
          return traversalAnimation;
     }

     public static AnimationDrawable animateTraversalLine3L(Context context, int mode, int duration) {
          AnimationDrawable traversalAnimation = new AnimationDrawable();
          if (mode == TRAVERSAL_UNVISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_3l_unvisited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_3l_visited), animDuration);
          }
          else if (mode == TRAVERSAL_VISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_3l_visited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_3l_found), animDuration);
          }
          return traversalAnimation;
     }

     public static AnimationDrawable animateTraversalLine1R(Context context, int mode, int duration) {
          AnimationDrawable traversalAnimation = new AnimationDrawable();
          if (mode == TRAVERSAL_UNVISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_1r_unvisited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_1r_visited), animDuration);
          }
          else if (mode == TRAVERSAL_VISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_1r_visited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_1r_found), animDuration);
          }
          return traversalAnimation;
     }

     public static AnimationDrawable animateTraversalLine2R(Context context, int mode, int duration) {
          AnimationDrawable traversalAnimation = new AnimationDrawable();
          if (mode == TRAVERSAL_UNVISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_2r_unvisited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_2r_visited), animDuration);
          }
          else if (mode == TRAVERSAL_VISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_2r_visited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_2r_found), animDuration);
          }
          return traversalAnimation;
     }

     public static AnimationDrawable animateTraversalLine3R(Context context, int mode, int duration) {
          AnimationDrawable traversalAnimation = new AnimationDrawable();
          if (mode == TRAVERSAL_UNVISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_3r_unvisited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_3r_visited), animDuration);
          }
          else if (mode == TRAVERSAL_VISITED) {
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_3r_visited), duration);
               traversalAnimation.addFrame(context.getResources().getDrawable(R.drawable.traversal_line_3r_found), animDuration);
          }
          return traversalAnimation;
     }



}
