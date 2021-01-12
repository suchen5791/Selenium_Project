package dataDriven;

public class DataManagement 
{
	public static void main(String[] args) throws Exception
	{
		ExcelAPI e = new ExcelAPI("D:\\SELENIUM\\xldata_test\\SuiteA.xlsx");
		String sheetName = "Data";
		String testCaseName = "LoginTest";
		
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
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<cols;cNum++)
			{
				System.out.println(e.getCellData(sheetName, cNum, rNum));
			}
			
		}
	}

}
