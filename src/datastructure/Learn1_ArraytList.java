package datastructure;

import java.util.*;

import org.testng.annotations.Test;

public class Learn1_ArraytList {
	@Test 
	public void testArrayList() {
		ArrayList<String> v = new ArrayList <String>();
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
