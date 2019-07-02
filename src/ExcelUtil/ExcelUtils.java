package ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static String Path;
	private static FileInputStream fis;
	private static XSSFWorkbook Excel;
	private static XSSFSheet Sheet;
	private static XSSFCell cell;
	private static XSSFRow Row;

	public static void main(String[] args) throws Throwable {
		Path = "C:\\Users\\sabhowmi\\Desktop\\Excel\\data.xlsx";
		fis = new FileInputStream(Path);
		Excel = new XSSFWorkbook(fis);
		Sheet = Excel.getSheet("Sheet1");
		cell = Sheet.getRow(1).getCell(0);
		System.out.println(cell);

	}

}
