package datastructure;

import java.util.*;

import org.testng.annotations.Test;

public class Learn7_SortingLists {
	
	@Test 
	public void testHashMapArrayLists() {
		LinkedList <String> v = new LinkedList<String>();
		v.add("tiger");
		v.add("cat");
		v.add("snake");
		v.add("dog");
		System.out.println(v.toString());
		Collections.sort(v);
		System.out.println(v.toString());
	}
	
	@Test 
	public void testHashMapArrayList2() {
		ArrayList <String> v = new ArrayList<String>();
		v.add("tiger");
		v.add("cat");
		v.add("snake");
		v.add("dog");
		System.out.println(v.toString());
		Collections.sort(v);
		System.out.println(v.toString());
		
		
		System.out.println("max="+Collections.max(v).toString());
		System.out.println("min="+Collections.min(v).toString());
		Collections.reverse(v);
		System.out.println("reverse="+v.toString());
		Collections.shuffle(v);
		System.out.println("shuffle="+v.toString());
	}
}
