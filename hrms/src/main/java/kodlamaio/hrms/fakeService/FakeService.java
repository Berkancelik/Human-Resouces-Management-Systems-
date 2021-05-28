package kodlamaio.hrms.fakeService;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakeService {
	public static boolean mernisCheck(String nationalityNumber) {
		
		String regex = "^[1-9]{1}[0-9]{9}[02468]{1}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nationalityNumber);
		 
		if(nationalityNumber.length()==11) {
			return true;
		}
		else if (matcher.matches() && !nationalityNumber.startsWith("0")) {
			return true;
		}
		else {
			return false;
		}
	}

}
