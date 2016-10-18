package problemsolving;

import org.testng.annotations.Test;
public class Gcd_Lcm {
	@Test
	public void gcd() {
		System.out.println(getGcd(12,8));
		System.out.println(getGcd(8,12));
		System.out.println(getLcm(8,12));
		System.out.println(getLcm(8,12));
	}
	
	private int getLcm(int i,int j) {
		return (i*j)/getGcd(i, j) ;
	}
	
	private int getGcd(int i, int j) {
		if(j==0) {
			return i;
		}
		else {
			return getGcd(j, i %j);
		}
	}
}
