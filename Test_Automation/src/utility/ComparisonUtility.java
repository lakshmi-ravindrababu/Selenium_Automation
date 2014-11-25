package utility;

import java.text.NumberFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ComparisonUtility {
	
	static Boolean testResult = true;
	static String bodyText = null;
	static String inputValue = null;
	static double dBodyTextValue = 0.00;
	static double dInputValue = 0.00;
	

	/*This function cleans the string of special characters like "," and converts the (String)amount to Double value*/
	public static double cleanString(String value) throws Exception
	{
			NumberFormat number = NumberFormat.getInstance();
			Double numberValue = number.parse(value).doubleValue();
			return numberValue;
		
	}

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
	public static String outputValueValidate(WebDriver driver,String path,String value) throws Exception{
		
		
		bodyText = driver.findElement(By.xpath(path)).getAttribute("innerHTML");
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
		
		dBodyTextValue = cleanString(driver.findElement(By.xpath(path)).getText());
		dInputValue = cleanString(value);
		if(dBodyTextValue == dInputValue){
			
			  return "PASS";
		}
		else
		{
			  return "FAIL";
		}

	}
	
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
	
}
