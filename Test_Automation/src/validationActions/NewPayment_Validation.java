package validationActions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utility.ComparisonUtility;
import utility.DataValues;

public class NewPayment_Validation {
	
	
	public static String spaymentAmount = null;
	public static double paymentAmount = 0.0;
	public static double newTotalAmountPaid = 0.00;
	static double finalPayOffAmount = 0.00;
	static double initialTotalAmountPaid = 0.00;
	static double initialPayOffAmount = 0.00;
	static double temporaryVariable =0.00;
	static int initialTransactionCount=0;
	static int finalTransactionCount=0;
	static boolean actualResult = true;
	static boolean expectedResult = true;
	static String result = null;
	
	
    /*This method gets the initial data,that is before payment, for payment validation*/
	public static void getInitialValidationData(WebDriver driver) throws Exception
	{
		
		 Thread.sleep(6000);
		 driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[3]/table/tbody/tr[1]/td/iframe")));
		 Thread.sleep(6000);
		 initialPayOffAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/span[2]/div[2]/table/tbody/tr[2]/td[1]")).getAttribute("innerHTML"));
		 Thread.sleep(3000);
		 driver.switchTo().defaultContent();
		 paymentAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[13]/table/tbody/tr[5]/td[4]/div")).getText());
		 initialTotalAmountPaid = ComparisonUtility.cleanString(driver.findElement(By.id("00N90000003ctTij_id0_loanDetailIframe_ileinner")).getText());
		 driver.findElement(By.id("j_id0:tabPayment_lbl")).click();
		 initialTransactionCount = driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr")).size();
		 driver.findElement(By.id("j_id0:tabdetails_lbl")).click();
		 
	}
	
	/*This method updates the test result after each validation step*/
	public static void updateTestResult(String value)
	{
		if(value.equals("FAIL"))
		{
			actualResult = false;
			
		}
		
		result = null;
	}
		
	/*This method the actual validation ctions after payment*/
	public static void afterPaymentValidation(WebDriver driver,String mode) throws Exception
	{
		
		int rowCount =0;
		double pPrincipalSplit = 0.00;
		double pInterestSplit = 0.00;
		double pFeeSplit = 0.00;
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[10]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
		Thread.sleep(4000);	
		rowCount = driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr")).size();
		Thread.sleep(4000);
		pPrincipalSplit = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr["+rowCount+"]/td[5]")).getAttribute("innerHTML"));
		pInterestSplit = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr["+rowCount+"]/td[6]")).getAttribute("innerHTML"));
		pFeeSplit = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr["+rowCount+"]/td[7]")).getAttribute("innerHTML"));
		Reporter.log("Payment made with split Principal : "+pPrincipalSplit+" Interest : "+pInterestSplit+" FeeSplit : "+pFeeSplit);
		
		
		if(mode.equals("Manual"))
		{
			assertEquals("Amount Paid As Pricipal is Incorrect",ComparisonUtility.cleanString(DataValues.mPricipal),pPrincipalSplit);	
			assertEquals("Amount Paid As Interest is Incorrect",ComparisonUtility.cleanString(DataValues.mInterest) ,pInterestSplit);	
			assertEquals("Amount Paid As Fees is Incorrect",ComparisonUtility.cleanString(DataValues.mFee) ,pFeeSplit);	
		}
		
			
		newTotalAmountPaid = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[13]/table/tbody/tr[5]/td[4]/div")).getText());
		result = ComparisonUtility.doubleValueValidate(newTotalAmountPaid,(initialTotalAmountPaid+pPrincipalSplit));
		Reporter.log("Total Amount Paid Validation : " + result);
		Reporter.log("Total Amount Paid updated from " + initialTotalAmountPaid +" to " + newTotalAmountPaid);
		updateTestResult(result);
		
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[3]/table/tbody/tr[1]/td/iframe")));
		Thread.sleep(6000);
		finalPayOffAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/span[2]/div[2]/table/tbody/tr[2]/td[1]")).getAttribute("innerHTML"));
		result = ComparisonUtility.doubleValueValidate(finalPayOffAmount,(initialPayOffAmount-pPrincipalSplit));
		Reporter.log("Total PayOff Validation : " + result);
		Reporter.log("Total PayOff updated from " + initialPayOffAmount +" to " + finalPayOffAmount);
		updateTestResult(result);
		driver.switchTo().defaultContent();
		
        driver.findElement(By.id("j_id0:tabPayment_lbl")).click();
		Thread.sleep(3000);
		finalTransactionCount = driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr")).size();
		driver.findElement(By.id("j_id0:tabdetails_lbl")).click();
		result =  ComparisonUtility.integerValueValidate(finalTransactionCount,(initialTransactionCount + 1));
		Reporter.log("Total Transaction Validation : " + result);
		Reporter.log("Total Payment Transaction number updated from  " +(initialTransactionCount-1) +" to " +(finalTransactionCount-1));
		updateTestResult(result);
		

		assertEquals("Loan Payment Validation Fail",expectedResult ,actualResult);	
	
	}
}
	