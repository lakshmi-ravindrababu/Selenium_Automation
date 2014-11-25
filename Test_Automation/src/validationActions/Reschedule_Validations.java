package validationActions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utility.ComparisonUtility;
import utility.DataValues;

public class Reschedule_Validations {
	
	public static Double principalRemaining = 0.00;
	public static Double interestRemaining = 0.00;
	public static Double interestRate = 0.00;
	public static Double expectedPaymentAmount = 0.00;
	public static Double actualPaymentAmount = 0.00;

	
	public static void validatePaymentSplit(WebDriver driver) throws Exception
	{
		
		principalRemaining = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/span")).getText());
		System.out.println(principalRemaining);
		interestRate = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[2]/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[2]/td[1]/input")).getText());
		System.out.println("PRIN_REM "+principalRemaining);
		interestRemaining = (((principalRemaining*(interestRate/100))/360)*(ComparisonUtility.cleanString(DataValues.rTerm)*30));
		System.out.println("INT_REM "+interestRemaining);
		expectedPaymentAmount = ((principalRemaining+interestRemaining)/ComparisonUtility.cleanString(DataValues.rTerm));
		System.out.println("EXP_PAY "+expectedPaymentAmount);
		actualPaymentAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[1]/td[1]")).getText());
		System.out.println("ACT_PAY "+actualPaymentAmount);
		assertEquals("Reschedule-Payment Amount Validation : FAIL ","PASS",(ComparisonUtility.doubleValueValidate(expectedPaymentAmount,actualPaymentAmount)));
		Reporter.log("Reschedule-Payment Amount Validation : PASS");
		System.out.println("Reschedule-Payment Amount Validation : PASS");
		int rowCount = driver.findElements(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr/td/table/tr")).size();
		System.out.println("PAY_NUM "+rowCount);
		assertEquals("Reschedule - Number of Payments Validation: FAIL" ,Integer.parseInt(DataValues.rTerm), rowCount);
	    Reporter.log("Reschedule- Number of Payments Validation: PASS");
	    System.out.println("Reschedule- Number of Payments Validation: PASS");
	    
	}
	

}
