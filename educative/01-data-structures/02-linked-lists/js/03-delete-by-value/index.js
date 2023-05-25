// index.js
"use strict";
const LinkedList = require('./LinkedList.js');
const Node = require('./Node.js');

//Access HeadNode => this.head
//Check if list is empty => this.isEmpty()
//Delete at head => this.deleteAtHead()
//Search for element => this.search(value)
//Node class  { data ; Node nextElement;}
LinkedList.prototype.deleteVal = function(value) {
  
	//if list is empty return false
  if (this.isEmpty()) {
    return false;
  }

	//else get pointer to head
  let currentNode = this.head;
	// if first node's is the node to be deleted, delete it and return true
  if (currentNode.data == value) {
    this.head = currentNode.nextElement;
    return true;
  }

	 // else traverse the list
	 while (currentNode.nextElement != null) {
    // if a node whose next node has the value as data, is found, delete it from the list and return true
    if (currentNode.nextElement.data == value) {
      currentNode.nextElement = currentNode.nextElement.nextElement;
      return true;
    }
    currentNode = currentNode.nextElement;
  }

	//else node was not found, return false
  return false;
}

let list = new LinkedList();
list.insertAtHead(2);
list.insertAtHead(4);
list.insertAtHead(5);
list.insertAtHead(7);
list.insertAtHead(1);
list.printList();
list.deleteVal(5);
list.printList();