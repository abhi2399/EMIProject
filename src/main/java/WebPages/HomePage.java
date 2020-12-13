package WebPages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import Excel.WriteExcel;
//import org.openqa.selenium.support.PageFactory;
import Properties.SetProperties;

public class HomePage extends BaseUI {

	Properties prop = SetProperties.getPropertiesFile();

	String principal = null;
	String Interest = null;
	String Emi = null;

	// All the webelements are declared as variable to abide by POM
	WebElement carLoanLink = driver.findElement(By.xpath(prop.getProperty("carLoanLinkXpath")));
	WebElement carLoanAmountTextbox = driver.findElement(By.xpath(prop.getProperty("carLoanAmountXpath")));
	WebElement interestRateTextbox = driver.findElement(By.xpath(prop.getProperty("interestRateXpath")));
	WebElement loanTenureTextbox = driver.findElement(By.xpath(prop.getProperty("loanTenureXpath")));

	WebElement firstMonthPrincipal = null;
	WebElement firstMonthInterest = null;
	WebElement firstMonth = null;
	WebElement firstMonthEMI = null;
	
	// Method to click on car Loan option in home page
	public void clickCarLoan() {
		try {

			logger.log(Status.INFO, "Clicking on Car Loan Link");
			
			carLoanLink.click();

			logger.log(Status.PASS, "Successfully Clicked on Car Loan Link");

		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Click on the CarLoan Link");
		}

	}

	// Method to first clear the field and then fill car loan amount in text box
	public void fillCarLoanAmount(String carLoanAmount) {
		try {
			
			logger.log(Status.INFO, "Filling Car Loan Amount");
			
			carLoanAmountTextbox.click();
			carLoanAmountTextbox.clear();
			carLoanAmountTextbox.sendKeys(carLoanAmount);
			
			logger.log(Status.PASS, "Successfull Filled the Car Loan Amount");
			

		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Fill the Car Loan Amount");
		}
	}

	// Method to first select all and press backspace then fill car Interest Rate in
	// text box
	public void fillInterestRate(String interestRate) {
		try {

			logger.log(Status.INFO, "Filling Interest Rate");

			interestRateTextbox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Actions a = new Actions(driver);
			a.sendKeys(Keys.BACK_SPACE).build().perform();
			interestRateTextbox.sendKeys(interestRate);

			logger.log(Status.PASS, "Successfully Filled the Interest Rate");
			if(interestRate.equalsIgnoreCase("0.0")) {
				logger.log(Status.FAIL, "Wrong Value Entered");
			}

		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=2427135to Fill the Interest Rate");
		}
	}

	// Method to first select all and press backspace then fill car loanTenure in
	// text box
	public void fillLoanTenure(String loanTenure) {
		try {

			logger.log(Status.INFO, "Filling Loan Tenure");

			loanTenureTextbox.sendKeys(Keys.chord(Keys.CONTROL, "http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=2427135a"));
			Actions a = new Actions(driver);
			a.sendKeys(Keys.BACK_SPACE).build().perform();
			loanTenureTextbox.sendKeys(loanTenure);

			logger.log(Status.PASS, "Successfully Filled Loan Tenure");
			
			if(loanTenure.equalsIgnoreCase("0.0")) {
				logger.log(Status.FAIL, "Wrong Value Filled");
			}

		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to fill loan Tenure");
		}
	}

	// Pressing enter to ensure that result is calculated
	public void pressEnter() {
		try {

			logger.log(Status.INFO, "Calculating EMI");

			Actions a = new Actions(driver);
			a.sendKeys(Keys.ENTER).build().perform();

			logger.log(Status.PASS, "Successfully Calculated the EMI");
			logger.addScreenCaptureFromPath(ScreenShots.TakeScreenShot.takeScreenshot(driver));

		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Calculate the EMI");
		}
	}

	public void firstMonthClick() throws Exception {


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1600)");
		
		//Thread.sleep(3000);
		
		firstMonth = driver.findElement(By.xpath(prop.getProperty("firstMonthXpath")));
		firstMonth.click();

	}

	// Method to display first Month principal
	public void displayPricipal() {

		try {

			logger.log(Status.INFO, "Fetching the Principal for First Month");

			firstMonthPrincipal = driver.findElement(By.xpath(prop.getProperty("firstMonthPrincipalXpath")));

			principal = firstMonthPrincipal.getText();

			System.out.println(principal);

			logger.log(Status.PASS, "Successfully Fetched the Principal for First Month");

		} catch (Exception e) {
			logger.log(Status.FAIL, "Falied to Fetch the Principal for First Month");
		}

	}

	// Method to display first Month Interest
	public void displayInterest() {

		try {

			logger.log(Status.INFO, "Fetching the Interest for First Month");

			firstMonthInterest = driver.findElement(By.xpath(prop.getProperty("firstMonthInterestXpath")));
			Interest = firstMonthInterest.getText();

			System.out.println(Interest);

			logger.log(Status.PASS, "Successfully Fetched the Interest for First Month");
			
			//writeToExcel();

		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Fetch the Interest for First Month");
		}

	}

	// Method to display first Month EMI
	public void displayEMI() {

		try {

			logger.log(Status.INFO, "Fetching the EMI for First Month");

			firstMonthEMI = driver.findElement(By.xpath(prop.getProperty("firstMonthEMIXpath")));
			Emi = firstMonthEMI.getText();

			System.out.println(Emi);

			logger.log(Status.PASS, "Successfully Fetched the EMI for First Month");

			writeToExcel();
			
			//Thread.sleep(2000);
			
		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Fetch the EMI for First Month");
		}

	}

	public void writeToExcel() throws IOException {
		WriteExcel.setDataToExcel(principal, Interest, Emi);

		logger.log(Status.PASS, "Successfully Written Data in the Excel Sheet");
	}

}
