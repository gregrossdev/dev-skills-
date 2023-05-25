// index.js
// iterative
"use strict";
const LinkedList = require('./LinkedList.js');
const Node = require('./Node.js');
//Access HeadNode => list.getHead()
//Check if list is empty => list.isEmpty()  
//Node class  { data ; Node nextElement;}

//Searches a value in the given list.
LinkedList.prototype.search = function(value) {
  //Start from the first element
	let currentNode = this.head; 

  //Traverse the list until you find the value or reach the end
	while (currentNode != null) {
		if(currentNode.data == value) {
			return true; //value found
		}
		currentNode = currentNode.nextElement
	}
  return false; //value not found
}

let list = new LinkedList();
list.insertAtHead(4);
list.insertAtHead(10);
list.insertAtHead(40);
list.insertAtHead(5);
list.printList();
console.log(list.search(4));
console.log(list.search(0));