package appModules;

//Import all the required packages and modules.
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageObjects.Home_Page;
import pageObjects.Login_Page;
import utility.*;

public class SignIn_Action {
		
	/*This method handles the login functionality*/
    public static void execute(WebDriver driver) throws Exception{
    	
    	/*Set the excel sheet to the sheet to which the result should be written */
    	DataValues.getLoginDataValue();
    	 
        /*Store the required test data into defined fields from the Excel sheet.*/	
              
        /*Login using the given test data*/
        Home_Page.lnk_MyAccount(driver).click();
    	Login_Page.txtbx_UserName(driver).sendKeys(DataValues.sUserName);
    	Login_Page.txtbx_Password(driver).sendKeys(DataValues.sPassword);
    	Login_Page.btn_LogIn(driver).click();
    	Reporter.log("User Log in Successfull");
    	
    	

    }

}
