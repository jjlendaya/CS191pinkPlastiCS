/*

“This is a course requirement for CS 192 Software Engineering II under the supervision of Asst.
Prof. Ma. Rowena C. Solamo of the Department of Computer Science, College of Engineering,
University of the Philippines, Diliman for the AY 2014-2015”

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

     /**
      * Constructor
      * Creation Date: 02/25/2015
      * Purpose: Create an abstract node for a linked list
      *
      * @param data the value to be contained in this node
      */
     public Node( int data ) {
          this.data = data;
          this.next = null;
     }

     /**
      * getData
      * Creation Date: 02/25/2015
      * Purpose: Called by linkedlist to get the integer data inside the current node
      *
      * @return     the value of the data contained by this node
      */
     public int getData() {
          return data;
     }
}