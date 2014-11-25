package appModules;

/*Import all the required packages and modules.*/
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utility.*;


public class Approval_Actions {
	
	/*This method performs the Approval action*/

	public static void approve(WebDriver driver){
		
		   driver.findElement(By.linkText("Approve / Reject")).click();
		   driver.findElement(By.name("goNext")).click();     
		   
	}
	
	
	/*The below method performs the loan approval action.*/
	public static void loanAccountApprovalExecute(WebDriver driver) throws Exception{
		
		   DataValues.getApprovalDataValue();
		   /*Submit the loan for Approval,select the approval and approve the loan.*/
		   driver.findElement(By.name("piSubmit")).click();
		   driver.switchTo().alert().accept();        
		   System.out.println("Loan Submitted for Approval");
		   driver.findElement(By.id("nextApp")).click();
		   driver.findElement(By.id("nextApp")).sendKeys(DataValues.lApprover);
		   driver.findElement(By.name("submit")).click();
		   approve(driver);
		   assertEquals("Loan Status Failure","Approved", driver.findElement(By.id("00N90000003ctTLj_id0_loanDetailIframe_ileinner")).getText());
		   Reporter.log("Loan Approval Successfull"); 
		   
	}
	
	/*This method performs the payment clearance or approval action*/
	public static void paymentApprovalExecute(WebDriver driver) throws Exception{
		
		   driver.findElement(By.id("j_id0:tabPayment_lbl")).click();
           Thread.sleep(3000);
		   driver.findElement(By.id("j_id0:tabPayment_lbl")).click();
		   Thread.sleep(10000);
		   int rowCount = driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr")).size();
		   Thread.sleep(12000);
		   driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[5]/table/tbody/tr/td/div/div[1]/div/div[2]/table/tbody/tr["+rowCount+"]/th/a")).click();
		   approve(driver);
		   Thread.sleep(3000);
		   driver.findElement(By.partialLinkText("LAI-")).click();
		   Reporter.log("Payment approved");
		   
		
	}
	

}
