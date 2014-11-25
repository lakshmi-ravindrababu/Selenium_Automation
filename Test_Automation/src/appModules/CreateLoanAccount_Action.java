package appModules;

/*Import all the required packages and modules.*/
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import utility.*;

public class CreateLoanAccount_Action {
	
	/*The below method performs the loan account creation action.*/
	public static void execute(WebDriver driver) throws Exception{
		
		DataValues.getLoanAccountDataValue();
		/*Navigate to the Contract page,select the required record type and submit*/
		driver.findElement(By.linkText("Contracts")).click();
	    driver.findElement(By.name("new")).click();
	    new Select(driver.findElement(By.id("p3"))).selectByVisibleText("Loan");
	    driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
		    
	    /*Populate the fields with data extracted and saved into the defined fields and submit.*/
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div/div[2]/table/tbody/tr[1]/td[1]/input")).click();
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div/div[2]/table/tbody/tr[2]/td[1]/span/input")).click();
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div/div[2]/table/tbody/tr[2]/td[1]/span/input")).sendKeys(DataValues.lContactName);
	    new Select(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[3]/div/div[2]/table/tbody/tr[1]/td[1]/select"))).selectByVisibleText("New");
	    Thread.sleep(6000);
	    //driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[3]/div/div[2]/table/tbody/tr[2]/td[1]/span/input")).click();
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[3]/div/div[2]/table/tbody/tr[2]/td[1]/span/input")).sendKeys(DataValues.lPurpose);
	    //driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[3]/div/div[2]/table/tbody/tr[3]/td[1]/span/input")).click();
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[3]/div/div[2]/table/tbody/tr[3]/td[1]/span/input")).sendKeys(DataValues.lLendingProduct);
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[3]/div/div[2]/table/tbody/tr[4]/td[1]/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[4]/div/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys(DataValues.lAmount);
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/span[4]/div/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[3]/td[2]/input")).sendKeys(DataValues.lBalloonPayment);
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[3]/table/tbody/tr/td[2]/input[1]")).click();  
	    
	    assertEquals("Loan Account Creation-Status Failure" ,"Partial Application", driver.findElement(By.id("00N90000003ctTLj_id0_loanDetailIframe_ileinner")).getText());
	    Reporter.log("Loan Account Creation Successfull"); 
	  
	}
	
}
