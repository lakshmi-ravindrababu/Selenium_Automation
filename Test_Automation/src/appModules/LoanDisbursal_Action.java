package appModules;

/*Import all the required packages and modules.*/
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


public class LoanDisbursal_Action {
	
	/*The below method performs the loan approval action.*/
	public static void execute(WebDriver driver) throws Exception{

		/*Disburse the loan.*/
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/form/table/tbody/tr/td[4]/table/tbody/tr/td[2]/table/tbody/tr/td")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div/div[1]/div/div[1]/table/tbody/tr/td[2]/input")).click();
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]/div/span/input")).click();
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]/div/span/input")).sendKeys("Cash");
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[3]/table/tbody/tr/td[2]/span[3]/input")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[3]/table/tbody/tr/td[2]/span[2]/input")).click();
	    
	    assertEquals("Active - Good Standing", driver.findElement(By.id("00N90000003ctTLj_id0_loanDetailIframe_ileinner")).getText());
	    Reporter.log("Loan Disbursal Successfull");
	}

}
