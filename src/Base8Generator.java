import org.testng.annotations.Test;



public class Base8Generator {
	@Test
	public static void generator() {
		base8Generator2(127);
	}
	
	
	public static void base8Generator2(int n) {
		System.out.println(n);
		String strTemp = "";
		
		int i = -1;
		int count= 0;

		while(count<=n) {
			i++;
			if((i%10 != 8) && (i%10 != 9)) {
				count++;
				if(i<10) {
					strTemp = "0"+Integer.toString(i);	
				}
				else {
					strTemp = Integer.toString(i);	
				}
				System.out.println(strTemp+"\n") ;
			}
		}
	}
	
	public static void base8Generator(int n) {
		System.out.println(n);
		
		int i = 1;
		boolean finished = false;
		while(!finished) {
			for (int j = 0; j<=9 && !finished ; j++) {
				for (int k = 0; k<8 && !finished ; k++) {
					if(i<=n) {
						System.out.println(Integer.toString(j)+Integer.toString(k)+"\n") ;
						i++;
					}
					else {
						finished = true;
					}
				}
			}
			
		}
	}
}
