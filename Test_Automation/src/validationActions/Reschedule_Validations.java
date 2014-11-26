package validationActions;


import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.text.DecimalFormat;
import utility.*;

public class Reschedule_Validations {
	
	public static String result = null;
	public static boolean expectedTestResult = true;
	public static boolean actualTestResult = true;
	public static DecimalFormat formatter = new DecimalFormat("####0.00");
	
	public static void updateTestResult(String value)
	{
		if(value.equals("FAIL"))
		{
			actualTestResult = false;
		}
		result =null;
	}
	

	public static void validatePaymentSplit(WebDriver driver) throws Exception
	{
		RescheduleValidationUtility.getValidationData(driver);
		result=RescheduleValidationUtility.checkPaymentAmount(ComparisonUtility.cleanString(DataValues.rTerm));
		Reporter.log("Reschedule-Payment Amount Validation : "+result);
		updateTestResult(result);
			
		result=RescheduleValidationUtility.checkNumberOfPayments(Integer.parseInt(DataValues.rTerm));
		Reporter.log("Reschedule- Number of Payments Validation: " + result);
		updateTestResult(result);
		
		result=RescheduleValidationUtility.checkStartDate((driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[2]/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/div/span/input")).getAttribute("value")));
		Reporter.log("Reschedule Start Date Validation : "+result);
		updateTestResult(result);
		
		assertEquals("Term Change Preview Validation Failure",expectedTestResult,actualTestResult);
	    
	}
	
	public static void validateInterestChange(WebDriver driver) throws Exception
	{
	    	
	    	
	    RescheduleValidationUtility.getValidationData(driver);
		result=RescheduleValidationUtility.checkPaymentAmount(ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[2]/td[2]")).getText()));
		Reporter.log("Reschedule-Payment Amount Validation : "+result);
		updateTestResult(result);
				
		result=RescheduleValidationUtility.checkNumberOfPayments(Integer.parseInt(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[2]/td[2]")).getText()));
		Reporter.log("Reschedule- Number of Payments Validation: " + result);
		updateTestResult(result);
			
		result=RescheduleValidationUtility.checkStartDate((driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[2]/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/div/span/input")).getAttribute("value")));
		Reporter.log("Reschedule Start Date Validation : "+result);
		updateTestResult(result);
			
		assertEquals("Interest Change Preview Validation Failure",expectedTestResult,actualTestResult);
			
	}
	
	    
	public static void validateDateChange(WebDriver driver) throws Exception
	{
	    	
	    RescheduleValidationUtility.getValidationData(driver);
		result=RescheduleValidationUtility.checkPaymentAmount(ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[2]/td[2]")).getText()));
		Reporter.log("Reschedule-Payment Amount Validation : "+result);
		updateTestResult(result);
				
		result=RescheduleValidationUtility.checkNumberOfPayments(Integer.parseInt(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[2]/td[2]")).getText()));
		Reporter.log("Reschedule- Number of Payments Validation: " + result);
		updateTestResult(result);
			
		result=RescheduleValidationUtility.checkStartDate(DataValues.rDate);
		Reporter.log("Reschedule Start Date Validation : "+result);
		updateTestResult(result);
		assertEquals("Date Change Preview Validation Failure",expectedTestResult,actualTestResult);
		
    }
	    
	public static void checkRepaymentSchedule(WebDriver driver) throws Exception
	{
	    	
	    int size = 0;
	    result = ComparisonUtility.outputValueValidate(driver, "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[4]/table/tbody/tr/td/div[1]/div[1]/div/form/div[2]/table/tbody/tr[2]/td[5]/img", "Checked", "alt");
	    Reporter.log("Update to New Repayment Schedule Validation : "+result);
	    updateTestResult(result);
	    	    	
	    size = driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[4]/table/tbody/tr/td/div[1]/div[1]/div/form/div[2]/table/tbody/tr")).size();
	    for(int i=2;i<=size;i++)
	    	{
	    		result = ComparisonUtility.outputValueValidate(driver, "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[4]/table/tbody/tr/td/div[1]/div[1]/div/form/div[2]/table/tbody/tr["+i+"]/td[5]/img", "Not Checked", "alt");
	    		Reporter.log("Uncheck old Repayment Schedules Validation : "+result);
	    		updateTestResult(result);			    	
	    	}
	    	
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
	    assertEquals("Repayment Schedule Update Validation Failure",expectedTestResult,actualTestResult);
	    	
	}
	    
	public static void validateOtherTransaction(WebDriver driver) throws Exception
	{
	    	
	    int size=0;
	        	
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[16]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
	    Thread.sleep(3000);
	    size = driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[8]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr")).size();
	    Thread.sleep(3000);
	    result = ComparisonUtility.outputValueValidate(driver, "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[8]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr["+size+"]/td[2]", "Reschedule", "innerHTML");
	    Reporter.log("Other Transactions Tab Validation : "+result);
	    updateTestResult(result);
	    	
	    assertEquals("Other Transaction Tab Update Validation Failure",expectedTestResult,actualTestResult);
    }
	    
	    
    public static void loanDetailsValidation(WebDriver driver) throws Exception
    {
	    	
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
	    Thread.sleep(3000);
	    result = ComparisonUtility.outputValueValidate(driver, "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[5]/table/tbody/tr[7]/td[2]/div/img", "Checked", "alt");
	    Reporter.log("Loan Details - Loan Reschedule Check Validation : "+result);
	    updateTestResult(result);
	    	
	    result = ComparisonUtility.outputValueValidate(driver, "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[5]/table/tbody/tr[11]/td[4]/div", "Reschedule", "innerHTML");
	    Reporter.log("Loan Details - Last Transaction Validation : "+result);
	    updateTestResult(result);
	    
	    assertEquals("Loan Account Details Update Validation Failure",expectedTestResult,actualTestResult);
	    	
	}

}
