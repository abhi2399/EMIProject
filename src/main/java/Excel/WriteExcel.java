package Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ExtentReport.DateUtils;
import Properties.SetProperties;

public class WriteExcel {

	static Properties prop = SetProperties.getPropertiesFile();

	public static void setDataToExcel(String principal, String Interest, String EMI) throws IOException {

		String excelName = DateUtils.timeStamp();

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + excelName + ".xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(prop.getProperty("SHEETNAME"));

		sheet.createRow(0).createCell(0).setCellValue(prop.getProperty("ROWNAME1"));
		sheet.getRow(0).createCell(1).setCellValue(prop.getProperty("ROWNAME"));
		sheet.getRow(0).createCell(2).setCellValue(prop.getProperty("ROWNAME2"));

		//int j = 0;
		// for(int i=1;i<=5;i++)
		// {

		sheet.createRow(1).createCell(0).setCellValue(principal);
		sheet.getRow(1).createCell(1).setCellValue(Interest);
		sheet.getRow(1).createCell(2).setCellValue(EMI);
		// j++;
		// }

		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		workbook.close();
	}

}
