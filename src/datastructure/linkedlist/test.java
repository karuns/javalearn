package datastructure.linkedlist;

import org.testng.annotations.Test;

public class test {
	@Test
	public void linkedlistTest () {
		CustomLinkedList cll= new CustomLinkedList();
		cll.add("a");
		cll.add("b");
		cll.print();
		
	}
}
