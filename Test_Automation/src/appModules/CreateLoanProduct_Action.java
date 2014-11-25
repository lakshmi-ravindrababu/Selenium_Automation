package appModules;

/*Import all the required packages and modules.*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import utility.*;
public class CreateLoanProduct_Action {
	
	/*The below method performs the loan product creation action.*/
	public static void execute(WebDriver driver) throws Exception{
		
	    DataValues.getLoanProductDataValue();
		/*Navigate to the Lending Product tab ,select the product and submit.*/
		driver.findElement(By.linkText("Lending Products")).click();
	    driver.findElement(By.linkText("Create New Lending Product")).click();
	    new Select(driver.findElement(By.id("p3"))).selectByVisibleText("Loan Product Record Type");
	    driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
	  
	    
	    /*Populate the fields with data extracted and saved into the defined fields and submit.*/
	    driver.findElement(By.id("Name")).click();
	    driver.findElement(By.id("Name")).sendKeys(DataValues.lProductName);
	    
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[1]/td[4]/div/span/select"))).selectByVisibleText(DataValues.lType);
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[2]/td[2]/div/span/select"))).selectByVisibleText(DataValues.lBillingMethod);
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/select"))).selectByVisibleText(DataValues.lTimeCounting);
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[3]/td[2]/div/span/select"))).selectByVisibleText(DataValues.lPaymentFrequeny);
	    
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[3]/td[4]/input")).clear();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[3]/td[4]/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[3]/td[4]/input")).sendKeys(DataValues.lPreBill);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[4]/td[2]/input")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[4]/td[2]/input")).sendKeys(DataValues.lInterestOnlyPeriod);
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[5]/td[2]/span/select"))).selectByVisibleText(DataValues.lAccuralStart);
	    
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[5]/table/tbody/tr/td[2]/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[5]/table/tbody/tr/td[2]/input")).sendKeys(DataValues.lMinAmount);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[5]/table/tbody/tr/td[4]/div/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[5]/table/tbody/tr/td[4]/div/input")).sendKeys(DataValues.lMaxAmount);
	     
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[7]/table/tbody/tr/td[2]/span/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[7]/table/tbody/tr/td[2]/span/input")).sendKeys(DataValues.lFeeSet);
	     
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[9]/table/tbody/tr[1]/td[2]/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[9]/table/tbody/tr[1]/td[2]/input")).sendKeys(DataValues.lMinTerm);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[9]/table/tbody/tr[1]/td[4]/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[9]/table/tbody/tr[1]/td[4]/input")).sendKeys(DataValues.lDefaultTerm);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[9]/table/tbody/tr[2]/td[2]/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[9]/table/tbody/tr[2]/td[2]/input")).sendKeys(DataValues.lMaxTerm);
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[11]/table/tbody/tr[1]/td[2]/div/span/select"))).selectByVisibleText(DataValues.lInterestType);
	     
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[11]/table/tbody/tr[3]/td[2]/div/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[11]/table/tbody/tr[3]/td[2]/div/input")).sendKeys(DataValues.lMinInterest);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[11]/table/tbody/tr[4]/td[2]/div/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[11]/table/tbody/tr[4]/td[2]/div/input")).sendKeys(DataValues.lMaxInterest);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[11]/table/tbody/tr[3]/td[4]/div/input")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[11]/table/tbody/tr[3]/td[4]/div/input")).sendKeys(DataValues.lDefaultInterest);
	     
	    driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
	    
	    Reporter.log("Loan Product Creation Successfull");
	     

	     
	    
	}
}
