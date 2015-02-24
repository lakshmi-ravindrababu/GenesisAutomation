package utility;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ComparisonUtility {
	
	static Boolean testResult = true;
	static String bodyText = null;
	static String inputValue = null;
	static double dBodyTextValue = 0.00;
	static double dInputValue = 0.00;
	
	/*This functions checks whether a given substring is present in a String*/
	public static String textValidator(WebDriver driver,String path,String text){
		 
		
		bodyText = driver.findElement(By.xpath(path)).getAttribute("innerHTML");
			if(bodyText.contains(text))
			{
			   return "PASS";
			}
			else
			{
			   return "FAIL";
			}
	
	}
	
	/*This method validates that two given values are equal*/
	public static String outputValueValidate(WebDriver driver,String path,String value,String Attribute) throws Exception{
		
		
		bodyText = driver.findElement(By.xpath(path)).getAttribute(Attribute);
		inputValue = value;
		if(bodyText.equals(inputValue)){
			
			 return "PASS";
		}
		else
		{
		     return "FAIL";
		}

	}
	
	/*This method validates that two given values are equal after conversion to double*/
	public static String outputValueValidate_AfterConvertion(WebDriver driver,String path,String value) throws Exception{
		
		dBodyTextValue = SystemUtility.cleanString(driver.findElement(By.xpath(path)).getText());
		dInputValue = SystemUtility.cleanString(value);
		if(dBodyTextValue == dInputValue){
			
			  return "PASS";
		}
		else
		{
			  return "FAIL";
		}

	}
	
	/*This method validates whether the two double values are equal*/
	public static String doubleValueValidate(double value1,double value2)
	{
		if(Double.compare(value1,value2)==0)
		{
			return "PASS";
		}
		else
		{
			return "FAIL";
		}
				
	}
	
	/*This method validates whether the two integer values are equal*/
	public static String integerValueValidate(int value1,int value2)
	{
		if(value1==value2)
		{
			return "PASS";
		}
		else
		{
			return "FAIL";
		}
				
	}
	
	/*This method validates whether the two String values are equal*/
	public static String compareValues(String value1,String value2)
	{
		if(value1.equals(value2))
		{
			return "PASS";
		}
		else
		{
			return "FAIL";
		}
	}

}
