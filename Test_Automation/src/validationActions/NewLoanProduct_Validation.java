package validationActions;

import static org.testng.AssertJUnit.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import utility.*;


public class NewLoanProduct_Validation {

	static String result = "ELEMENT NOT FOUND";
	static Boolean actualResult = true;
	static Boolean expectedResult= true;
	static String bodyText = null;
	static String inputValue = null;
	
	public static void updateTestStatus(String status)
	{
		if(status.equals("FAIL"))
			actualResult = false;
		result = "ELEMENT NOT FOUND";
	}
	
	public static void validate(WebDriver driver) throws Exception{
				
		/*Validate that the Loan Product has a standard ID*/
		result = ComparisonUtility.textValidator(driver, "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[1]/td[4]/div","LPC");
		Reporter.log("Loan Product ID Validation : " + result);
	    updateTestStatus(result);
	    
	    /*Validate that the Loan Product is created with the given name*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div",DataValues.lProductName,"innerHTML");
	    Reporter.log("Loan Product Name Validation : " + result);
	    updateTestStatus(result);
	   		
		/*Validate that the Loan Product is created with the given type*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[2]/td[4]/div",DataValues.lType,"innerHTML");
	    Reporter.log("Loan Product Type Validation : " + result);
	    updateTestStatus(result);  
		
		/*Validate that the Loan Product is created with the given Billing Method*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div",DataValues.lBillingMethod,"innerHTML");
	    Reporter.log("Loan Product Billing Method Validation : " + result);
	    updateTestStatus(result);  
		
		/*Validate that the Loan Product is created with the given Time Counting Type*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[3]/td[4]/div",DataValues.lTimeCounting,"innerHTML");
	    Reporter.log("Loan Product Time Counting Type Validation : " + result);
	    updateTestStatus(result);  
	    
	    /*Validate that the Loan Product is created with the given Payment Frequency*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[3]/td[2]/div",DataValues.lPaymentFrequeny,"innerHTML");
	    Reporter.log("Loan Product Payment Frequency Validation : " + result);
	    updateTestStatus(result);  
	 
		/*Validate that the Loan Product is created with the given Interest Only Days*/
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div",DataValues.lInterestOnlyPeriod );
	    Reporter.log("Loan Product Interest Only Days Validation : " + result);
	    updateTestStatus(result);  
	 		
		/*Validate that the Loan Product is created with the given PreBill Days*/
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[4]/td[4]/div",DataValues.lPreBill );
	    Reporter.log("Loan Product PreBill Days Validation : " + result);
	   		
		/*Validate that the Loan Product is created with the given Accural Start Basis*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[5]/td[2]/div",DataValues.lAccuralStart,"innerHTML");
	    Reporter.log("Loan Product Accural Start Basis Validation : " + result);
	    updateTestStatus(result);  
	    
		/*Validate that the Loan Product is created with the given Minimum Amount*/
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr/td[2]/div",DataValues.lMinAmount);
	    Reporter.log("Loan Product Minimum Amount Validation : " + result);
	    updateTestStatus(result); 
	    		
		/*Validate that the Loan Product is created with the given Maximum Amount*/
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr/td[4]/div",DataValues.lMaxAmount);
	    Reporter.log("Loan Product Maximum Amount Validation : " + result);
	    updateTestStatus(result); 
	 		
		/*Validate that the Loan Product is created with the given Fee Set*/
	   // result = ValidationUtility.valueValidate(driver,"lookupa0Q90000008SKgr00N90000003ctUy",DataValues.lFeeSet);
	   // Reporter.log("Loan Product FeeSet : " + result);
	    //updateTestStatus(result);  
	   
		/*Validate that the Loan Product is created with the given Minimum Term*/
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[8]/table/tbody/tr[1]/td[2]/div",DataValues.lMinTerm);
	    Reporter.log("Loan Product Minimum Term Validation : " + result);
	    updateTestStatus(result);  
		
	    /*Validate that the Loan Product is created with the given Default Term*/
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[8]/table/tbody/tr[1]/td[4]/div",DataValues.lDefaultTerm);
	    Reporter.log("Loan Product Maximum Term Validation : " + result);
	    updateTestStatus(result); 

		/*Validate that the Loan Product is created with the given Maximum Term*/
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[8]/table/tbody/tr[2]/td[2]/div",DataValues.lMaxTerm);
	    Reporter.log("Loan Product Maximum Term Validation : " + result);
	    updateTestStatus(result);  
			   		
	    /*Validate that the Loan Product is created with the given Interest Type*/
	    result = ComparisonUtility.outputValueValidate(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[10]/table/tbody/tr[1]/td[2]/div",DataValues.lInterestType,"innerHTML");
	    Reporter.log("Loan Product Interest Type : " + result);
	    updateTestStatus(result);  
		
	    /*Validate that the Loan Product is created with the given Minimum Interest */
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[10]/table/tbody/tr[3]/td[2]/div",DataValues.lMinInterest);
	    Reporter.log("Loan Product Minimum Interest : " + result);
	    updateTestStatus(result);  
		
	    /*Validate that the Loan Product is created with the given Default Interest */
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[10]/table/tbody/tr[4]/td[2]/div",DataValues.lMaxInterest);
	    Reporter.log("Loan Product Default Interest : " + result);
	    updateTestStatus(result);  
		
	    /*Validate that the Loan Product is created with the given Maximum Interest */
	    result = ComparisonUtility.outputValueValidate_AfterConvertion(driver,"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[10]/table/tbody/tr[3]/td[4]/div",DataValues.lDefaultInterest);
	    Reporter.log("Loan Product Maximum Interest : " + result);
	    updateTestStatus(result);  
	    
		
		assertEquals("Loan Product Validation Fail",expectedResult ,actualResult);
				
		
	}
	
}
