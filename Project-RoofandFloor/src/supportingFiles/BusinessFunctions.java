package supportingFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BusinessFunctions extends UtilityFunctions{
	
	// Launch the Home Page
	public static boolean launchQARoofandFloor(String strURL)
	{
		boolean blnFlag = false;
		
		blnFlag = launchBrowser(strURL);
		if(blnFlag)
		{			
			blnFlag = verifyExist(strLocator,FileUtility.getOR("objSearchHeading"),20);
			if(!blnFlag)
				CustomError.description = "The Home Page is not displayed successfully. (Exception Details:"+CustomError.description+")";
		}
		else
			CustomError.description = "The Browser did not launch successfully. (Exception Details:"+CustomError.description+")";
				
		return blnFlag;		
	}
	
	// Locality Search
	public static boolean localitySearchandSelect(String strValuetoEnter, String strActualLocality)
	{		
		boolean blnFlag = false;
		
		blnFlag = closePopupifPresent();
		if(blnFlag)		
		{
			blnFlag = setText(strLocator, FileUtility.getOR("txtSearch"), strValuetoEnter);
			if(blnFlag)
			{
				blnFlag = verifyClickLocalitySearch(strActualLocality);				
			}
			else
				CustomError.description = "The Locality '"+strValuetoEnter+"' was not input successfully in the search box. (Exception Details:"+CustomError.description+")";
		}
		else
			CustomError.description = "The popup close button was not clicked successfully. (Exception Details:"+CustomError.description+")";
		
		return blnFlag;		
	}
	
	// Verify and click on Locality Searched
	public static boolean verifyClickLocalitySearch(String strValuetoEnter)
	{
		boolean blnFlag = false;
					
		List<WebElement> lsttags = driver.findElements(By.xpath(FileUtility.getOR("lstLocality")));
		int intCountSearchedResults = 	lsttags.size()-1;
		for (int i=1;i<=intCountSearchedResults;i++)
		{
			String strUISearchResult = driver.findElement(By.xpath("//ul[@class='select2-results']/li["+i+"]/div")).getText().trim();
			if(strUISearchResult.equalsIgnoreCase(strValuetoEnter.trim()))
			{
				blnFlag = Click(strLocator, "//ul[@class='select2-results']/li["+i+"]/div");
				if(!blnFlag)
					CustomError.description = "The Searched locality '"+strValuetoEnter+"' was not clicked successfully.";
				break;
			}
			else					
				blnFlag = false;
		}

		if(!blnFlag)
			CustomError.description = "The Locality '"+strValuetoEnter+"' is not displayed in the direct match list.";			
		
		return blnFlag;		
	}
	
	// Verify if Searched locality is added
	public static boolean verifySearchedLocality(String strValuetoVerify)
	{
		boolean blnFlag = false;
					
		List<WebElement> lsttags = driver.findElements(By.xpath(FileUtility.getOR("lstLocality")));
		int intCountAddedResults = 	lsttags.size()-1;
		for (int i=1;i<=intCountAddedResults;i++)
		{
			String strUIAddedResult = driver.findElement(By.xpath("//ul[@class='select2-choices']/li["+i+"]/div")).getText().trim();
			if(strUIAddedResult.equalsIgnoreCase(strValuetoVerify.trim()))
			{
				blnFlag = true;				
				break;
			}
			else					
				blnFlag = false;
		}

		if(!blnFlag)
			CustomError.description = "The Locality '"+strValuetoVerify+"' is not displayed in the Locality text box.";			
		
		return blnFlag;		
	}
	
	// Close popup if present
	public static boolean closePopupifPresent()
	{
		boolean blnFlag = false;
		
		blnFlag = verifyExist (strLocator, FileUtility.getOR("objClosePopup"), 5);
		if(blnFlag)
		{
			blnFlag = Click(strLocator, FileUtility.getOR("objClosePopup"));			
			if(!blnFlag)
				CustomError.description = "The popup was not closed successfully. (Exception Details:"+CustomError.description+")";
		}
		else
			blnFlag = true;
										
		return blnFlag;		
	}
	
	// Click on the the 'Search properties' button  and verify the search heading with the locality
	public static boolean clickSearchandVerifyHeading(String strLocalitytoVerify)
	{
		boolean blnFlag = false;
					
		blnFlag = Click(strLocator, FileUtility.getOR("btnSearchProperties"));		
		if(blnFlag)
		{
			String strResultText = driver.findElement(By.xpath(FileUtility.getOR("objSearchTextHeading"))).getText().trim();
			blnFlag = (strResultText.toLowerCase()).contains(strLocalitytoVerify.toLowerCase());
			if(!blnFlag)
				CustomError.description = "The Locality '"+strLocalitytoVerify+"' is not contained in the search result header message '"+strResultText+"'.";	
		}
		else
			CustomError.description = "The click on 'Search Properties' button was not successful. (Exception Details:"+CustomError.description+")";		
		
		return blnFlag;		
	}
	
	
}

