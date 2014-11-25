package appModules;

/*import the required packages*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageObjects.Home_Page;

public class SignOut_Action {

	 /*This method handles the logout functionality*/
	 public static void execute(WebDriver driver) throws Exception{
		 
		 Home_Page.lnk_UserNavigation(driver).click();
		 driver.findElement(By.linkText("Logout")).click();
		 Reporter.log("Logout successfull");
     }

}