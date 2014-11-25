package pageObjects;

/*import all the required packages*/
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	
	private static WebElement element = null;
	
	/*This method types in the username*/
	public static WebElement txtbx_UserName(WebDriver driver){
		
		element = driver.findElement(By.id("username"));
		return element;
		
	}

	/*This method finds the password element*/
	public static WebElement txtbx_Password(WebDriver driver){
	 
		element = driver.findElement(By.id("password"));
		return element;

    }
	 
    /*This method finds the login button*/
	public static WebElement btn_LogIn(WebDriver driver){
		 
         element = driver.findElement(By.id("Login"));
         return element;
 
     }
	

}