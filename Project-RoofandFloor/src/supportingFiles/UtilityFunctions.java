package supportingFiles;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UtilityFunctions extends Variables{
	
	
	
	// Launch the browser
	public static boolean launchBrowser(String strURL)
	{
		boolean blnFlag = false;
		try
		{
			driver.get(strURL);
			driver.manage().window().maximize();
			blnFlag = true;
		}
		catch(Exception e)
		{
			CustomError.description = e.toString()+":"+e.getMessage();
		}
		return blnFlag;		
	}
	
	// Click
	public static boolean Click(String strLocator, String strValue)
	{
		boolean blnFlag = false;
		try
		{
			
			UIControl(strLocator,strValue).click();
			blnFlag = true;
		}
		catch(Exception e)
		{
			CustomError.description = e.toString()+":"+e.getMessage();
		}
		return blnFlag;		
	}
	
	// Verify Element clickable with TimeOut
	public static boolean verifyExist(String strLocator, String strValue, int TimeOut)
	{
		boolean blnFlag = false;
		try
		{
			new WebDriverWait(driver, TimeOut).until(ExpectedConditions.elementToBeClickable(UIControl(strLocator,strValue)));			
			blnFlag = true;				
		}
		catch(Exception e)
		{
			blnFlag = false;
			CustomError.description = e.toString()+":"+e.getMessage();
		}
		return blnFlag;		
	}
	
	// Set the text 
	public static boolean setText(String strLocator, String strValue, String strValuetoEnter)
	{
		boolean blnFlag = false;
		try
		{			
			UIControl(strLocator,strValue).clear();
			UIControl(strLocator,strValue).sendKeys(strValuetoEnter);
			blnFlag = true;
		}
		catch(Exception e)
		{
			CustomError.description = e.toString()+":"+e.getMessage();
		}
		return blnFlag;		
	}
	
	// Verify the exact text present in the element 
	public static boolean verifyExactText(String strLocator, String strValue, String strValuetoVerify)
	{
		boolean blnFlag = false;
		try
		{				
			String strUIText = UIControl(strLocator,strValue).getText().trim();
			blnFlag = strUIText.equalsIgnoreCase(strValuetoVerify.trim());
			if(!blnFlag)
				CustomError.description = "The UI Text ("+strUIText+") does not match the text ("+strValuetoVerify+").";
		}
		catch(Exception e)
		{
			CustomError.description = e.toString()+":"+e.getMessage();
		}
		return blnFlag;		
	}
	
	// Verify the text present in the element 
		public static boolean verifyTextContains(String strLocator, String strValue, String strValuetoVerify)
		{
			boolean blnFlag = false;
			try
			{				
				String strUIText = UIControl(strLocator,strValue).getText().trim();
				blnFlag = strUIText.contains(strValuetoVerify.trim());
				if(!blnFlag)
					CustomError.description = "The text ("+strValuetoVerify+") is not contained in the UI element's text ("+strUIText+").";
			}
			catch(Exception e)
			{
				CustomError.description = e.toString()+":"+e.getMessage();
			}
			return blnFlag;		
		}
	
	
	public static WebElement UIControl(String strLocator, String strValue) throws Exception
	{
		WebElement objUIControl = null ; 
		 switch(strLocator) {
		    case "ID":
		    	objUIControl = new WebDriverWait(driver, intTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.id(strValue)));
		    	break;
		    case "CLASSNAME":
		    	objUIControl = new WebDriverWait(driver, intTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.className(strValue)));
		    	break;
		    case "XPATH":
		    	objUIControl = new WebDriverWait(driver, intTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.xpath(strValue)));
		    	break;
		    case "CSS":
		    	objUIControl = new WebDriverWait(driver, intTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(strValue)));
		    	break;
		    case "LINK":
		    	objUIControl = new WebDriverWait(driver, intTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.linkText(strValue)));
		    	break;
		    case "PARTIALLINK":
		    	objUIControl = new WebDriverWait(driver, intTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(strValue)));
		    	break;
		    case "NAME":
		    	objUIControl = new WebDriverWait(driver, intTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.name(strValue)));
		    	break;
		    case "TAGNAME":
		    	objUIControl = new WebDriverWait(driver, intTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.tagName(strValue)));
		    	break;
		    }
		 
		 return objUIControl;
	}
	
	
	

}

