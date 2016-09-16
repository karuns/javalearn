package datastructure.linkedlist;

public class Node {
	public Node next = null;
	public String data = "";
	Node () {
		this.next = null;
		this.data = ""; 
	}
	Node (String value, Node n) {
		this.next = n;
		this.data = value; 
	}
}
