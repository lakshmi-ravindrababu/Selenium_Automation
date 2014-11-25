package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Home_Page {
	
	 private static WebElement element = null;
	
	 /*This method promts the webdriver to find the element that can take the user to Login page*/
	 public static WebElement lnk_MyAccount(WebDriver driver){
	  
	     element = driver.findElement(By.id("button-login"));
	     return element;
	  
	 }
	  
	 /*This method promts the webdriver to find the element that can take the user to Logout page*/
	 public static WebElement lnk_UserNavigation(WebDriver driver){
	  
	     element = driver.findElement(By.id("userNavLabel"));
	     return element;
	  
	 }

}
