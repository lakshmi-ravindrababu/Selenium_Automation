package automationFramework;

/*import all the required packages*/
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.*;
import appModules.*;
import validationActions.*;

public class LoanAccount_TestCase {
	
  static WebDriver driver = null;
  
	 
  /*Test case to create a loan account and disburse the amount*/
  @Test(priority = 0)
  public void login() throws Exception{
	  
	    /*Log the user in*/
	    SignIn_Action.execute(driver);
	   
  }
  
  @Test(priority = 1)
  public void feeSetCreation() throws Exception{
       
	    /*Create a Fee*/
	    CreateFee_Action.execute(driver);   
	    
	    /*Create a Fee set*/
	    CreateFeeSet_Action.execute(driver);
	  
  }
  
  @Test(priority = 2)
  public void loanProductCreation() throws Exception{
	    
	    /*Create a loan product*/
	    CreateLoanProduct_Action.execute(driver);
	    NewLoanProduct_Validation.validate(driver);
	    
  }
  
  @Test(priority = 3)
  public void loanAccountCreation() throws Exception{
	  
	    /*Create a loan account*/
	    CreateLoanAccount_Action.execute(driver);
	    NewLoanAccount_Validation.validate(driver);
	    
 }
  
  @Test(priority = 4)
  public void loanApproval() throws Exception{ 	  
	    
	    /*Approve the Loan*/
	    Approval_Actions.loanAccountApprovalExecute(driver);
	      
  }
  
  @Test(priority = 5)
  public void disburseLoan() throws Exception{
	    
	    /*Disburse the loan*/
	    LoanDisbursal_Action.execute(driver);	
	
 }
  
  
 /*@Test(priority = 6)
 public void addCharge() throws Exception{
	  
	    CreateNewCharge_Action.execute(driver);
 }*/
 
 @Test(priority = 6)
 public void makeAutoPayment() throws Exception{
	  
	    NewPayment_Validation.getInitialValidationData(driver);
	    MakePayment_Action.autoSpreadPaymentExecute(driver);
	    Approval_Actions.paymentApprovalExecute(driver);
	    NewPayment_Validation.afterPaymentValidation(driver,"Auto");   
	
  }
 
 @Test(priority = 7)
 public void makeManualPayment() throws Exception{
	  
	    NewPayment_Validation.getInitialValidationData(driver);
	    MakePayment_Action.manualSpreadPaymentExecute(driver);
	    Approval_Actions.paymentApprovalExecute(driver);
	    NewPayment_Validation.afterPaymentValidation(driver,"Manual");   
	
  }
 
 @Test(priority = 7)
 public void LoanPayOff() throws Exception{
	  
	    NewPayment_Validation.getInitialValidationData(driver);
	    LoanPayOff.execute(driver);
	    Approval_Actions.paymentApprovalExecute(driver);
	    //NewPayment_Validation.afterPaymentValidation(driver);   
	
  }
  
  @Test(priority = 8)
  public void logOut() throws Exception
  {
	    
	    /*Log the user out*/
	    SignOut_Action.execute(driver);
	    /*Set the excel sheet to the sheet to which output is to be written and write the output*/
	    ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
	    ExcelUtils.setCellData("Pass", 1, 3);
	  
  }
  

  /*This method initializes the driver before the test case is executed*/
  @BeforeClass
  public void beforeMethod() throws Exception {
	  
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
      //DataValues.getValue();
      driver.get(Constant.URL);
  }

  /*This method quits the driver after the test case is executed*/
  @AfterClass
  public void afterMethod() {
	  
	  driver.quit();
  }

}
