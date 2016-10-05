package problemsolving;

import java.util.Arrays;

import org.testng.annotations.Test;

public class QuickSort {
	
	int []a = {1,8,3,7,2,7,4,0,5,6};
	@Test 
	public void quickTest() {
		
		quickSort(0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

	private void quickSort(int low, int max) {
		if(low<max) {
			int pivot = partition(low,max);
			quickSort(low, pivot-1);
			quickSort(pivot+1, max);
		}
	}

	private int partition(int low, int max) {
		int pivot = a[max];
		int i = low;
		int j = max-1;
		
		while(i<j) {
			while(a[i]<pivot && i<max) {i++;}
			while(a[j]>pivot && j>low) {j--;}
			if(i<j) {
				swap(i,j);
			}
		}
		swap(i,max);
		return i;
	}

	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}

}
