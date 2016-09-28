package problemsolving;

import org.testng.annotations.Test;

public class LocalMaxima {
	int []a = {5,8,10,25,6,3,44,51,55,56,57,58,34,5,59};
	
	@Test 
	public  void localMaxima () {
		System.out.println((a[localMaxima(0,a.length-1)]));
	}
	
	int localMaxima(int low, int high) {
		if(high-low > 2) {
			int mid = (low+high)/2;
			return maxof(localMaxima(low,mid),localMaxima(mid+1, high));
		}
		else if(high-low == 1) {
			return maxof(high,low);
		}
		else if(high-low == 0) {
			return high;
		}
		if(high-low == 2) {
			return maxof(maxof(low, high),low+1);
		}
		return 0;
	}
	
	int maxof(int i, int j) {
		if(a[i] <a[j]) {
			return j;
		}
		else {
			return i;
		}
	}
}
