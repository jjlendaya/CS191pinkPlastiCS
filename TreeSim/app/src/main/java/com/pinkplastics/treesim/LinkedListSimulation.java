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
import android.app.Dialog;
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
import android.widget.NumberPicker;
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

     final int NODE_SIZE = 152;
     final int SHORT_ARROW_SIZE = 77;
     final int LONG_ARROW_SIZE = 604;
     final float NODE_TEXT = 20.25f;
     final int NODE_TEXT_TMARGIN = 8;
     final int NODE_TEXT_LMARGIN = 18;

     final static int ADD_ACTION = 0;
     final static int DELETE_ACTION = 1;
     final static int SEARCH_ACTION = 2;
     final static int RESET_ACTION = 3;
     final static int CLEAR_ACTION = 4;
     Dialog searchNodeDialog = null;
     Dialog addNodeDialog = null;
     Dialog deleteNodeDialog = null;
     Dialog clearListDialog = null;
     Dialog defaultListDialog = null;

     boolean menu_enabled = true;

     NumberPicker np;
     NumberPicker index;
     NumberPicker value;

     LinearLayout linkedListLayout;
     MyLinkedList linkedList;

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

          setTitle("Linked List Builder");

          final ViewGroup root = (ViewGroup)findViewById(R.id.main_layout);


          // -------------------- LINKED LIST IS ADDED HERE --------------------
          linkedList = new MyLinkedList();
          linkedList.defaultList();
          linkedListLayout = createLinkedList(linkedList);
          root.addView(linkedListLayout);


          // -------------------- MENU IS ADDED HERE --------------------

          final ImageView add = (ImageView)findViewById(R.id.linked_list_menu_add);
          add.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {

                    // set animation
                    if (menu_enabled) {
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), ADD_ACTION);
                         add.setImageDrawable(animation);
                         animation.start();

                         handleAddNode();
                    }

               }
          });

          final ImageView delete = (ImageView)findViewById(R.id.linked_list_menu_delete);
          delete.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {

                    if (menu_enabled) {
                         // set animation
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), DELETE_ACTION);
                         delete.setImageDrawable(animation);
                         animation.start();

                         handleDeleteNode();
                    }
               }
          });

          final ImageView search = (ImageView)findViewById(R.id.linked_list_menu_search);
          search.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {

                    if (menu_enabled) {
                         // set animation
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), SEARCH_ACTION);
                         search.setImageDrawable(animation);
                         animation.start();

                         handleSearchNode();
                    }
               }
          });

          final ImageView reset = (ImageView)findViewById(R.id.linked_list_menu_reset);
          reset.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    if (menu_enabled) {
                         // set animation
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), RESET_ACTION);
                         reset.setImageDrawable(animation);
                         animation.start();

                         int linkedListIndex = root.getChildCount() - 1;
                         linkedList.defaultList();
                         root.removeViewAt(linkedListIndex);
                         root.addView(createLinkedList(linkedList), linkedListIndex);
                    }
               }
          });

          final ImageView clear = (ImageView)findViewById(R.id.linked_list_menu_clear);
          clear.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                    if (menu_enabled) {
                         // set animation
                         AnimationDrawable animation = TreeSimAnimation.animateMenuItem(getApplicationContext(), CLEAR_ACTION);
                         clear.setImageDrawable(animation);
                         animation.start();

                         int linkedListIndex = root.getChildCount() - 1;
                         linkedList.clear();
                         root.removeViewAt(linkedListIndex);
                         root.addView(createLinkedList(linkedList), linkedListIndex);
                    }
               }
          });

          final ImageView menu = (ImageView)findViewById(R.id.linked_list_menu_button);
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
                    } else {
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
               case R.id.ll_search_node:
                    handleSearchNode();
                    break;
               case R.id.ll_add_node:
                    handleAddNode();
                    break;
               case R.id.ll_delete_node:
                    handleDeleteNode();
                    break;
               /*
               case R.id.ll_clear_list:
                    handleClearList();
                    break;
               case R.id.ll_default_list:
                    handleDefaultList();
                    break;*/
               default:
                    break;
          }

          return super.onOptionsItemSelected(item);
     }

     public ViewGroup getRootView() {
          return (ViewGroup) findViewById(R.id.main_layout);
     }

     public void handleSearchNode() {
          searchNodeDialog = new Dialog(LinkedListSimulation.this);
          searchNodeDialog.setTitle("Search Node");
          searchNodeDialog.setContentView(R.layout.dialog_number_picker);

          np = (NumberPicker) searchNodeDialog.findViewById(R.id.ll_dialog_number_picker);
          np.setMaxValue(99);
          np.setMinValue(0);
          np.setWrapSelectorWheel(true);
          Button acceptButton = (Button) searchNodeDialog.findViewById(R.id.ll_dialog_positive);
          Button cancelButton = (Button) searchNodeDialog.findViewById(R.id.ll_dialog_cancel);
          acceptButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    int linkedListIndex = getRootView().getChildCount() - 1;
                    LinkedListSimulation.this.linkedListSearch((LinearLayout) LinkedListSimulation.this.getRootView().getChildAt(linkedListIndex), np.getValue());
                    searchNodeDialog.dismiss();
               }
          });
          cancelButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    searchNodeDialog.dismiss();
                    np = null;
               }
          });
          searchNodeDialog.show();
     }

     public void handleAddNode() {
          addNodeDialog = new Dialog(LinkedListSimulation.this);
          addNodeDialog.setTitle("Add Node");
          addNodeDialog.setContentView(R.layout.dialog_linked_list_add_node);
          value = (NumberPicker) addNodeDialog.findViewById(R.id.ll_dialog_add_value_number_picker);
          index = (NumberPicker) addNodeDialog.findViewById(R.id.ll_dialog_add_index_number_picker);
          value.setMinValue(0);
          value.setMaxValue(99);
          index.setMinValue(0);
          index.setMaxValue(99);
          value.setWrapSelectorWheel(true);
          index.setWrapSelectorWheel(true);
          Button acceptButton = (Button) addNodeDialog.findViewById(R.id.ll_dialog_add_positive);
          Button cancelButton = (Button) addNodeDialog.findViewById(R.id.ll_dialog_cancel);
          acceptButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    ViewGroup root = getRootView();
                    int linkedListIndex = root.getChildCount() - 1;

                    // Replace with dialogue box function
                    root.removeViewAt(linkedListIndex);
                    root.addView(linkedListAdd(linkedList, value.getValue(), index.getValue()), linkedListIndex);
                    addNodeDialog.dismiss();
               }
          });
          cancelButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    addNodeDialog.dismiss();
                    value = null;
                    index = null;
               }
          });
          addNodeDialog.show();
     }

     public void handleDeleteNode() {
          deleteNodeDialog = new Dialog(LinkedListSimulation.this);
          deleteNodeDialog.setTitle("Delete Node");
          deleteNodeDialog.setContentView(R.layout.dialog_linked_list_delete_node);

          np = (NumberPicker) deleteNodeDialog.findViewById(R.id.ll_dialog_delete_number_picker);
          np.setMaxValue(99);
          np.setMinValue(0);
          np.setWrapSelectorWheel(true);
          Button acceptButton = (Button) deleteNodeDialog.findViewById(R.id.ll_dialog_delete_positive);
          Button cancelButton = (Button) deleteNodeDialog.findViewById(R.id.ll_dialog_cancel);
          acceptButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    deleteNodeDialog.dismiss();
                    ViewGroup root = getRootView();
                    int linkedListIndex = root.getChildCount() - 1;
                    root.removeViewAt(linkedListIndex);
                    root.addView(linkedListDelete(linkedList, np.getValue()), linkedListIndex);
               }
          });
          cancelButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    deleteNodeDialog.dismiss();
                    np = null;
               }
          });
          deleteNodeDialog.show();
     }

     /**
      * defaultList
      * Purpose: Function to handle button clicks to "Default Linked List" button
      * Creation Date: 02/27/2015
      */
     public void defaultList() {
          ll.defaultList();
     }

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
                         long_arrow.setMaxWidth(LONG_ARROW_SIZE);
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
                    lambda.setMaxWidth(NODE_SIZE);
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
          textView.setTextSize(NODE_TEXT);
          textView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
          textView.setPadding(NODE_TEXT_LMARGIN,NODE_TEXT_TMARGIN,0,0);

          ImageView imageView = new ImageView(this);
          imageView.setImageDrawable(this.getResources().getDrawable(R.drawable.linked_list_node));
          imageView.setAdjustViewBounds(true);
          imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
          imageView.setMaxWidth(NODE_SIZE);

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
               short_arrow.setMaxWidth(SHORT_ARROW_SIZE);
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
          if (index >= linkedList.getSize() || index < 0 || data < 0 || data > 99) {
               String message;
               if (index >= linkedList.getSize() || index< 0) message = "Invalid index";
               else message = "Invalid data";
               Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
               LinearLayout toastLayout = (LinearLayout) toast.getView();
               TextView toastTV = (TextView) toastLayout.getChildAt(0);
               toastTV.setTextSize(15);
               toast.show();
          }
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
          if (index == linkedList.getSize()-1 || index >= linkedList.getSize() || index < 0) {
               Toast toast = Toast.makeText(getApplicationContext(), "Invalid index", Toast.LENGTH_LONG);
               LinearLayout toastLayout = (LinearLayout) toast.getView();
               TextView toastTV = (TextView) toastLayout.getChildAt(0);
               toastTV.setTextSize(15);
               toast.show();
          }
          else linkedList.delete(index);
          return createLinkedList(linkedList);
     }

}