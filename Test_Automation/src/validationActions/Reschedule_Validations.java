package validationActions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.text.DecimalFormat;
import utility.ComparisonUtility;
import utility.DataValues;

public class Reschedule_Validations {
	
	public static Double principalRemaining = 0.00;
	public static Double interestRemaining = 0.00;
	public static Double interestRate = 0.00;
	public static Double interestAccuruedTillDate =0.00;
	public static Double expectedPaymentAmount = 0.00;
	public static Double actualPaymentAmount = 0.00;
	public static Double term =0.0;
	public static DecimalFormat formatter = new DecimalFormat("####0.00");

	
	public static void validatePaymentSplit(WebDriver driver) throws Exception
	{
		
		principalRemaining = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/span")).getText());
		interestRate = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[2]/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		interestRemaining = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[1]/td[2]")).getText());
		interestAccuruedTillDate =ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]")).getText());
		double temporaryVariable = ((principalRemaining+interestRemaining+interestAccuruedTillDate)/ComparisonUtility.cleanString(DataValues.rTerm));
		expectedPaymentAmount= ComparisonUtility.cleanString(formatter.format(temporaryVariable));
		actualPaymentAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[1]/td[1]")).getText());
		assertEquals("Reschedule-Payment Amount Validation : FAIL ","PASS",(ComparisonUtility.doubleValueValidate(expectedPaymentAmount,actualPaymentAmount)));
		Reporter.log("Reschedule-Payment Amount Validation : PASS");
		
		
		Thread.sleep(10000);
		int rowCount = driver.findElements(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr/td/table/tbody/tr")).size();
		assertEquals("Reschedule - Number of Payments Validation: FAIL" ,Integer.parseInt(DataValues.rTerm), rowCount);
	    Reporter.log("Reschedule- Number of Payments Validation: PASS");
	    Reporter.log("Number of Payments updated to "+rowCount );
	    
	    
	}
	
	    public static void validateInterestChange(WebDriver driver) throws Exception
	    {
	    	principalRemaining = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/span")).getText());
			interestRemaining = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[1]/td[2]")).getText());
			interestAccuruedTillDate =ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]")).getText());
			term = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[2]/td[2]")).getText());
			double temporaryVariable = ((principalRemaining+interestRemaining+interestAccuruedTillDate)/term);
			expectedPaymentAmount= ComparisonUtility.cleanString(formatter.format(temporaryVariable));
			Reporter.log("Reschedule-Payment Amount Validation : PASS");
			
			Thread.sleep(10000);
			int rowCount = driver.findElements(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr/td/table/tbody/tr")).size();
			assertEquals("Reschedule - Number of Payments Validation: FAIL" ,term, rowCount);
		    Reporter.log("Reschedule- Number of Payments Validation: PASS");
		    Reporter.log("Number of Payments updated to "+rowCount );
	    
	    }
	

}
