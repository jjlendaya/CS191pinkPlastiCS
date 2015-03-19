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
     Code Summary: Fragment for displaying the Postorder Tree Traversal option in demos.
*/


package com.pinkplastics.treesim;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link PostorderTraversalScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostorderTraversalScreen extends Fragment {

     private static final String ARG_POSITION = "position";
     private String mPosition;


     /**
      * Use this factory method to create a new instance of
      * this fragment using the provided parameters.
      *
      * @param position Parameter 1.
      * @return A new instance of fragment PreorderTraversalScreen.
      */
     // TODO: Rename and change types and number of parameters
     public static PostorderTraversalScreen newInstance(String position) {
          PostorderTraversalScreen fragment = new PostorderTraversalScreen();
          Bundle args = new Bundle();
          args.putString(ARG_POSITION, position);
          fragment.setArguments(args);
          return fragment;
     }

     public PostorderTraversalScreen() {
          // Required empty public constructor
     }

     @Override
     /**
      * Constructor
      * Creation Date: 3/13/2015
      * Purpose: Auto-generated function
      */
     public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          if (getArguments() != null) {
               mPosition = getArguments().getString(ARG_POSITION);
          }
     }

     @Override
     /**
      * onCreateView
      * Creation Date: 3/13/2015
      * Purpose: Standard android function for actions to perform when creating fragments.
      * @param inflater            default onCreateView parameter
      * @param container           default onCreateView parameter
      * @param savedInstanceState  default onCreateView parameter
      *
      * @return     Returns the View made by this fragment
      */
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
          // Inflate the layout for this fragment
          View view = inflater.inflate(R.layout.fragment_postorder_traversal_screen, container, false);

          Typeface heroFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/hero.otf");
          TextView builders = (TextView) view.findViewById(R.id.pott_screen_name);
          builders.setTypeface(heroFont);

          TextView desc = (TextView) view.findViewById(R.id.pott_description);
          desc.setTypeface(heroFont);

          TextView reminder = (TextView) view.findViewById(R.id.pott_tapscreen);
          reminder.setTypeface(heroFont);

          view.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), PostorderTraversalSimulation.class);
                    startActivity(intent);

               }
          });

          return view;
     }


}
