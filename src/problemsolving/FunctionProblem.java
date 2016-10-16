package problemsolving;

import java.util.Arrays;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Here is solution with multiplication in log n time instead of linear (n).  
public class FunctionProblem {
	
	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { {(new int[]{5,1,7})},
        						{(new int[] {15,2,3,4})},
        						{(new int[] {0,2,3,4})},
        						{(new int[] {0,0,3,4})},
        						{(new int[] {0,0,0,0})},
        						{(new int[] {-4,-3,-2,-1})},
        						{(new int[] {-5,-4,-3,-2,-1})}
        };
    }
 
	@Test(dataProvider = "data-provider")
	public void test1(int [] a ) {	
		System.out.println("input="+Arrays.toString(a)+", output="+Arrays.toString(getH(a))+"");
	}
	

	private int[] getH(int[] a) {
		int[] b = new int[a.length];
		for(int i=0; i<a.length; i++) {
			b[i] = getMultiplier(a,i);
		}
		return b;
	}

	private int getMultiplier(int[] a, int i) {
		if(i == 0) {  // boundary
			return multiply(a,1,a.length-1);
		}
		else if(i==a.length-1) { //boundary
			return multiply(a,0,a.length-2);
		}
		else {
			return multiply(a,0,i-1) * multiply(a,i+1,a.length-1);
		}
	}

	private int multiply(int[] a, int i, int j) {
		if(i < 0) {
			return 1;
		}
		else if(j > a.length-1) {
			return 1;
		}
		else if (i==j) { // leaf element
			return a[i];
		}
		else {  //recursively divide and conquer i.e. merge sort approach
			int mid = (i+j)/2;
			return multiply(a,i,mid)* multiply(a,mid+1,j);
		}		
	}
}
