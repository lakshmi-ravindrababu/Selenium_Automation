package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanPayOff {
	
	public static void execute(WebDriver driver) throws Exception
	{
		 Thread.sleep(4000);
		 driver.findElement(By.id("j_id0:tabPayment_lbl")).click();
         Thread.sleep(9000);
		 driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[1]/table/tbody/tr/td[2]/input[2]")).click();
		 //driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td/div/span/input")).click();
		 driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td/div/span/input")).sendKeys("cash");
		 driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div/div/div[3]/table/tbody/tr/td[2]/span/input")).click();
		 Thread.sleep(4000);
		 Approval_Actions.paymentApprovalExecute(driver);
		 Thread.sleep(3000);
		 //assertEquals("Loan PayOff Validation Fail","Closed - Obligations met", driver.findElement(By.id("00N90000003ctTLj_id0_loanDetailIframe_ileinner")).getText());
	}

}
