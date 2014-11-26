package validationActions;

import static org.testng.AssertJUnit.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import utility.*;


public class NewLoanAccount_Validation {
	
	
	static String result = "ELEMENT NOT FOUND";
	static Boolean actualResult = true;
	static Boolean expectedResult= true;
	
	public static void updateTestStatus(String status)
	{
		if(status.equals("FAIL"))
			actualResult = false;
		result = "ELEMENT NOT FOUND";
	}
	
	public static void validate(WebDriver driver) throws Exception
	{
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"LoanAccount");
		
		/*Validate that the Loan Account has a standard loan ID*/
		result= ComparisonUtility.textValidator(driver, "Namej_id0_/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[5]/table/tbody/tr[1]/td[2]/div","LAI");
		Reporter.log("Loan Account ID Validation : " + result);
	    updateTestStatus(result);
	    
	    		
		/*Validate that the Loan Account is created for the given contact*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[5]/table/tbody/tr[2]/td[4]/div/a",DataValues.lContactName,"innerHTML");
	    Reporter.log("Loan Contact Name Validation : " + result);
	    updateTestStatus(result);
	    

		/*Validate that the Loan Account is created with the given loan purpose*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[5]/table/tbody/tr[4]/td[4]/div/a",DataValues.lPurpose,"innerHTML");
	    Reporter.log("Loan Purpose Validation : " + result);
	    updateTestStatus(result);
	     
	    
		/*Validate that the Loan Account is created with the given loan product*/
	    //result = ValidationUtility.valueValidate(driver,"CF00N90000003ctTJj_id0_loanDetailIframe",DataValues.lLendingProduct);
	   // Reporter.log("Loan Product Name Validation : " + result);
	   // updateTestStatus(result);
	    
		/*Validate that the Loan Account is created with the amount given*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/div/div[2]/div[7]/table/tbody/tr[1]/td[2]/div",DataValues.lAmount,"innerHTML");
	    Reporter.log("Loan Amount Validation : " + result);
	    updateTestStatus(result);
		
		
		assertEquals("Loan Account Validation Fail",expectedResult ,actualResult);
		

	}
}
