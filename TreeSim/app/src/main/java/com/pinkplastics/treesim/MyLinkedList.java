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
     Purpose: This file performs the backend implementations of the linkedlist for Demo module's Linkedlist Simulation

*/
package com.pinkplastics.treesim;

public class MyLinkedList {
     public Node head;
     public int size;

     public MyLinkedList() {
          this.head = null;
          this.size = 0;
     }

     /* 
          Name: initialize
          Creation Date: 02/25/2015
          Purpose: Used to give/initialize a node in an empty linkedlist
          Arguments:
               Integer    Data to be added in an empty linkedlist 
          Required File: Node File
          Return Value: none

     */
     public void initialize( int data ) {
          head = new Node(data);
          size++;
     }

     /* 
          Name: add
          Creation Date: 02/25/2015
          Purpose: Inserting a node in a non-empty Linked List in a specified index
          Arguments:
               Integer     Data to be added in the Linked List
               Integer     Index where the node will be placed in the Linked List
          Required File: Node File
          Return Value: none

     */
     public void add( int data, int index ) {
          Node current = head;
          Node previous = null;
          Node new_n = new Node(data);

          if( index == 0 ) {
               new_n.next = head;
               head = new_n;
          }
          
          else {
               for( int x=0; x<index; x++ ) {
                    previous = current;
                    current = current.next;
               }

               new_n.next = current;
               previous.next = new_n;
          }

          size++;
     }


     /* 
          Name: delete
          Creation Date: 02/25/2015
          Purpose: Deleting a index specified node from a non-empty linkedlist
          Arguments:
               Integer     Index of the node to be deleted from the linkedlist
          Required File: Node File
          Return Value: none

     */
     public void delete( int index ) {
          Node current = head;
          Node previous = null;

          if( isEmpty() || index >= size ) {
               return;
          }

          if( index == 0 ) {
               head = current.next;
               current.next = null;
          }
          
          else {
               for( int x=0; x<index; x++ ) {
                    previous = current;
                    current = current.next;
               }
               previous.next = current.next;
               current.next = null;
          }

          size--;
     }

     /* 
          Name: getItem
          Creation Date: 02/25/2015
          Purpose: Returns the integer data in the specified index in the linkedlist 
          Arguments:
               Integer     Index of the desired data in the linkedlist
          Required File: Node File
          Return Value: integer

     */
     public int getItem( int index ) {
          Node current = head;

          for( int x=0; x < index; x++ ) {
               current = current.next;
          }

          return current.getData();
     }

     /*
          Name: search
          Creation Date: 02/26/2015
          Purpose: Returns the index of a node that contains a given value.
          Arguments:
               Integer     Value of that is being searched in the list
          Required File: Node File
          Return Value:
               Integer     Index of the node that contains the value being searched.
               -1          If the value cannot be found in the linked list.

     */
     public int search( int value ) {
          Node current = head;

          int x;
          for( x=0; current.getData() != value && x < this.getSize(); x++ ) {
               current = current.next;
          }

          return (x==this.getSize())?-1:x;
     }

     /* 
          Name: clear
          Creation Date: 02/25/2015
          Purpose: Clearing the linkedlist / making the linkedlist into a null value
          Arguments: none
          Required File: Node File
          Return Value: none

     */
     public void clear() {
          head = null;
          size = 0;
     }

     /* 
          Name: defaultList
          Creation Date: 02/25/2015
          Purpose: Giving the linkedlist some default values
          Arguments: none
          Required File: none
          Return Value: none

     */
     public void defaultList() {
          clear();
          
          int[] data = { 1, 2, 3 };
          Node n = null;

          initialize(data[0]);

          for( int x=1; x<3; x++ ) {
               add( data[x], x );
          }
     }

     /* 
          Name: getSize
          Creation Date: 02/25/2015
          Purpose: Getting the size of the linkedlist
          Arguments: none
          Required File: none
          Return Value: integer

     */
     public int getSize() {
          return size;
     }

     /* 
          Name: isEmpty
          Creation Date: 02/25/2015
          Purpose: Checking if the linkedlist is empty or not
          Arguments: none
          Required File: none
          Return Value: boolean

     */
     public boolean isEmpty() {
          return (head == null);
     }

}