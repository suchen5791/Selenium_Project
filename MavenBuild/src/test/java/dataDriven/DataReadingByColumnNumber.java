package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadingByColumnNumber
{

	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("D:\\SELENIUM\\xldata_test\\testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		String str = cell.getStringCellValue();
		System.out.println("Test is : "+ str);
		
		wb.close();
		fis.close();

	}

}
