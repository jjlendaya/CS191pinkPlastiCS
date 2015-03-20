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
Jeynald Endaya      2/27/2015      Created and edited to handle initial screen for linked list sim
Jeynald Endaya      3/12/2015      Added search node dialog box
Jeynald Endaya      3/13/2015      Added to search node function: collecting data from NumberPicker.
Abbey Quinones      3/20/2015      Integrated Linked List Add, Delete, and Search simulations to main app.
*/

/*
File Creation Date: 2/27/2015
Development Group: Pink Plastics
Client Group: 080419 Android
Code Summary: Screen of the Linked List Simulation
 */


package com.pinkplastics.treesim;

import android.animation.LayoutTransition;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LinkedListSimulation extends ActionBarActivity {


     final int NODE_OBJECT = 0;
     final int SHORT_ARROW = 1;
     final int LONG_ARROW = 2;
     final int SEARCH_NODE = 3;
     final int FOUND_NODE = 4;

     final int TRAVERSAL_UNVISITED = 1;
     final int TRAVERSAL_VISITED = 2;
     final int TRAVERSAL_FOUND = 3;
     final int animDuration = 1000;

     private static final String SEARCH_NODE_TAG = "search";
     MyLinkedList ll;

     @Override
     /**
      * onCreate
      * Creation Date: 02/27/2015
      * Purpose: Default onCreate function for android
      *
      * @param savedInstanceState  for returning to this particular screen
      */
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_linked_list_simulation);

          setTitle("Linked Lists");

          final ViewGroup root = (ViewGroup)findViewById(R.id.main_layout);

          // -------------------- LINKED LIST IS ADDED HERE --------------------
          final MyLinkedList linkedList = new MyLinkedList();
          linkedList.defaultList();
          final LinearLayout linkedListLayout = createLinkedList(linkedList);
          root.addView(linkedListLayout);

          final EditText textField = new EditText(this);
          textField.setWidth(400);
          textField.setHeight(100);
          textField.setText("0");
          LinearLayout.LayoutParams tfParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          tfParams.setMargins(0,0,0,0);
          textField.setLayoutParams(tfParams);
          textField.setTextSize(30);

          TextView indexField = new TextView(this);
          indexField.setText("Index");
          indexField.setWidth(100);
          indexField.setHeight(100);
          LinearLayout.LayoutParams indexfParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          indexfParams.setMargins(0,0,0,0);
          indexField.setLayoutParams(indexfParams);
          indexField.setTextSize(30);

          LinearLayout indexGroup = new LinearLayout(this);
          LinearLayout.LayoutParams indexParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          indexParams.setMargins(0,20,0,0);
          indexGroup.setLayoutParams(indexParams);
          indexGroup.setOrientation(LinearLayout.HORIZONTAL);
          indexGroup.addView(indexField);
          indexGroup.addView(textField);
          root.addView(indexGroup);

          final EditText textField2 = new EditText(this);
          textField2.setWidth(400);
          textField2.setHeight(100);
          textField2.setText("0");
          textField2.setTextSize(30);
          LinearLayout.LayoutParams tf2Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          tf2Params.setMargins(0,0,0,0);
          textField.setLayoutParams(tf2Params);

          TextView inputField = new TextView(this);
          inputField.setText("Value");
          LinearLayout.LayoutParams inputfParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          inputfParams.setMargins(0,0,0,0);
          inputField.setLayoutParams(inputfParams);
          inputField.setWidth(100);
          inputField.setHeight(100);
          inputField.setTextSize(30);

          LinearLayout inputGroup = new LinearLayout(this);
          inputGroup.setOrientation(LinearLayout.HORIZONTAL);
          LinearLayout.LayoutParams inputParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          inputGroup.setLayoutParams(inputParams);
          inputGroup.addView(inputField);
          inputGroup.addView(textField2);
          root.addView(inputGroup);

          Button searchButton = new Button(this);
          LinearLayout.LayoutParams sbParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          //sbParams.setMargins(0, 650, 0, 0);
          searchButton.setText("Search\n(v)");
          searchButton.setTextSize(15);
          searchButton.setWidth(100);
          searchButton.setHeight(100);
          //sbParams.gravity = Gravity.CENTER_VERTICAL;
          searchButton.setLayoutParams(sbParams);
          searchButton.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    int searchNum = Integer.parseInt(textField2.getText().toString());
                    LinearLayout layout = (LinearLayout)root.getChildAt(0);
                    linkedListSearch(layout,searchNum);
               }
          });

          Button addButton = new Button(this);
          LinearLayout.LayoutParams abParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          //abParams.setMargins(250, 650, 0, 0);
          //abParams.gravity = Gravity.CENTER_VERTICAL;
          addButton.setText("Add\n(i,v)");
          addButton.setTextSize(15);
          addButton.setWidth(100);
          addButton.setHeight(100);
          addButton.setLayoutParams(abParams);
          addButton.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    int index= Integer.parseInt(textField.getText().toString());
                    int data = Integer.parseInt(textField2.getText().toString());
                    int linkedListIndex = 0;
                    for (int i = 0; i<root.getChildCount(); i++) {
                         if (root.getChildAt(i).equals(linkedListLayout)) {
                              linkedListIndex = i;
                              break;
                         }
                    }
                    root.removeViewAt(linkedListIndex);
                    root.addView(linkedListAdd(linkedList,data,index),linkedListIndex);

               }
          });

          Button deleteButton = new Button(this);
          LinearLayout.LayoutParams dbParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          //dbParams.setMargins(500, 650, 0, 0);
          deleteButton.setText("Delete\n(i)");
          deleteButton.setTextSize(15);
          //dbParams.gravity = Gravity.CENTER_VERTICAL;
          deleteButton.setWidth(100);
          deleteButton.setHeight(100);
          deleteButton.setLayoutParams(dbParams);
          deleteButton.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    int index = Integer.parseInt(textField.getText().toString());
                    int linkedListIndex = 0;
                    for (int i = 0; i<root.getChildCount(); i++) {
                         if (root.getChildAt(i).equals(linkedListLayout)) {
                              linkedListIndex = i;
                              break;
                         }
                    }
                    root.removeViewAt(linkedListIndex);
                    root.addView(linkedListDelete(linkedList, index),linkedListIndex);
               }
          });

          Button clearButton = new Button(this);
          LinearLayout.LayoutParams cbParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          //dbParams.setMargins(500, 650, 0, 0);
          cbParams.gravity = Gravity.CENTER_VERTICAL;
          clearButton.setText("Clear");
          clearButton.setTextSize(15);
          clearButton.setWidth(100);
          clearButton.setHeight(100);
          clearButton.setLayoutParams(cbParams);
          clearButton.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    int linkedListIndex = 0;
                    for (int i = 0; i<root.getChildCount(); i++) {
                         if (root.getChildAt(i).equals(linkedListLayout)) {
                              linkedListIndex = i;
                              break;
                         }
                    }
                    linkedList.clear();
                    root.removeViewAt(linkedListIndex);
                    root.addView(createLinkedList(linkedList),linkedListIndex);
               }
          });

          Button defaultButton = new Button(this);
          LinearLayout.LayoutParams dfParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          //dbParams.setMargins(500, 650, 0, 0);
          dfParams.gravity = Gravity.CENTER_VERTICAL;
          defaultButton.setText("Default");
          defaultButton.setTextSize(15);
          defaultButton.setWidth(100);
          defaultButton.setHeight(100);
          defaultButton.setLayoutParams(dfParams);
          defaultButton.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    int linkedListIndex = 0;
                    for (int i = 0; i<root.getChildCount(); i++) {
                         if (root.getChildAt(i).equals(linkedListLayout)) {
                              linkedListIndex = i;
                              break;
                         }
                    }
                    linkedList.defaultList();
                    root.removeViewAt(linkedListIndex);
                    root.addView(createLinkedList(linkedList),linkedListIndex);
               }
          });

          LinearLayout buttonGroup = new LinearLayout(this);
          LinearLayout.LayoutParams bgParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          bgParams.gravity = Gravity.CENTER_HORIZONTAL;
          buttonGroup.setOrientation(LinearLayout.HORIZONTAL);
          buttonGroup.setLayoutParams(bgParams);
          buttonGroup.addView(searchButton);
          buttonGroup.addView(addButton);
          buttonGroup.addView(deleteButton);
          buttonGroup.addView(clearButton);
          buttonGroup.addView(defaultButton);
          root.addView(buttonGroup);

     }


     @Override
     /**
      * onCreateOptionsMenu
      * Creation Date: 02/27/2015
      * Purpose: Default onCreateOptionsMenu for android activities
      *
      * @param menu the menu to be inflated
      * @return     boolean   always returns true if this method executes
      */
     public boolean onCreateOptionsMenu(Menu menu) {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.menu_linked_list_simulation, menu);
          return true;
     }

     @Override
     /**
      * onOptionsItemSelected
      * Creation Date: 02/27/2015
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

          switch (id) {
               case R.id.ll_clear_list:
                    break;
               case R.id.ll_default_list:
                    break;
               case R.id.ll_search_node:
                    searchNode();
                    break;
               case R.id.ll_add_node:
                    break;
               default:
                    break;
          }

          return super.onOptionsItemSelected(item);
     }

     /**
      * defaultList
      * Purpose: Function to handle button clicks to "Default Linked List" button
      * Creation Date: 02/27/2015
      */
     public void defaultList() {
          ll.defaultList();
     }

     /**
      * searchNode
      * Creation Date: 02/27/2015
      * Purpose: Handles the click to "Search Node" menu item. Shows a dialog box, gets input, and
      * passes the input value to animateLinkedList
      */
     public void searchNode() {
          FragmentManager fm = getSupportFragmentManager();
          LLSearchInputFragment inputDialog = new LLSearchInputFragment();
          inputDialog.show(fm, SEARCH_NODE_TAG);
          int[] userInput = new int[1];
          userInput[0] = inputDialog.getInputValue();
          //animateLinkedList(CONSTANT, userInput)
     }

     /*public void animateLinkedList() {

     }*/

     public LinearLayout createLinkedList(MyLinkedList linkedList) {
          LinearLayout outerLayout = new LinearLayout(this);
          outerLayout.setLayoutTransition(new LayoutTransition());
          outerLayout.setOrientation(LinearLayout.VERTICAL);
          LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          lParams.gravity = Gravity.CENTER_HORIZONTAL;
          //lParams.setMargins(500,0,0,0);
          outerLayout.setLayoutParams(lParams);

          int j = 0;
          for (int i = 0; i<linkedList.getSize(); i++) {
               if (i == 0) outerLayout.addView(createInnerLinkedListLayout());
               int data = linkedList.search(i);
               if (data != -1) {
                    FrameLayout node = createLinkedListNode(data);
                    addLinkedListNode(i, node, (LinearLayout) outerLayout.getChildAt(j));
                    if ((i + 1) % 3 == 0) {
                         ImageView long_arrow = new ImageView(this);
                         long_arrow.setImageDrawable(this.getResources().getDrawable(R.drawable.linked_list_long_arrow));
                         long_arrow.setAdjustViewBounds(true);
                         long_arrow.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                         long_arrow.setMaxWidth(480);
                         outerLayout.addView(long_arrow);
                         outerLayout.addView(createInnerLinkedListLayout());
                         j+=2;
                    }
               }
               else {
                    ImageView lambda = new ImageView(this);
                    lambda.setImageDrawable(this.getResources().getDrawable(R.drawable.linked_list_lambda));
                    lambda.setAdjustViewBounds(true);
                    lambda.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    lambda.setMaxWidth(120);
                    LinearLayout innerLayout = (LinearLayout) outerLayout.getChildAt(j);
                    innerLayout.addView(lambda);
               }
          }
          return outerLayout;
     }

    /*
          Name: createInnerLinkedListLayout
          Creation Date: 03/19/2015
          Purpose: Creates a new horizontal LinearLayout with default settings
          Arguments: none
          Required File: none
          Return Value: none

     */

     public LinearLayout createInnerLinkedListLayout() {
          //define all default settings
          LinearLayout innerLayout = new LinearLayout(this);
          innerLayout.setLayoutTransition(new LayoutTransition());
          innerLayout.setOrientation(LinearLayout.HORIZONTAL);
          //innerLayout.setGravity(Gravity.LEFT);
          LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          lParams.gravity = Gravity.START;
          innerLayout.setLayoutParams(lParams);

          return innerLayout;
     }

    /*
          Name: createLinkedListNode
          Creation Date: 03/19/2015
          Purpose: Creates a new linked list node with an ImageView and a TextView in a FrameLayout
          Arguments:
               Integer     Data stored in node
          Required File: treetraversal.xml, image_size.xml, linked_list_node.png
          Return Value: FrameLayout

     */

     public FrameLayout createLinkedListNode(int data) {
          FrameLayout frameLayout = new FrameLayout(this);
          StringBuilder text = new StringBuilder(Integer.toString(data));
          if (data < 10) text.insert(0,"0");
          TextView textView = new TextView(this);
          textView.setText(text.toString());
          textView.setTextSize(25);
          textView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
          textView.setPadding(20,5,0,0);

          ImageView imageView = new ImageView(this);
          imageView.setImageDrawable(this.getResources().getDrawable(R.drawable.linked_list_node));
          imageView.setAdjustViewBounds(true);
          imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
          imageView.setMaxWidth(120);

          frameLayout.addView(imageView);
          frameLayout.addView(textView);
          return frameLayout;
     }

    /*
          Name: addLinkedListNode
          Creation Date: 03/19/2015
          Purpose: Adds node to horizontal Linear Layout
          Arguments:
               Integer      Index of node to be added
               FrameLayout  Node represented by FrameLayout (generated by createLinkedListNode)
               LinearLayout Horizontal layout where node will be added
          Required File: linked_list_arrow.png
          Return Value: none
     */

     public void addLinkedListNode(int index,FrameLayout node,LinearLayout innerLayout) {
          innerLayout.addView(node);
          if ((index + 1) % 3 != 0) {
               ImageView short_arrow = new ImageView(this);
               short_arrow.setImageDrawable(this.getResources().getDrawable(R.drawable.linked_list_arrow));
               short_arrow.setAdjustViewBounds(true);
               short_arrow.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
               short_arrow.setMaxWidth(60);
               innerLayout.addView(short_arrow);
          }
     }

    /*
          Name: linkedListSearch
          Creation Date: 03/13/2015
          Purpose: -
          Arguments:
               LinearLayout     ViewGroup that contains linked list views
               Integer          Number to be searched
          Required File: TreeSimAnimation.java
          Return Value: none

     */

     public void linkedListSearch(LinearLayout rootView, int searchNum) {
          int currentDuration = animDuration;
          int childCount = rootView.getChildCount();
          for (int i = 0; i < childCount; i++) {
               if (rootView.getChildAt(i).getClass().equals(new ImageView(this).getClass())) {
                    ImageView thisView = (ImageView) rootView.getChildAt(i);
                    AnimationDrawable animation = TreeSimAnimation.animateArrow(this, LONG_ARROW, currentDuration);
                    currentDuration += animDuration;
                    thisView.setImageDrawable(animation);
                    animation.start();
               } else if (!rootView.getChildAt(i).getClass().equals(new Button(this).getClass())) {
                    ViewGroup viewGroup2 = (ViewGroup) rootView.getChildAt(i);
                    int childCount2 = viewGroup2.getChildCount();
                    for (int j = 0; j < childCount2; j++) {
                         if (viewGroup2.getChildAt(j).getClass().equals(new ImageView(this).getClass())) {
                              ImageView thisView = (ImageView) viewGroup2.getChildAt(j);
                              AnimationDrawable animation;
                              if (j == childCount2 - 1 && i == childCount - 1)
                                   animation = TreeSimAnimation.animateLambda(this, currentDuration);
                              else
                                   animation = TreeSimAnimation.animateArrow(this, SHORT_ARROW, currentDuration);
                              currentDuration += animDuration;
                              thisView.setImageDrawable(animation);
                              animation.start();
                              if (j == childCount2 - 1 && i == childCount - 2) return;
                         } else {
                              ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getChildAt(j);
                              int childCount3 = viewGroup3.getChildCount();
                              ImageView imageView = null;
                              for (int k = 0; k < childCount3; k++) {
                                   if (viewGroup3.getChildAt(k).getClass().equals(new ImageView(this).getClass())) {
                                        ImageView thisView = (ImageView) viewGroup3.getChildAt(k);
                                        AnimationDrawable animation;
                                        if (i == childCount - 1 && j == childCount2 - 1)
                                             animation = TreeSimAnimation.animateLambda(this, currentDuration);
                                        else
                                             animation = TreeSimAnimation.animateNode(this, SEARCH_NODE, currentDuration);
                                        currentDuration += animDuration;
                                        thisView.setImageDrawable(animation);
                                        imageView = thisView;
                                        animation.start();

                                   } else {
                                        TextView thisView = (TextView) viewGroup3.getChildAt(k);
                                        int nodeNum = Integer.parseInt(thisView.getText().toString());
                                        if (nodeNum == searchNum) {
                                             AnimationDrawable animation = TreeSimAnimation.animateNode(this, FOUND_NODE, currentDuration);
                                             imageView.setImageDrawable(animation);
                                             animation.start();
                                             return;
                                        }
                                   }
                              }
                         }
                    }
               }
          }
     }

    /*
          Name: linkedListAdd
          Creation Date: 03/19/2015
          Purpose: Adds node at specified index
          Arguments:
               MyLinkedList     Linked list to be updated
               Integer          Index of node to be added
          Required File: none
          Return Value: LinearLayout

     */

     public LinearLayout linkedListAdd(MyLinkedList linkedList, int data, int index) {
          if (index >= linkedList.getSize() || index < 0 || data < 0 || data > 99) Toast.makeText(getApplicationContext(), "I kenat", Toast.LENGTH_LONG).show();
          else linkedList.add(data,index);
          return createLinkedList(linkedList);
     }

    /*
          Name: linkedListDelete
          Creation Date: 03/19/2015
          Purpose: Deletes node at specified index
          Arguments:
               MyLinkedList     Linked list to be updated
               Integer          Index of node to be deleted
          Required File: none
          Return Value: LinearLayout

     */

     public LinearLayout linkedListDelete(MyLinkedList linkedList, int index) {
          if (index == linkedList.getSize()-1) Toast.makeText(getApplicationContext(), "I kenat", Toast.LENGTH_LONG).show();
          else linkedList.delete(index);
          return createLinkedList(linkedList);
     }




}