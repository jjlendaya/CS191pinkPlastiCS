/*
License: 
This is a course requirement for CS 192 Software Engineering II 
under the supervision of Asst. Prof. Ma. Rowena C. Solamo of 
the Department of Computer Science, College of Engineering, 
University of the Philippines, Diliman for the AY 2014-2015.

Authors:
     ALBANO, Romeo Senen
     ENDAYA, Jeynald Jeyromme
     QUINONES, Yzabel Iesa

Code History: 
     Romeo Senen Albano     02/25/2015     Initial Draft
*/

/*
     File Creation Date: 02/25/2015
     Development Group: Pink PlastiCS
     Client Group: #080419 Android 
     Purpose: This file helps the backend of linkedlist implementation as the node storage of data in the linkedlist

*/
package com.pinkplastics.treesim;

public class Node {
     public int data;
     public Node next;

     public Node( int data ) {
          this.data = data;
          this.next = null;
     }

     /* 
          Name: getData
          Creation Date: 02/25/2015
          Purpose: Called by linkedlist to get the integer data inside the current node
          Arguments: none
          Required File: none
          Return Value: integer

     */
     public int getData() {
          return data;
     }
}