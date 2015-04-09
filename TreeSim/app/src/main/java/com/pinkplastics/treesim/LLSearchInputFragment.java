package com.pinkplastics.treesim;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.NumberPicker;

/**
 * Created by Jeynald on 3/12/2015.
 */


public class LLSearchInputFragment extends DialogFragment {

     public static final String EXTRA_INPUT_KEY = "com.pinkplastics.android.llsearchinputintent.number";

     NumberPicker searchKeyPicker;

     private int mInputKey;

     @Override
     public Dialog onCreateDialog(Bundle savedInstanceState) {
          mInputKey = getArguments().getInt(EXTRA_INPUT_KEY);
          View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_number_picker, null);
          searchKeyPicker = (NumberPicker) v.findViewById(R.id.dialog_number_picker);
          searchKeyPicker.setMinValue(0);
          searchKeyPicker.setMaxValue(99);
          searchKeyPicker.setValue(mInputKey);

          AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), AlertDialog.THEME_HOLO_LIGHT)
                  .setTitle(R.string.dialog_ll_search_node)
                  .setView(v);

          builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                    ((LinkedListSimulation)getActivity()).receiveSearchKey(searchKeyPicker.getValue());
               }

          });

          builder.setNegativeButton(android.R.string.cancel, null);

          return builder.create();
     }

     public static LLSearchInputFragment newInstance(int inputKey) {
          Bundle args = new Bundle();
          args.putInt(EXTRA_INPUT_KEY, inputKey);

          LLSearchInputFragment fragment = new LLSearchInputFragment();
          fragment.setArguments(args);

          return fragment;
     }

     public int getInputValue() {
          return searchKeyPicker.getValue();
     }
}
