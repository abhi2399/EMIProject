package Browser;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;

import Properties.SetProperties;
import WebPages.BaseUI;

public class BrowserSetup extends BaseUI {
	

public static WebDriver driver;
static String driverPath;
static Properties prop = SetProperties.getPropertiesFile();

	// Get Browser driver and return driver instance
	public static WebDriver getWebDriver(String Browser) {

		// For Chrome Browser
		if (Browser.equalsIgnoreCase("Chrome")) {

			try {
				driverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();

				logger.log(Status.PASS, "Chrome Browser Launched Successfully");

			} catch (Exception e) {
				logger.log(Status.FAIL, "Failed to Launch Chrome Browser");
			}
		}
			else if (Browser.equalsIgnoreCase("GRID_CHROME")) {
				
				try {	
					URL gridUrl = new URL("http://localhost:4444/wd/hub");
				

				DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
				
	            driver = new RemoteWebDriver(gridUrl,desiredCapabilities);
				}catch (
			             Exception ex) {
			         ex.printStackTrace();
			     }

			}
		 // for firefox browser
		else if (Browser.equalsIgnoreCase("Firefox")) {
			
			try {
			driverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			
			logger.log(Status.PASS, "Successfully Lunched Firefox Driver");
			
			} catch(Exception e) {
				logger.log(Status.FAIL, "Failed to Launch Firefox Driver");
			}

		} else {
			System.out.println("invalid input ,Run again");
			logger.log(Status.FAIL, "Invalid Input, Try Again");
		}

		return driver;
	}

	// Get url for data.properties file ,manage implicit wait and window size
	public static void getUrl() throws InterruptedException {
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
