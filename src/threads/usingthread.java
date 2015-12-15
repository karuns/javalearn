package threads;

import org.testng.annotations.Test;

public class usingthread {
	@Test 
	public void implementThreadUsingThreaad() {
		System.out.println("Starting thread ...");
		Thread t = new Thread() {
			public void run () {
				System.out.println("Hello from thread...");
				for(int i = 1; i<=10;i++) {
					System.out.println("i="+Integer.toString(i));
				}
			}	
		};
		t.start();
		for(int i = 1; i<=10;i++) {
			System.out.println("j="+Integer.toString(i));
		}
		
		
		System.out.println("End of thread... ");
	}
}
