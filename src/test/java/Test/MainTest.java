package Test;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excel.ReadExcel;
import Properties.SetProperties;
import WebPages.BaseUI;
import WebPages.HomePage;

public class MainTest {
	

	Properties prop = SetProperties.getPropertiesFile();

	@BeforeTest
	public void initialize() throws InterruptedException {
		BaseUI.createWebDriver(prop.getProperty("Browser"));
	}

	@Test(priority = 0 , dataProvider = "thedata")
	public void Test(String amount, String rate, String time) throws Exception {
		
		HomePage home = new HomePage();
		home.clickCarLoan();
		home.fillCarLoanAmount(amount);
		home.fillInterestRate(rate);
		home.fillLoanTenure(time);
		home.pressEnter();

		// Using to see results for test examination later it will be removed
		
		home.firstMonthClick();
		
		home.displayPricipal();
		home.displayInterest();
		home.displayEMI();
	}

	@Test(priority = 1, dataProvider = "thedata")
	public void Test1(String amount, String rate, String time) throws Exception {

		BaseUI.logger=BaseUI.report.createTest("Entering Interest Rate Amount = '0'");
		HomePage home = new HomePage();
		home.clickCarLoan();
		home.fillCarLoanAmount(amount);
		home.fillInterestRate(rate);
		home.fillLoanTenure(time);
		home.pressEnter();

		home.firstMonthClick();
		
		home.displayPricipal();
		home.displayInterest();
		home.displayEMI();
	
		
	}

	
	@Test(priority = 2, dataProvider = "thedata")
	public void Test2(String amount, String rate, String time) throws Exception {

		BaseUI.logger=BaseUI.report.createTest("Entering Car Loan Amount = '0'");
		HomePage home = new HomePage();
		home.clickCarLoan();
		home.fillCarLoanAmount(amount);
		home.fillInterestRate(rate);
		home.fillLoanTenure(time);
		home.pressEnter();

		home.firstMonthClick();
		
		home.displayPricipal();
		home.displayInterest();
		home.displayEMI();
	
		
	}

	@Test(priority = 3, dataProvider = "thedata")
	public void Test3(String amount, String rate, String time) throws Exception {

		BaseUI.logger=BaseUI.report.createTest("Entering Loan Tenure Amount = '0'");
		HomePage home = new HomePage();
		home.clickCarLoan();
		home.fillCarLoanAmount(amount);
		home.fillInterestRate(rate);
		home.fillLoanTenure(time);
		home.pressEnter();

		home.firstMonthClick();
		
		home.displayPricipal();
		home.displayInterest();
		home.displayEMI();
	
		
	}
	
	
	/*
	 * @DataProvider(name = "thedata") public String[][] data() throws Exception {
	 * return ReadExcel.ReadExcelSheet(); }
	 */

	@DataProvider(name = "thedata")
	public String[][] data(Method m) throws Exception {

		//String[][] DataP = new String[1][3];
		if(m.getName().equalsIgnoreCase("Test")){
			return ReadExcel.ReadExcelSheet("Test");
		}
		else if(m.getName().equalsIgnoreCase("Test1")) {
			return ReadExcel.ReadExcelSheet("Test1");
		}
		else if(m.getName().equalsIgnoreCase("Test2")) {
			return ReadExcel.ReadExcelSheet("Test2");
		}
		else if(m.getName().equalsIgnoreCase("Test3")) {
			return ReadExcel.ReadExcelSheet("Test3");
		}
		
		//return DataP;
		return null;

	}

	@AfterTest
	public void closeDriver() {

		BaseUI.quitDriver();
	}

}
