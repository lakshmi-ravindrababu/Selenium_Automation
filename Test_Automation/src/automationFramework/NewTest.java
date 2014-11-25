package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appModules.*;
import utility.*;
import validationActions.LoanPayOff_Validation;
import validationActions.NewPayment_Validation;




public class NewTest {
	
	 static WebDriver driver = null;
     
  @Test
  public void a_Test1() throws Exception{
	  
	  //DataValues.getValue();
	  SignIn_Action.execute(driver);
	  driver.findElement(By.linkText("Contracts")).click();
	  driver.findElement(By.linkText("LAI-02701460")).click();
  }
  
  @Test
  public void b_Test2() throws Exception{
	  
	 RescheduleLoan_Action.changeNumberOfTerms(driver);
	 
	  
	  
  }
  

  @BeforeClass
  public void beforeMethod() throws Exception {
	  
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     
      driver.get(Constant.URL);
  }
}
