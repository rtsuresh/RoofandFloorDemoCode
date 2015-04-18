package roofandFloorTestCases;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.firefox.FirefoxDriver;

import supportingFiles.*;


public class SearchFunctionality extends Variables{
		
	@BeforeClass 
	public static void testSuiteSetup() {
		// Initialise the variables
				
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		// Set up OR from the OR Sheet
		blnFlag = FileUtility.readOR("ORSheet.xlsx");
		if(!blnFlag)
			assertEquals(true,blnFlag);
		
		// Create Step log
		blnFlag = FileUtility.createStepLog();
		if(!blnFlag)
			assertEquals(true,blnFlag);
	} 
	 
	  
	@Before
	public void testSetUp() {
		String strMethodName = name.getMethodName();
		FileUtility.writetoLog("Running Test Case: "+strMethodName+"\n");
		
		// Set up test data from datasheet
		boolean blnFlag = FileUtility.readData("TestData.xlsx", strMethodName);
		if(!blnFlag)
			assertEquals(true,blnFlag);
		
		// Reset step counter
		Stepnumber = 1;
		
	}
	
	@Rule 
	public TestName name = new TestName();
	
	@Test
	public void LocalitySearchExactMatch() {
		
		String strURL = "https://qa.roofandfloor.com/";
		// Test data used in script
		String strValuetoEnter = FileUtility.getTestData("strValuetoEnter");
		String strActualLocality = FileUtility.getTestData("strActualLocality");
				
		// *************************Launch Browser***********************************
		strStepDescription = "Launch the Browser URL and verify launched browser.";
		strExpectedResult = "The Browser should be launched successfully.";
		strActualResult = "The Browser is launched successfully.";
		blnFlag = BusinessFunctions.launchBrowser(strURL);
		Report.Print();
		
		// *************************Search with Locality***********************************
		strStepDescription = "Search for the Locality and click on the searched Locality.";
		strExpectedResult = "The searched Locality should be clicked successfully.";
		strActualResult = "The searched Locality is clicked successfully.";
		blnFlag = BusinessFunctions.localitySearchandSelect(strValuetoEnter,strActualLocality);
		Report.Print();
		
		// *************************Verify searched Locality***********************************
		strStepDescription = "Verify if the searched locality is added in the Locality box.";
		strExpectedResult = "The searched Locality should be added successfully.";
		strActualResult = "The searched Locality is added successfully.";
		blnFlag = BusinessFunctions.verifySearchedLocality(strActualLocality);
		Report.Print();
		
		// ***Click on 'Search Properties' and Verify searched Locality displayed in results**************
		strStepDescription = "Click on 'Search Properties' and Verify search result heading.";
		strExpectedResult = "'Search Properties' should be clicked and the search result heading should be verified.";
		strActualResult = "'Search Properties' is clicked and the search result heading is verified.";
		blnFlag = BusinessFunctions.clickSearchandVerifyHeading(strActualLocality);
		Report.Print();
		
	}
	
	@Test
	public void LocalitySearchPartialMatch() {
		// Data used in Script
		String strURL = "https://qa.roofandfloor.com/";
		String strValuetoEnter = FileUtility.getTestData("strValuetoEnter");
		String strActualLocality = FileUtility.getTestData("strActualLocality");
					
		// *************************Launch Browser***********************************
		strStepDescription = "Launch the Browser URL and verify launched browser.";
		strExpectedResult = "The Browser should be launched successfully.";
		strActualResult = "The Browser is launched successfully.";
		blnFlag = BusinessFunctions.launchBrowser(strURL);
		Report.Print();
		
		// *************************Search with Locality***********************************
		strStepDescription = "Search for the Locality and click on the searched Locality.";
		strExpectedResult = "The searched Locality should be clicked successfully.";
		strActualResult = "The searched Locality is clicked successfully.";
		blnFlag = BusinessFunctions.localitySearchandSelect(strValuetoEnter,strActualLocality);
		Report.Print();
		
		// *************************Verify searched Locality***********************************
		strStepDescription = "Verify if the searched locality is added in the Locality box.";
		strExpectedResult = "The searched Locality should be added successfully.";
		strActualResult = "The searched Locality is added successfully.";
		blnFlag = BusinessFunctions.verifySearchedLocality(strActualLocality);
		Report.Print();
		
		// ***Click on 'Search Properties' and Verify searched Locality displayed in results**************
		strStepDescription = "Click on 'Search Properties' and Verify search result heading.";
		strExpectedResult = "'Search Properties' should be clicked and the search result heading should be verified.";
		strActualResult = "'Search Properties' is clicked and the search result heading is verified.";
		blnFlag = BusinessFunctions.clickSearchandVerifyHeading(strActualLocality);
		Report.Print();
	}
	
	@After
	public void testTearDown() {
			
	}
	
	@AfterClass 
	public static void testSuiteTearDown() {
		// Quit driver instance
		driver.quit();	
		// Clean up
		FileUtility.tearDown();
	}

}


	
	
	





