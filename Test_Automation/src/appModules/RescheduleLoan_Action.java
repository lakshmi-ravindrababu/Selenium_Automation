package appModules;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.*;
import utility.*;
import validationActions.*;


public class RescheduleLoan_Action {

	
	public static void changeNumberOfTerms(WebDriver driver) throws Exception{
		
		DataValues.getRescheduleDataValue();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[1]/table/tbody/tr/td[2]/input[5]")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[2]/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[3]/td[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[2]/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[3]/td[2]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[2]/div[2]/table/tbody/tr/td/div/div/table/tbody/tr[3]/td[2]/div/input")).sendKeys(DataValues.rTerm);
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[3]/table/tbody/tr/td[2]/span[1]/input")).click();
		Thread.sleep(3000);
		Reschedule_Validations.validatePaymentSplit(driver);	
		
	}
}
