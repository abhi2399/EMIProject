package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ExtentReport.DateUtils;

public class TakeScreenShot {
	

	public static String takeScreenshot(WebDriver driver) {
	TakesScreenshot screenshot = (TakesScreenshot) driver; 
	File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
	
	String path = System.getProperty("user.dir")+"/screenshot/"+DateUtils.timeStamp()+".png";
	File destFile = new File(path);
	
	try {
		FileUtils.copyFile(sourceFile,destFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return path;
	
	}

}
