package threads;

import org.testng.annotations.Test;

public class UsingRunnable {
	@Test 
	public void implementThreadUsingRunnable() {
		System.out.println("Starting thread ...");
		Thread t = new Thread( new Loader());
		t.start();
		
		for(int i = 1; i<=10;i++) {
			System.out.println("j="+Integer.toString(i));
		}
		
		System.out.println("End of thread... ");
	}
	
	public class Loader implements Runnable {
		@Override
		public void run () {
				System.out.println("Hello from thread...");
				for(int i = 1; i<=10;i++) {
					System.out.println("i="+Integer.toString(i));
				}
		}	
	}
}
