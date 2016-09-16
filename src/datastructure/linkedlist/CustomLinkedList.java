package datastructure.linkedlist;

public class CustomLinkedList {
	Node head  = new Node("",null);
	
	public void add(String value) {
			head = new Node(value, head);
	}
	
	public void print() {
		System.out.println(head.toString());
//		while (head !=null) {
//			System.out.println(head.data);
//			head = head.next;
//		}
	}

}
