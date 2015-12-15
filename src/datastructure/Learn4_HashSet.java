package datastructure;

import java.util.*;

import org.testng.annotations.Test;

public class Learn4_HashSet {
	
	@Test 
	public void testHashMapArrayList() {
		HashSet <String> v = new HashSet<String>();
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
