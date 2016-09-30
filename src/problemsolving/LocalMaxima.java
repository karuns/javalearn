package problemsolving;

import org.testng.annotations.Test;

public class LocalMaxima {
	int []a = {5,8,10,25,6,3,44,51,55,56,57,58,34,5,59,2};
	
	@Test 
	public  void localMaxima () {
		System.out.println((a[localMaxima(0,a.length-1)]));
		
		System.out.println("maximas");
		if(isMaxima(0)) {
			System.out.println(a[0]);
		}
		if(isMaxima(a.length-1)) {
			System.out.println(a[a.length-1]);
		}
		localMaximas(0,a.length-1);
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
	
	
	int localMaximas(int low, int high) {
		int mid = (low+high)/2;
		if(high-low > 3) {     // more than 4 items in currently  divided array
			if(isMaxima(mid)) {
				System.out.println(a[mid]);
			}	
			localMaximas(low, mid);
			localMaximas(mid, high);
		}
		else if(high-low == 3){ //exactly 4 items in currently  divided array
			localMaximas(low, mid+1);
			localMaximas(mid, high);
		}	
		else if((high-low == 2) && (isMaxima(low+1))) {
			System.out.println(a[low+1]);
		}
		return 0;

	}
	
	
	boolean isMaxima(int mid) {
		if(mid == 0) {
			if(maxof(mid, mid+1) == mid) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(mid==a.length-1) {
			if(maxof(mid,mid-1) == mid) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if((maxof(mid, mid+1) == mid) && (maxof(mid, mid-1) == mid)) {
				return true;
			}
			else {
				return false;
			}
			
		}
	}
	
	public void printIfMaxima(int i) {
		System.out.println(a[i]);
		
	}

}
