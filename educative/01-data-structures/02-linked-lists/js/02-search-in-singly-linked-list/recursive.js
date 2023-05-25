// index.js
// recursive
"use strict";
const LinkedList = require('./LinkedList.js');
const Node = require('./Node.js');

LinkedList.prototype.search = function(value) {
	return this.searchRecursive(this.head, value); 
}

LinkedList.prototype.searchRecursive= function(value) {
  //Base case 
	if (node == null) {
		return false; 
	}
	
	//Check if the node's value contains the required value
	if (node.data == value) {
		return true; //value found
	}

	//Recursive call to the next node in the list
	return this.searchRecursive(node.nextElement, value); 
}

let list = new LinkedList();
list.insertAtHead(4);
list.insertAtHead(10);
list.insertAtHead(40);
list.insertAtHead(5);
list.printList();
console.log(list.search(4));
console.log(list.search(0));