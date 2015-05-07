package com.pinkplastics.treesim;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jeynald on 5/7/2015.
 */
public class UsageDAO {

     ArrayList<UsageDAOPair> usageTracks;
     FileHandler fh;

     public UsageDAO(FileHandler fh) {
          this.fh = fh;
          usageTracks = new ArrayList<>();
          for (int i = 0; fh.hasNextPair(); i++) {
               String line = fh.getLine();
               Scanner sc = new Scanner(line);
               Log.d("GETTING LINE", line);
               usageTracks.add(new UsageDAOPair(sc.next().trim(), sc.nextInt()));
          }

     }

     public void addToSimulation(String simulation) {
          int simulationNum = searchSimulation(simulation);
          if (simulationNum == -1) {
               usageTracks.add(new UsageDAOPair(simulation, 1));
               Log.d("HAPPINESS", "Added: " + simulation);
          }
          else usageTracks.get(simulationNum).addToAmount();

     }

     public int searchSimulation(String key) {
          int i = 0;
          Log.d("SEARCHING", key);
          Log.d("SEARCHING", Integer.toString(usageTracks.size()));
          while (i < usageTracks.size() && !usageTracks.get(i).getName().equals(key)) {
               Log.d("SEARCHING", "FOUND: " + usageTracks.get(i).getName());
               i++;
          }
          if (i >= usageTracks.size()) return -1;
          else return i;
     }

     public ArrayList<UsageDAOPair> getList() {
          return usageTracks;
     }

     public void processDAOPairs() {
          for (int i = 0; i < usageTracks.size(); i++) {
               usageTracks.get(i).setName(usageTracks.get(i).getName().replace('.', ' '));
          }
     }

     public void saveToFile() {
          fh.writeToFile(this);
     }

     public String toString() {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < usageTracks.size(); i++) {
               sb.append(usageTracks.get(i).toString());
               sb.append("\n");
          }
          Log.d("WRITING TO FILE", sb.toString().trim());
          return sb.toString().trim();
     }

}
