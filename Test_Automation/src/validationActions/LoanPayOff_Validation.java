package validationActions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utility.ComparisonUtility;


public class LoanPayOff_Validation {
	
	public static String result = null;
	public static boolean actualResult = true;
	public static boolean expectedResult = true;
	public static double payOffAmount = 0.00;
	public static double initialPayOffAmount =0.00;
	public static double finalPayOffAmount =0.00;
	public static double initialTotalAmountPaid = 0.00;
	public static int initialTransactionCount =0;
	public static double newTotalAmountPaid =0.00;
	public static int finalTransactionCount = 0;
	
	
	/*This method updates the actual test result after each validation*/
	public static void updateTestResult(String value)
	{
		if(value.equals("FAIL"))
		{
			actualResult = false;
			
		}
		
		result = null;
	}
	
    /*This method gets the initial data,that is before payoff, for payoff validation*/
	public static void getInitialValidationData(WebDriver driver) throws Exception
	{
		Thread.sleep(6000);
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[3]/table/tbody/tr[1]/td/iframe")));
		Thread.sleep(6000);
		initialPayOffAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("html/body/span[2]/div[2]/table/tbody/tr[2]/td[1]")).getAttribute("innerHTML"));
		System.out.println(initialPayOffAmount);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		initialTotalAmountPaid = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[13]/table/tbody/tr[5]/td[4]/div")).getText());
		driver.findElement(By.id("j_id0:tabPayment_lbl")).click();
		Thread.sleep(3000);
		System.out.println(initialTotalAmountPaid);
	    
		initialTransactionCount = driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr")).size();
	    driver.findElement(By.name("loan__loan_pay_off")).click();
	    Thread.sleep(3000);
	    System.out.println(initialTransactionCount);
	    
	    payOffAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[4]/td/div/input")).getAttribute("value"));
	    result = ComparisonUtility.doubleValueValidate(0.00,(initialPayOffAmount - payOffAmount));
	    Reporter.log("Loan Amount to be paidoff Validation : " + result);
	    updateTestResult(result);
	    System.out.println(payOffAmount);
	    
	    
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div[3]/table/tbody/tr/td[2]/input")).click();	
	    
	}
	
	/*This method performs the loan payoff validation*/
	public static void afterPayOffValidation(WebDriver driver) throws Exception{
		
	    Thread.sleep(4000);
	    result = ComparisonUtility.outputValueValidate(driver,"00N90000003ctTLj_id0_loanDetailIframe_ileinner","Closed - Obligations met","innerHTML");
	    Reporter.log("Loan Status Validation : " + result);
	    updateTestResult(result);
	    	    
	    Thread.sleep(6000);
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[3]/table/tbody/tr[1]/td/iframe")));
		Thread.sleep(6000);
		finalPayOffAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/span[2]/div[2]/table/tbody/tr[2]/td[1]")).getAttribute("innerHTML"));
		driver.switchTo().defaultContent();
		result = ComparisonUtility.doubleValueValidate(finalPayOffAmount,(initialPayOffAmount - payOffAmount));
		Reporter.log("Total PayOff Validation : " + result);
		Reporter.log("Total PayOff updated from " + initialPayOffAmount +" to " + finalPayOffAmount);
		updateTestResult(result);
		
		
	    Thread.sleep(4000);
	    newTotalAmountPaid = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[13]/table/tbody/tr[5]/td[4]/div")).getText());
	    result = ComparisonUtility.doubleValueValidate(newTotalAmountPaid,(initialTotalAmountPaid + payOffAmount));
	    Reporter.log("Total Amount Paid Validation : " + result);
		Reporter.log("Total Amount Paid updated from " + initialTotalAmountPaid +" to " + newTotalAmountPaid);
		updateTestResult(result);
		
					
		driver.findElement(By.id("j_id0:tabPayment_lbl")).click();
		Thread.sleep(3000);
		finalTransactionCount = driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr")).size();
		driver.findElement(By.id("j_id0:tabdetails_lbl")).click();
		result = ComparisonUtility.integerValueValidate(finalTransactionCount,(initialTransactionCount + 1));
		Reporter.log("Payment Transaction Validation : "+result);
		Reporter.log("Total Payment Transaction number updated from  " +(initialTransactionCount-1) +" to " +(finalTransactionCount-1));
		updateTestResult(result);
		
		
		assertEquals("Loan Payment Validation Fail",expectedResult ,actualResult);				
		}	    
	    
	    
	    
	}

