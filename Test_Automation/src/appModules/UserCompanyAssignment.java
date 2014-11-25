package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.ExcelUtils;

public class UserCompanyAssignment {
	
	public static void Execute(WebDriver driver) throws Exception{
		
    String userName = ExcelUtils.getCellData(1, 5);		
	driver.findElement(By.id("j_id0:searchForm:j_id2:j_id3:j_id4")).sendKeys(userName);
	
	
	}
}
