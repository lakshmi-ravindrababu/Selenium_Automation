package utility;

/*This class contains all the global variables and extracts the Testdata from the excel into these variables*/

public class DataValues {
	
	
	public static String feeName = null;
	public static String feeCategory = null;
	public static String feeState = null;
	public static String typeOFCharge= null;
	public static String calculation= null;
	public static String amount= null;
	public static String feeSetName = null;

	
	public static String lProductName =  null;
	public static String lType = null;
	public static String lBillingMethod =  null;
	public static String lTimeCounting=  null;
	public static String lPaymentFrequeny=  null;
	public static String lInterestOnlyPeriod =  null;
	public static String lPreBill =  null;
	public static String lAccuralStart = null;
	public static String lMinAmount =  null;
	public static String lMaxAmount =  null;
	public static String lFeeSet =  null;
	public static String lMinTerm=  null;
	public static String lDefaultTerm=  null;
	public static String lMaxTerm =  null;
	public static String lInterestType=  null;
	public static String lMinInterest =  null;
	public static String lMaxInterest =  null;
	public static String lDefaultInterest=  null;
	
	public static String lContactName= null;
	public static String lPurpose = null;
	public static String lLendingProduct = null;
	public static String lAmount = null;
	public static String lBalloonPayment= null;
	
	public static String lApprover= null;
	
	public static String sUserName = null;        
	public static String sPassword =null;
	
	public static String mPaymentMode = null;
	public static String mPricipal = null;
	public static String mInterest = null;
	public static String mFee = null;
	
	public static String rTerm = null;
      
	public static void getLoginDataValue() throws Exception
	
	{
		
		 ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		 
		 sUserName = ExcelUtils.getCellData(1, 1);        
	     sPassword = ExcelUtils.getCellData(2,1);
	}
	
	public static void getFeeDataValue() throws Exception
	{
		
		 ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"FeeDetails");
		
		 /*Store the required test data into defined fields from the Excel sheet.*/
		 feeName = ExcelUtils.getCellData(0,1);
	     feeCategory = ExcelUtils.getCellData(1, 1);
		 feeState = ExcelUtils.getCellData(2,1);
		 typeOFCharge= ExcelUtils.getCellData(3,1);
		 calculation= ExcelUtils.getCellData(4,1);
		 amount= ExcelUtils.getCellData(5,1);
	}
	
	public static void getFeeSetDataValue() throws Exception{
		
		 ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"FeeSetDetails");
		 
		 feeSetName = ExcelUtils.getCellData(0,1);
	}
	
	public static void getLoanProductDataValue() throws Exception{
		
		 /*Set the excel sheet to the sheet that holds the loan product details or the test data for loan product creation.*/
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"LoanProduct");
			
		 /*Store the required test data into defined fields from the Excel sheet.*/
		 lProductName = ExcelUtils.getCellData(0,1);
		 lType = ExcelUtils.getCellData(1, 1);
		 lBillingMethod = ExcelUtils.getCellData(2,1);
		 lTimeCounting= ExcelUtils.getCellData(3,1);
		 lPaymentFrequeny= ExcelUtils.getCellData(4,1);
		 lInterestOnlyPeriod = ExcelUtils.getCellData(5,1);
		 lPreBill = ExcelUtils.getCellData(6,1);
		 lAccuralStart = ExcelUtils.getCellData(7,1);
		 lMinAmount = ExcelUtils.getCellData(8,1);
		 lMaxAmount = ExcelUtils.getCellData(9,1);
		 lFeeSet = ExcelUtils.getCellData(10,1);
		 lMinTerm= ExcelUtils.getCellData(11,1);
		 lDefaultTerm= ExcelUtils.getCellData(12,1);
		 lMaxTerm = ExcelUtils.getCellData(13,1);
		 lInterestType= ExcelUtils.getCellData(14,1);
		 lMinInterest = ExcelUtils.getCellData(15,1);
		 lMaxInterest = ExcelUtils.getCellData(16,1);
		 lDefaultInterest= ExcelUtils.getCellData(17,1);
	}
	
	public static void getLoanAccountDataValue() throws Exception{
		 
		 ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"LoanAccount");
		 
		 lContactName= ExcelUtils.getCellData(0,1);
		 lPurpose = ExcelUtils.getCellData(1, 1);
		 lLendingProduct = ExcelUtils.getCellData(2,1);
		 lAmount = ExcelUtils.getCellData(3,1);
		 lBalloonPayment= ExcelUtils.getCellData(4,1);
	}
	public static void getApprovalDataValue() throws Exception{
		 ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"LoanAccount");
		 
		 lApprover= ExcelUtils.getCellData(5,1);
	}
	
	public static void getPaymentDataValue() throws Exception{
		
		 ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"ManualPayment");
		 
		 mPaymentMode = ExcelUtils.getCellData(1,1);
		 mPricipal = ExcelUtils.getCellData(2,1);
		 mInterest = ExcelUtils.getCellData(3,1);
		 mFee = ExcelUtils.getCellData(4,1);
	}
	
	public static void getRescheduleDataValue() throws Exception{
		
		 ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"LoanAction");
		 
		 rTerm = ExcelUtils.getCellData(2,0);
	}

}
