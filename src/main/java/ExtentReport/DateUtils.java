package ExtentReport;

import java.util.Date;

public class DateUtils {


	//Method to name the reorts and scrrenshots to diffenciate them based on date,time,year and day.
	public static String timeStamp() {
		Date d = new Date();
		
		String timeStamp = d.toString().replaceAll(":", "_").replaceAll(" " , "_");
		
		return timeStamp;
	}

}
