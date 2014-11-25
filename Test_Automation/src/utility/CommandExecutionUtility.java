package utility;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import appModules.SignIn_Action;
import pageObjects.*;

public class CommandExecutionUtility {
	
	
	static String parentWindowHandler = null;
	//driver.getWindowHandle(); // Store your parent window
	static String consoleWindowHandler = null;
	static String subWindowHandler = null;
	static WebDriver driver = null;
	
	public static void execute() throws Exception{
	
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(Constant.URL);
    SignIn_Action.execute(driver);
	parentWindowHandler = driver.getWindowHandle();
	Home_Page.lnk_UserNavigation(driver).click();	
	driver.findElement(By.linkText("Developer Console")).click();
	Set<String> handles = driver.getWindowHandles(); // get all window handles
	Iterator<String> iterator = handles.iterator();
	while (iterator.hasNext()){
	    consoleWindowHandler = iterator.next();
	}
	System.out.println(consoleWindowHandler);
	driver.switchTo().window(consoleWindowHandler); // switch to popup window
	
	driver.findElement(By.xpath("//span[contains(text(),'Debug')]")).click();
    driver.findElement(By.xpath("//div[contains(text(),'Open Execute Anonymous Window')]")).click();
       
    driver.findElement(By.id("openExternalEditorToolButton-toolEl")).click();
    Set<String> handler = driver.getWindowHandles(); // get all window handles
    Iterator<String> iterators = handler.iterator();
	while (iterators.hasNext()){
		subWindowHandler = iterators.next();
	}
	System.out.println(subWindowHandler);
	driver.switchTo().window(subWindowHandler);
	driver.manage().window().maximize();
	//Thread.sleep(10000);
	
	//WebDriverWait wait = new WebDriverWait(driver,60);
	
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div/table/tbody/tr/td[2]/textarea")));
	
	//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[6]/div[1]/div/div/div/div[3]/div[1]/pre/span[1]")).sendKeys("Hey"); 
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	
	WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[6]/div[1]/div/div/div/div[3]/div[1]/pre/span[1]")); 
	//WebElement elem = yourWebDriverInstance.findElement(By.xpath("//*[@class='goog-menu goog-menu-vertical uploadmenu density-tiny']/input"));
	//String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";

	//((JavascriptExecutor)driver).executeScript(element+".innerHTML= Hey");
	String value = element.getAttribute("innerHTML");
	System.out.println(value);//]''''``;3/	//js.executeScript("document.element.innerHTML= hello");
    
  
    
	
	
	/*driver.findElement(By.xpath("//div[@class='CodeMirror']/div/textarea")).clear();
    driver.findElement(By.xpath("//div[@class='CodeMirror']/div/textarea")).sendKeys("loan.GlobalProcessFacade.moveDayBackByNDaysStartedToStarted(null,150,null);loan.GlobalProcessFacade.moveDayAheadStartedToStarted(null);");
    driver.findElement(By.xpath("//div[@id='ExecAnon']//span[contains(text(),'Execute')]")).click();*/

	//driver.switchTo().window(parentWindowHandler); 
}
	
}
