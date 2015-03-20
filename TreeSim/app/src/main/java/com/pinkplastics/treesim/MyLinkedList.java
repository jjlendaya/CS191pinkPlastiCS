/*

This is a course requirement for CS 192 Software Engineering II under the supervision of Asst.
Prof. Ma. Rowena C. Solamo of the Department of Computer Science, College of Engineering,
University of the Philippines, Diliman for the AY 2014-2015

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

Code History:
        Romeo Senen Albano     02/25/2015     Initial Draft
        Yzabel Iesa Quinones   03/19/2015     Changed linked list to accommodate null node

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
          add(-1,1);
          size++;
     }

     /*
          Name: add
          Creation Date: 02/25/2015
          Purpose: Inserting a node in a non-empty linkedlist in a secified index
          Arguments:
               Integer     Data to be added in the linkedlist
               Integer     Index where the node will be placed in the linkedlist
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
          Name: search
          Creation Date: 02/25/2015
          Purpose: Returns the integer data in the specified index in the linkedlist
          Arguments:
               Integer     Index of the desired data in the linkedlist
          Required File: Node File
          Return Value: integer

     */
     public int search( int index ) {
          Node current = head;

          for( int x=0; x<index; x++ ) {
               current = current.next;
          }

          return current.getData();
     }

     /*
          Name: clear
          Creation Date: 02/25/2015
          Purpose: Clearing the linked list / making the linked list into a null value
          Arguments: none
          Required File: Node File
          Return Value: none

     */
     public void clear() {
          head = new Node(-1);
          size = 1;
     }

     /*
          Name: defaultList
          Creation Date: 02/25/2015
          Purpose: Giving the linked list some default values
          Arguments: none
          Required File: none
          Return Value: none

     */
     public void defaultList() {
          clear();

          int[] data = { 99, 69, 25, 53, 3 };
          //Node n = null;

          initialize(data[0]);
          size--;

          for( int x=1; x<data.length; x++ ) {
               add( data[x], x );
          }
     }

     /*
          Name: getSize
          Creation Date: 02/25/2015
          Purpose: Getting the size of the linked list
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
          Purpose: Checking if the linked list is empty or not
          Arguments: none
          Required File: none
          Return Value: boolean

     */
     public boolean isEmpty() {
          return (head.getData() == -1);
     }
}