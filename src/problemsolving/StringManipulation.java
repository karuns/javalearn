package problemsolving;

import org.testng.annotations.Test;

public class StringManipulation {
	
	static int i = 0;
	@Test
	public void reverse() {
		System.out.println("reversed string ="+reverse("abcdefghijkl"));
	}

	private String reverse(String string) {
		if(!string.isEmpty()) {
			return reverse(string.substring(1))+string.charAt(0);
		}
		return "";
	}
	
	@Test
	public void printFibonacci() {
		printFibonacci(14);
	}

	private void printFibonacci(int n) {
		if(i<=n) {
			System.out.println(getfib(i));
			i++;
			printFibonacci(n);
		}
	}

	private int getfib(int n) {
		if(n == 0) {
			return 1;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return getfib(n-1)+getfib(n-2);
		}
	}
}
