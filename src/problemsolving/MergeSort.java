package problemsolving;

import org.testng.annotations.Test;

public class MergeSort {
	
	@Test 
	public void mergeSort() {
		int [] a = {2,5,6,9,1,3,8,4};	
		a = mergeSort(a);
		print(a);
	}

	private void print(int[] a) {
		for(int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}	
	}

	private int[] mergeSort(int[] a) {
		if(a.length ==1) {
			return a;
		}
		else {
			int mid = (a.length-1)/2;
			return insertionSort(mergeSort(copyArray(a,0,mid)),mergeSort(copyArray(a,mid+1,a.length-1)));
		}
	}
	
	private int [] copyArray(int []a, int j, int k) {
		int []b = new int[k-j+1];
		int bIndex = -1;
		for(int i = j; i<=k; i++) {
			b[++bIndex] = a[i];
		}
		return b;
	}
	
	private int [] insertionSort(int [] a, int [] b) {
		int i =0;
		int aMax = a.length-1;
		int bMax = b.length-1;
		int j = 0;
		int k = 0;
		int [] c = new int[aMax+bMax+2] ;
		
		while(i<=aMax && j<=bMax) {
			if(a[i] < b[j]) {
				c[k++] = a[i++];
			}
			else {
				c[k++] = b[j++];
			}
		}
		
		while(i<=aMax) {
			c[k++] = a[i++];
		}
		
		while(j<=bMax) {
			c[k++] = b[j++];
		}
		
		return c;
	}
	
	
	
	
	

}
