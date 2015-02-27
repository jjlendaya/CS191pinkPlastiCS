package com.pinkplastics.treesim;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LinkedListSimulation extends ActionBarActivity {

     MyLinkedList ll;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_linked_list_simulation);

          ll = new MyLinkedList();
          defaultList();
     }


     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.menu_linked_list_simulation, menu);
          return true;
     }

     @Override
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
                    break;
               case R.id.ll_add_node:
                    break;
               default:
                    break;
          }

          return super.onOptionsItemSelected(item);
     }

     public void addNode() {
     }

     public void searchNode() {
     }

     public void clearList() {
     }

     public void defaultList() {
          ll.defaultList();
     }

     public void drawList() {

     }
}
