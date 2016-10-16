package problemsolving;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class WordPlay {
//	String [][] inArray = {
//			{"","","","","","","",""},
//			{"","a","b","c","","","",""},
//			{"","","","d","","","",""},
//			{"","","","e","","","",""},
//			{"","","","f","","","",""},
//			{"","","","g","h","","",""},
//			{"","","","","","","",""},
//			{"","","","","","","",""}
//	};
	
	String [][] inArray = {
			{"","","","","","","",""},
			{"","a","b","c","d","","",""},
			{"","","","d","e","f","",""},
			{"","","","e","","","",""},
			{"","","","f","","","",""},
			{"","","","g","h","","",""},
			{"","","","","","","",""},
			{"","","","","","","",""}
	};
	
//	String [][] inArray = {
//			{"","","","","","","",""},
//			{"","a","b","c","","","",""},
//			{"","","","d","","","",""},
//			{"","","","e","","","",""},
//			{"","","","f","","","",""},
//			{"","","","g","h","","",""},
//			{"","","","","","","",""},
//			{"","","","","","","",""}
//	};
	
	int row = 8;
	int column = 8;
	
	@Test
	public void test() {
		wordplay("abcdef");
	}

	private void wordplay(String string) {
		String c = Character.toString(string.charAt(0));
		for(int i=0;i<row;i++) {
			for(int j=0;j<row;j++) {
				if(c.contentEquals(inArray[i][j])){
					if(match(string.substring(1),i,j)){
						print(i,j);
					}
				}
			}
		}	
	}

	private Boolean match(String substring, int i, int j) {
		if (substring.isEmpty()) {
			print(i,j);
			return true;
		}
		else {
			JSONArray validNeighbours = new JSONArray();
			validNeighbours = getAllValidNeighbors(Character.toString(substring.charAt(0)),i,j);
			//System.out.println(validNeighbours.toString());
			if(validNeighbours.length()==0) {
				return false;
			}
			else {
				for(int it = 0; it<validNeighbours.length(); it++) {
					Integer newi = validNeighbours.getJSONObject(it).getInt("i");
					Integer newj = validNeighbours.getJSONObject(it).getInt("j");
					Boolean val = match(substring.substring(1),newi,newj);
					
					if(val) {
						print(newi,newj);
						return true;
					}
					else{
						return false;
						
					}
				}
				return false;
			}
			
		}
		
	}

	private JSONArray getAllValidNeighbors(String string,
			int i, int j) {
		JSONArray ja = new JSONArray();
		
		
		if(i >= 1 && i <=row-2) {
			if(inArray[i-1][j].contentEquals(string)) {
				JSONObject tempObj = new JSONObject();
				tempObj.put("i", i-1);
				tempObj.put("j", j);
				ja.put(tempObj);
			}
			if(inArray[i+1][j].contentEquals(string)) {
				JSONObject tempObj = new JSONObject();
				tempObj.put("i", i+1);
				tempObj.put("j", j);
				ja.put(tempObj);
			}
		}
		else if(i==0) {
			if(inArray[i+1][j].contentEquals(string)) {
				JSONObject tempObj = new JSONObject();
				tempObj.put("i", i+1);
				tempObj.put("j", j);
				ja.put(tempObj);
			}
		}
		else if(i==row-1) {
			if(inArray[i-1][j].contentEquals(string)) {
				JSONObject tempObj = new JSONObject();
				tempObj.put("i", i-1);
				tempObj.put("j", j);
				ja.put(tempObj);
			}
		}
		
		
		if(j >= 1 && j <=column-2) {
			if(inArray[i][j-1].contentEquals(string)) {
				JSONObject tempObj = new JSONObject();
				tempObj.put("i", i);
				tempObj.put("j", j-1);
				ja.put(tempObj);
			}
			if(inArray[i][j+1].contentEquals(string)) {
				JSONObject tempObj = new JSONObject();
				tempObj.put("i", i);
				tempObj.put("j", j+1);
				ja.put(tempObj);
			}
		}
		else if(j==0) {
			if(inArray[i][j+1].contentEquals(string)) {
				JSONObject tempObj = new JSONObject();
				tempObj.put("i", i);
				tempObj.put("j", j+1);
				ja.put(tempObj);
			}
		}
		else if(j==row-1) {
			if(inArray[i][j-1].contentEquals(string)) {
				JSONObject tempObj = new JSONObject();
				tempObj.put("i", i);
				tempObj.put("j", j-1);
				ja.put(tempObj);
			}
		}
		return ja;
	}

	private void print(int i, int j) {
		System.out.println("["+i+","+j+"]");	
	}
}
