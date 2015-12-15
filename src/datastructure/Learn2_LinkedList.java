package datastructure;

import java.util.*;

import org.testng.annotations.Test;

public class Learn2_LinkedList {
	/*
	 * Compared to vector or arraylist, linked list is used when insertion deletion is more frequent than search
	 */
	@Test 
	public void testArrayList() {
		LinkedList<String> v = new LinkedList<String>();
		//Vector is same too
		v.add("A");
		v.add("B");
		System.out.println(v.toString());
		System.out.println(v.get(1));
		v.remove("C");
		System.out.println(v.toString());
		v.remove("B");
		System.out.println(v.toString());
		
	}
	
}
