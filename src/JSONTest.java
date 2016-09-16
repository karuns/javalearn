import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class JSONTest {
	@Test
	public void test() {
		String jstring = "[{cpu:2,ram:4,name:a},{cpu:2,ram:4,name:b}]";
		JSONArray input = new JSONArray(jstring);
		System.out.println(input.toString());
		
		System.out.println(input.getJSONObject(0).getString("name"));
		System.out.println(input.getJSONObject(1).getString("name"));
		
		
	}
	
}
