package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import ExtentReport.DateUtils;

public class ExtentReporter {
	
public static ExtentReports report;
	
	//To create a report(it's location and set set some system info) and then return report instance 
	public static ExtentReports createReport() {
		
		if(report == null) {
		String reportName = DateUtils.timeStamp();
		String reportPath = System.getProperty("user.dir")+"\\src\\test\\resources\\Report\\"+reportName+".html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
		
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("User", "Automatus");
		report.setSystemInfo("Type", "Test");
		
		htmlReporter.config().setDocumentTitle("EMIcalculator Test Report");
		htmlReporter.config().setReportName("EMIcalculator Test Report");
		}
		return report;
	
}

}
