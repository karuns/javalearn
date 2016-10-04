// Heap sort implementation
/* first heapify whole array
 * 	i <- N/2 to 1
 * 		maxheap (i, N)
 * now continue with 1 -> N  array
 * 	Swap (1, N)
 *  reduce array size to  N-1
 *  Max heap (1, N-1)
 * 	
 * 
 */
package problemsolving;

import org.testng.annotations.Test;

public class Heapsort {
	
	Integer [] a = {101, 29,21,23,5,12,7,3,9,45,6};
	
	@Test 
	public  void testHeapSort() {
		HeapSort();
		print();
	}

	private void print() {
		for(int i = 0 ; i < a.length ; i++) {
			System.out.println(a[i]);
		}
	}

	private void HeapSort() {
		Heapify();
		for(int i = a.length-1; i>0; i--) {
			swap(0,i);
			maxHeap(0,i-1);
		}
	}

	private void Heapify() {
		for(int i = (a.length-1)/2; i>=0; i--) {
			maxHeap(i,a.length-1);
		}
	}
	
	private void maxHeap(int i, int j) {
		int max = i;
		int left = 2*i;
		int right = 2*i+1;
		
		if((left <=j) &&(a[left] > a[max])){
			max = left;
		}
		if((right <=j) &&(a[right] > a[max])){
			max = right;
		}
		
		if(max != i) {
			swap(max, i);
			maxHeap(max,j);
		}
	}

	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
