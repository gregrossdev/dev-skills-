// index.js
"use strict";
const LinkedList = require('./LinkedList.js');
const Node = require('./Node.js');

//Access HeadNode => list.getHead()
//Check if list is empty => list.isEmpty()
//Insert at head => list.insertAtHead(value)
//Delete at head => list.deleteAtHead()
//Insert at tail => list.insertAtTail(value)
//Search for element => list.search(value)
//Delete by value => list.deleteVal(value)
//Node class { data ; Node nextElement;}

function length(list) {
  let length = 0;
  let currentNode = list.getHead();
	while (currentNode != null) {
		length++; 
		currentNode = currentNode.nextElement;
	}

  return length;
}

let list = new LinkedList();
list.insertAtHead(4);
list.insertAtHead(3);
list.insertAtHead(2);
list.insertAtHead(1);
list.insertAtHead(0);
console.log(length(list));