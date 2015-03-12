package com.pinkplastics.treesim;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.NumberPicker;

import java.util.Date;

/**
 * Created by Jeynald on 3/12/2015.
 */


public class LLSearchInputFragment extends DialogFragment {

     NumberPicker searchKeyPicker;


     @Override
     public Dialog onCreateDialog(Bundle savedInstanceState) {
          View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_number_picker, null);
          searchKeyPicker = (NumberPicker) v.findViewById(R.id.dialog_numberPicker);
          searchKeyPicker.setMinValue(0);
          searchKeyPicker.setMaxValue(99);

          return new AlertDialog.Builder(getActivity(), AlertDialog.THEME_HOLO_LIGHT)
                  .setTitle(R.string.dialog_ll_search_node)
                  .setPositiveButton(android.R.string.ok, null)
                  .setNegativeButton(android.R.string.cancel, null)
                  .setView(v)
                  .create();
     }


     public int getInputValue() {
          return searchKeyPicker.getValue();
     }
}
