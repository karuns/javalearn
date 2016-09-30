package problemsolving;

import org.testng.annotations.Test;

public class LocalMaximas {
	
	
	@Test
	public void test () {
		System.out.println("maximas: please modify code to handle if array size is <= 2");
		
		int []a = {5,8,10,25,6,3,44,51,55,56,57,58,34,5,59,2};
		localMaximas(a);
		
		int []b = {9,7,2,8,5,6,3,4, 2}; //9,8,6,4
		localMaximas(b);
		
		int [] c= {15, 13, 12, 18, 19, 20, 7, 6, 5, 4, 3, 2, 1};//15,20
		localMaximas(c);
	}
	
	public  void localMaximas (int [] a) {
		System.out.println("\n\n");
		if(isMaxima(a,0)) {
			System.out.println(a[0]);
		}
		if(isMaxima(a,a.length-1)) {
			System.out.println(a[a.length-1]);
		}
		localMaximas(a,0,a.length-1);
	}
	
	int localMaximas(int []a,int low, int high) {
		int mid = (low+high)/2;
		if(high-low > 3) {     // more than 4 items in currently  divided array
			if(isMaxima(a,mid)) {
				System.out.println(a[mid]);
			}	
			localMaximas(a,low, mid);
			localMaximas(a,mid, high);
		}
		else if(high-low == 3){ //exactly 4 items in currently  divided array
			localMaximas(a,low, mid+1);
			localMaximas(a,mid, high);
		}	
		else if((high-low == 2) && (isMaxima(a,low+1))) {
			System.out.println(a[low+1]);
		}
		return 0;

	}
	
	int maxof(int []a, int i, int j) {
		if(a[i] <a[j]) {
			return j;
		}
		else {
			return i;
		}
	}
	
	boolean isMaxima(int []a ,int mid) {
		if(mid == 0) {
			if(maxof(a, mid, mid+1) == mid) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(mid==a.length-1) {
			if(maxof(a,mid,mid-1) == mid) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if((maxof(a, mid, mid+1) == mid) && (maxof(a, mid, mid-1) == mid)) {
				return true;
			}
			else {
				return false;
			}
			
		}
	}

}
