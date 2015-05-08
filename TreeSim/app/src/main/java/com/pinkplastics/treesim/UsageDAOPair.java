package com.pinkplastics.treesim;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jeynald on 5/7/2015.
 */
public class UsageDAOPair {

     String simulationName;
     int usageAmount;

     public UsageDAOPair(String simulationName, int usageAmount) {
          this.simulationName = simulationName;
          this.usageAmount = usageAmount;
     }

     public String getName() {
          return simulationName;
     }

     public void setName(String name) {
          this.simulationName = name;
     }

     public void addToAmount() {
          usageAmount++;
     }

     public String toString() {
          return simulationName + " " + Integer.toString(usageAmount);
     }
}
