package com.pinkplastics.treesim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Jeynald on 5/8/2015.
 */
public class UsageTrackerListAdapter extends BaseAdapter {

     FileHandler fh;
     List<UsageDAOPair> usageList;
     Context context;

     UsageTrackerListAdapter(FileHandler fh, Context context) {
          super();
          this.fh = fh;
          usageList = getDataForListView();
          this.context = context;
     }

     @Override
     public int getCount() {
          return usageList.size();
     }

     @Override
     public Object getItem(int arg0) {
          return usageList.get(arg0);
     }

     @Override
     public long getItemId(int arg0) {
          return arg0;
     }

     @Override
     public View getView(int arg0, View arg1, ViewGroup arg2) {
          if (arg1 == null) {
               LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               arg1 = inflater.inflate(R.layout.list_item_usage_tracker, arg2, false);
          }

          UsageTrackerTextView simulationName = (UsageTrackerTextView) arg1.findViewById(R.id.usage_tracker_list_simulation_name);
          UsageTrackerTextView simulationNumber = (UsageTrackerTextView) arg1.findViewById(R.id.usage_tracker_list_amount_tracker);
          UsageDAOPair item = usageList.get(arg0);
          simulationName.setText(item.getName().replace('.', ' '));
          simulationName.setTextColor(context.getResources().getColor(R.color.traversal_gray));
          simulationNumber.setText(Integer.toString(item.usageAmount));
          simulationNumber.setTextColor(context.getResources().getColor(R.color.traversal_gray));

          return arg1;

     }

     public List<UsageDAOPair> getDataForListView() {
          UsageDAO dao = new UsageDAO(fh);
          return dao.getList();
     }
}
