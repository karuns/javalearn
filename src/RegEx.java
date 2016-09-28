import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegEx {
	
	@Test
	public void regexFirst() {
		String line = "This order was placed for QT3000! OK?";
	    String pattern = "(.*)(\\d+)(.*)";
	    Matcher m = Pattern.compile(pattern).matcher(line);
	    m.find();
	    System.out.println(m.group(0));
	    System.out.println(m.group(1));
	    System.out.println(m.group(2)); 
	}
	
//	@Test
//	public void regexFirst2() {
//		String line = "mkyong-100@yahoo.com";
//		//String regex = "(?i)\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b";
//	    Matcher m = Pattern.compile(pattern).matcher(line);
//	    m.find();
//	    System.out.println(m.group(1));
//	}
}
