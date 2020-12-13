package Excel;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] ReadExcelSheet(String TestName) throws Exception {
		String data[][] = new String[1][3];
		String Path = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\LoanData.xlsx";
		FileInputStream readfile = new FileInputStream(Path);
		XSSFWorkbook workbook = new XSSFWorkbook(readfile);
		XSSFSheet sheet = workbook.getSheet("Data1");

		if (TestName.equalsIgnoreCase("Test")) {

			data[0][0] = String.valueOf(sheet.getRow(1).getCell(0));
			data[0][1] = String.valueOf(sheet.getRow(1).getCell(1));
			data[0][2] = String.valueOf(sheet.getRow(1).getCell(2));

		}

		else if (TestName.equalsIgnoreCase("Test1")) {

			data[0][0] = String.valueOf(sheet.getRow(2).getCell(0));
			data[0][1] = String.valueOf(sheet.getRow(2).getCell(1));
			data[0][2] = String.valueOf(sheet.getRow(2).getCell(2));
		} 
		else if (TestName.equalsIgnoreCase("Test2")) {

			data[0][0] = String.valueOf(sheet.getRow(3).getCell(0));
			data[0][1] = String.valueOf(sheet.getRow(3).getCell(1));
			data[0][2] = String.valueOf(sheet.getRow(3).getCell(2));
		}
		else if (TestName.equalsIgnoreCase("Test3")) {

			data[0][0] = String.valueOf(sheet.getRow(4).getCell(0));
			data[0][1] = String.valueOf(sheet.getRow(4).getCell(1));
			data[0][2] = String.valueOf(sheet.getRow(4).getCell(2));
		}

		workbook.close();
		return data;
	}

}
