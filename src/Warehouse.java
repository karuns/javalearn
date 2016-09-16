import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;


public class Warehouse {
	
//	@Test
//	public void test () throws IOException {
//		// Directory path here
//		if(applicationExist("warehouse.corp.airwave.com/build/AMP-8.2.20160203-x86_64.iso")) {
//			System.out.println("exist");
//		}
//		else {
//			System.out.println("does notexist");
//		}
//		
//	}
	
	boolean isBuildAvailable(String build) {
		try {
			return (new URL("http://"+build)).openConnection().getContentType().contains("application");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
