package intr;

import org.testng.annotations.Test;

public class Stringop {

	@Test
	public void substring() {
		String temp = "abcdefghijklmnop";
		System.out.println(temp.substring(0,6));
	}
}
