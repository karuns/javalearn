package datastructure;

import java.util.*;

import org.testng.annotations.Test;

public class Learn5_LinkedHashMap {
	
	@Test 
	public void testHashMapArrayList() {
		LinkedHashMap <String,String> v = new LinkedHashMap<String,String>();
		v.put("a","1");
		v.put("b","2");
		v.put("c","3");
		System.out.println(v.toString());
		v.remove("d");
		v.remove("b");
		System.out.println(v.toString());
		v.put("a","4");
		System.out.println(v.toString());
	}
}
