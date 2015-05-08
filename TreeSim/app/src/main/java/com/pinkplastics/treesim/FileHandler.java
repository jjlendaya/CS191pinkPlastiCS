package com.pinkplastics.treesim;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jeynald on 5/7/2015.
 */
public class FileHandler {

     public static final String USAGE_FILE_NAME = "UsageTracker.txt";

     File file;
     ArrayList<String> fileLines;
     int nextPair;

     public FileHandler(Context context) {
          file = new File(context.getFilesDir(), USAGE_FILE_NAME);

          try {
               Log.d("FILE PROCESS", "CHECKING NEW FILE");
               if (!file.exists()) {
                    Log.d("FILE PROCESS", "CREATED NEW FILE");
                    file.createNewFile();
               }
          } catch (IOException e) {
               Log.d("FILE ERROR", "Could not create Usage Tracker file!");
          }

          Scanner fileScanner = null;
          try {
               fileScanner = new Scanner(file);
          } catch (FileNotFoundException e) {
               Log.d("FILE ERROR", "Could not find Usage Tracker file for scanner.");
          }

          fileLines = new ArrayList<String>(0);
          while (fileScanner.hasNextLine()) fileLines.add(fileScanner.nextLine());
          nextPair = 0;
     }

     public int getTotal() {
          return fileLines.size();
     }

     public boolean hasNextPair() {
          return (nextPair < fileLines.size());
     }

     public String getLine() {
          nextPair++;
          if (nextPair - 1 >= getTotal()) return null;
          return fileLines.get(nextPair - 1);
     }

     public void writeToFile(UsageDAO toWrite) {
          FileOutputStream fos = null;
          try {
               fos = new FileOutputStream(file, false);
          } catch(FileNotFoundException e) {
               Log.d("FILE ERROR", "Cannot find output file for writing!");
          }

          PrintWriter out = new PrintWriter(fos);
          out.print(toWrite.toString());
          out.flush();
          out.close();
     }

}
