package problemsolving;

import java.util.Arrays;

import org.testng.annotations.Test;

/*
 * Algorithm idea: if there were only kk houses, how much money could the robber make?  Calculate this for k=1,2,3,...nk=1,2,3,...n (in that order) - this calculation will be fast, 
 * since each step only requires a small amount of work.
 * Let M(k)M(k) be the amount of money at the kkth house, and P(k)P(k) be the maximum amount of money he can make if we consider only the first kk houses.  Then we have:

P(0)=0P(0)=0
P(1)=M(1)P(1)=M(1)
P(k)=max(P(k−2)+M(k),P(k−1))P(k)=max(P(k−2)+M(k),P(k−1)) (first case=rob the kkth house, and some combination of the first k−2k−2, 
second case=don't rob kkth house, and rob some combination of the first k−1k−1).  Keep track of these decisions.
 */

public class HouseRobbers {
	int [] in = {1,89,3,5,7,9,2,4,7};
	int [] out = new int[in.length];
	
	@Test
	public void getMaxN() {
		identifyHouses();
		System.out.println(Arrays.toString(out));
	}

	private void identifyHouses() {
		System.out.println("MAx amount robber wouyld get is = "+Integer.toString(shouldWeRobThisHouse(8)));
	}

	private int shouldWeRobThisHouse(int i) {
		if(i < 0) {
			return 0;
		}
		else if(i == 0) {
			addHouse(i);
			return in[i];
		}
		else {
			int current = shouldWeRobThisHouse(i-2)+in[i];
			int next = shouldWeRobThisHouse(i-1);
			
			int leftRight = maxof(current,next);  
			if(leftRight ==1) {
				//addHouse(i-1);
				//removeHouse(i-2);
				//removeHouse(i);
				return next;
			}
			else {
				addHouse(i);
				//addHouse(i-2);
				//removeHouse(i-1);
				return current;
			}
		}
	}

	private void addHouse(int i) {
		if((i>=0) && (i<in.length)) {
			out[i] = in[i];
		}
	}
	
	private void removeHouse(int i) {
		if((i>=0) && (i<in.length)) {
			out[i] = 0;
		}
	}

	private int maxof(int i, int j) {
		if(i<j) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
