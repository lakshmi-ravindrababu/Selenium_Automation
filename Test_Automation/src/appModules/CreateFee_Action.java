package appModules;

/*Import all the required packages and modules.*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import utility.*;


public class CreateFee_Action {
	
	/*The below method performs the fee creation action.*/
	public static void execute(WebDriver driver) throws Exception{
		
		DataValues.getFeeDataValue();
		/*Navigate to the 'Create new fee page' .*/
		driver.findElement(By.linkText("Servicing Configuration")).click();
	    driver.findElement(By.linkText("Manage Fees")).click();
	    driver.findElement(By.cssSelector("td > a > b")).click();
	    
	    /*Populate the fields with data extracted and saved into the defined fields and submit.*/
	    driver.findElement(By.id("Name")).click();
	    driver.findElement(By.id("Name")).sendKeys(DataValues.feeName);	    
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[1]/td[4]/span/select"))).selectByVisibleText(DataValues.feeCategory);  
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[2]/td[2]/div/span/select"))).selectByVisibleText(DataValues.feeState);
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/select"))).selectByVisibleText(DataValues.typeOFCharge);    
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[5]/table/tbody/tr[1]/td[2]/div/span/span/select"))).selectByVisibleText(DataValues.calculation);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[5]/table/tbody/tr[1]/td[4]/div/input")).sendKeys(DataValues.amount);
	    driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
	    
	    Reporter.log("Fee Creation Successfull"); 
	    
	    
	  
		  
	}

}
