package appModules;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utility.Constant;
import utility.ExcelUtils;

public class CreateNewCharge_Action {

	/*Declaration of storage variables*/
	public static double oldFee = 0.0;
	public static String feeToBeAdded = null;
	public static double newFee = 0.0;
	public static double chargeAdded = 0.0;
	public static  double expectedFee = 0.0;

	public static void execute(WebDriver driver) throws Exception{
		
		/*Set the Excel sheet to the sheet containing test data and extract the test data*/
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"LoanAccount");	    
	    feeToBeAdded = ExcelUtils.getCellData(6,1);		
	    
	    Thread.sleep(5000);
	    /*Store the existing charges in the loan*/
		oldFee  = Double.parseDouble(driver.findElement(By.id("00N90000003ctSwj_id0_loanDetailIframe_ileinner")).getText());
		Thread.sleep(3000);
		
		/*Navigate to Charges and add a new charge*/
		driver.findElement(By.id("j_id0:tabCharge_lbl")).click();
	    driver.findElement(By.id("j_id0:j_id20:j_id22")).click();
	    driver.findElement(By.id("j_id0:j_id26:j_id27:chargeForm:topBlk:j_id66:j_id74:j_id78")).sendKeys(feeToBeAdded);
	    driver.findElement(By.id("j_id0:j_id26:j_id27:chargeForm:topBlk:j_id81:j_id83")).click();
	    driver.findElement(By.id("j_id0:j_id26:j_id27:chargeForm:topBlk:j_id81:j_id83")).clear();
	    driver.findElement(By.id("j_id0:j_id26:j_id27:chargeForm:topBlk:j_id81:j_id83")).sendKeys("0");
	      
	    Thread.sleep(5000);
	    
	    /*Store the newly added charge*/
	    chargeAdded = Double.parseDouble(driver.findElement(By.id("j_id0:j_id26:j_id27:chargeForm:topBlk:j_id81:j_id85")).getAttribute("value"));
	    driver.findElement(By.id("j_id0:j_id26:j_id27:chargeForm:topBlk:j_id31:sBtn:j_id32:enabledId")).click();
	    /*Navigate to the loanaccount and store the total charge*/
	    driver.findElement(By.id("j_id0:tabdetails_lbl")).click();
	    Thread.sleep(5000);
	    newFee = Double.parseDouble(driver.findElement(By.id("00N90000003ctSwj_id0_loanDetailIframe_ileinner")).getText());
	    /*Validate the newly added charge*/
	    expectedFee = oldFee + chargeAdded;
	    assertEquals("Add New Charge",expectedFee, newFee );
	    Reporter.log("Charge Added Succesfully");
	    Reporter.log("Charge Validation :PASS");
	    
	    
	    
}

}
