package dataDriven;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataReadingByDataProvider 
{
  @Test(dataProvider = "getData")
  public void f(String RunMode,String Browser, String UserName, String Pasword, String ExpectedResult) 
  {
	  
  }
  @DataProvider
  public Object[][] getData() throws Exception 
  {
	    ExcelAPI e = new ExcelAPI("D:\\SELENIUM\\xldata_test\\SuiteA.xlsx");
		String sheetName = "Data";
		String testCaseName = "TestB";
		
		//Get matching test case name 
		int testStartRowNum = 0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
		{
			testStartRowNum++;
		}
		System.out.println("Test Starts from row :-"+ testStartRowNum);
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		//Calculate rows of data
		int rows=0;
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows ).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are :-" + rows);
		
		//Calculate total columns
		int cols=0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total columns are :-" + cols);
		
		//Read test data
		int dataRow=0;
		Object[][] data = new Object[rows][cols];
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<cols;cNum++)
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
			data[dataRow][cNum]	= e.getCellData(sheetName, cNum, rNum);
			}
			dataRow++;
			
		}
		return data; 
   
   }
  }

