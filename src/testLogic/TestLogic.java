package testLogic;

import org.testng.annotations.Test;

public class TestLogic {
	@Test 
	public void convertStringToMac() {
//		System.out.println("Starting conversion ...");
//		System.out.println(convertToMac("00155D233800",-1));
//		System.out.println("End of thread... ");
		
		System.out.println(base8Generator(100));
		base8Generator2(100);
		
	}
	
	/* input:  00155D233800
	 * output: 00:15:5D:23:38:00
	 */
	public String convertToMac (String strText, int i) {
		i=i+3;
		strText = strText.substring(0, i)+":"+strText.substring(i);
		if(i<strText.length()-3) {
			strText = convertToMac(strText,i);
		}
		return strText;
	}
	
	public static String base8Generator(int n) {
		if (n == 1) {
			return "00";
		}
		else {
			return Integer.toString((n-1) / 8)+Integer.toString((n-1) % 8);
		}
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
	
}
