package datastructure;

import java.util.*;

import org.testng.annotations.Test;

public class Learn6_LinkedHashSet {
	
	@Test 
	public void testHashMapArrayList() {
		LinkedHashSet <String> v = new LinkedHashSet<String>();
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("c");
		System.out.println(v.toString());
		v.remove("d");
		v.remove("b");
		System.out.println(v.toString());
		v.add("e");
		System.out.println(v.toString());
	}
}
