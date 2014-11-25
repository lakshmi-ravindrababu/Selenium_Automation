package appModules;

/*Import all the required packages and modules.*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import utility.*;


public class CreateFeeSet_Action {
	
	/*The below method performs the fee set creation action.*/
	public static void execute(WebDriver driver) throws Exception{
		
		/*Set the excel sheet to the sheet that holds the fee set details or the test data for fee set creation.*/
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"FeeSetDetails");
		
		/*Store the required test data into defined fields from the Excel sheet.*/
		
		String feeName = null;
		
        DataValues.getFeeSetDataValue();
		/*Navigate to the 'Create new fee set page' .*/
		driver.findElement(By.linkText("Servicing Configuration")).click();
	    driver.findElement(By.linkText("Manage Fee Set")).click();
	    driver.findElement(By.cssSelector("td > a > b")).click();
	    
	    /*Populate the fields with data extracted and saved into the defined fields and submit.*/
	    driver.findElement(By.id("Name")).click();
	    driver.findElement(By.id("Name")).sendKeys(DataValues.feeSetName);
	    new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[1]/td[4]/div/span/select"))).selectByVisibleText("Loan");
	    driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
	    
	    /*Attach n number of fees to the fee set.*/
	    for(int i=1;i<4;i++)
	    {
	    	/*Get the fee name from the test data sheet.*/
	    	feeName = ExcelUtils.getCellData(i,1);
	    	 
	    	/*Attach the fee to the fee set and save.*/
		    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[5]/div[1]/div/div[1]/table/tbody/tr/td[2]/input")).click();
		    driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr/td[2]/div/span/input")).click();
	    	driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr/td[2]/div/span/input")).sendKeys(feeName);	
	    	driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
	    	
	    }
	    
	    
	    Reporter.log("Fee Set Creation Successfull"); 
		    
	    
		}

}
