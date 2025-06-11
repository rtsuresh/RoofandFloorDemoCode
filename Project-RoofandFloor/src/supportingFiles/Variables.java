package supportingFiles;

import org.openqa.selenium.WebDriver;

public class Variables {
			// Timeout- Generic (in seconds)
		public static final int intTimeOut = 10;
		public static final String strLocator = "XPATH";
		public static final String POSTMAN_API_KEY = "PMAK-6849080a9c59fa00011e1440-0d810ba0c39206cb7213487ef192b026c1";
		
		// Variables used in Script
		public static WebDriver driver;
		public static class CustomError{
			public static String description = "";
		}
		public static String strStepDescription;
		public static String strActualResult;
		public static String strExpectedResult;
		public static boolean blnFlag ;
		public static StringBuffer verificationErrors = new StringBuffer();
		public static int Stepnumber= 1;
}
