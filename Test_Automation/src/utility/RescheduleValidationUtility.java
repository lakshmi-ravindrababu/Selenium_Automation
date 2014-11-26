package utility;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RescheduleValidationUtility {
	
	public static Double principalRemaining = 0.00;
	public static Double interestRemaining = 0.00;
	public static Double interestRate = 0.00;
	public static Double interestAccuruedTillDate =0.00;
	public static Double expectedPaymentAmount = 0.00;
	public static Double actualPaymentAmount = 0.00;
	//public static Double term =0.0;
	public static int rowCount = 0;
	public static String expectedStartDate = null;
	public static DecimalFormat formatter = new DecimalFormat("####0.00");

    public static void getValidationData(WebDriver driver) throws Exception{
    	
    	principalRemaining = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/span")).getText());
    	interestRemaining = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[1]/td[2]")).getText());
    	interestAccuruedTillDate =ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]")).getText());
    	rowCount = driver.findElements(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr/td/table/tbody/tr")).size();
    	expectedStartDate = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr/td/table/tbody/tr[1]/td[3]")).getText();
    	actualPaymentAmount = ComparisonUtility.cleanString(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/span[2]/form/div[1]/div/div/div/div/div[2]/span[2]/div[3]/div[2]/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[1]/td[1]")).getText());
    }

    public static String checkPaymentAmount(double term) throws Exception{
    	
    	double temporaryVariable = ((principalRemaining+interestRemaining+interestAccuruedTillDate)/ComparisonUtility.cleanString(DataValues.rTerm));
		expectedPaymentAmount= ComparisonUtility.cleanString(formatter.format(temporaryVariable));
    	return(ComparisonUtility.doubleValueValidate(expectedPaymentAmount, actualPaymentAmount));

}
    public static String checkNumberOfPayments(int term) throws Exception{
    	
    	if(rowCount == term)
    	{
    		return "PASS";
    	}
    	else
    	{
    		return "FAIL";
    	}
    }
    
    public static String checkStartDate(String date) throws Exception{
    	
    	if(date.equals(expectedStartDate))
    	{
    		return "PASS";
    	}
    	else
    	{
    		return "FAIL";
    	}	
    }
}
