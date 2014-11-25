package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import utility.DataValues;
import utility.ComparisonUtility;

public class MakePayment_Action {
	
   static String paymentAmount = null; 
   
   /*This method calculates the Total payment amount for manual transactions*/
   public static String calculateTotalAmount() throws Exception
   {
	   double total = 0.00;
	   total = (ComparisonUtility.cleanString(DataValues.mPricipal)+ComparisonUtility.cleanString(DataValues.mInterest)+ComparisonUtility.cleanString(DataValues.mFee));
	   return Double.toString(total);
   }
	
   /*This method performs payment action - auto spread using the payment amount for the given month*/
   public static void autoSpreadPaymentExecute(WebDriver driver) throws Exception {
	 
	  DataValues.getPaymentDataValue();
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
	  Thread.sleep(3000);
	  paymentAmount = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[11]/table/tbody/tr[3]/td[2]/div")).getText();
	  
	  
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[10]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[1]/table/tbody/tr/td[2]/input[1]")).click();	  
	  driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td/div/input")).clear();
	  driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td/div/input")).sendKeys(paymentAmount);	  
	  driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[3]/table/tbody/tr/td[2]/span[3]/input")).click();
	  
	  Reporter.log("Payment Successfull");
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
	  
  }
   
  /*This method performs payment -manual spread using user defined amounts*/ 
  public static void manualSpreadPaymentExecute(WebDriver driver) throws Exception{
	  
	  
	    DataValues.getPaymentDataValue();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[10]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[1]/table/tbody/tr/td[2]/input[1]")).click();
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[1]/input")).click();
	    
	   
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td/div/input")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td/div/input")).clear();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td/div/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td/div/input")).sendKeys(DataValues.mPricipal);
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[4]/td/div/input")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[4]/td/div/input")).clear();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[4]/td/div/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[4]/td/div/input")).sendKeys(DataValues.mInterest);
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[5]/td/span/div[1]/input")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[5]/td/span/div[1]/input")).clear();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[5]/td/span/div[1]/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[5]/td/span/div[1]/input")).sendKeys(DataValues.mFee);
	    Thread.sleep(6000);
	    paymentAmount = calculateTotalAmount();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[6]/td/div/input")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[6]/td/div/input")).clear();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[6]/td/div/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[6]/td/div/input")).sendKeys(paymentAmount);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[3]/table/tbody/tr/td[2]/span[2]/input")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[3]/table/tbody/tr/td[2]/span[3]/input")).click();
  }
   
} 
