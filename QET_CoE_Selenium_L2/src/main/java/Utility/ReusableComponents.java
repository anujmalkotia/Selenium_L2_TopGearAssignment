package Utility;
import java.io.IOException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ReusableComponents {
	public static Properties prop;
	DataFormatter formatter = new DataFormatter();
	FileInputStream fis;
	
	public String getProperty(String key) throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream("D:\\Selenium\\QET_CoE_Selenium_L2\\src\\main\\java\\Resources\\config\\data.properties");
		prop.load(fis);
		
		String value = prop.getProperty(key);
		
		return value;
	}
	
	public Object[][] readDatafromExceltc01(int sheetindex) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook(getFis("D:\\Selenium\\QET_CoE_Selenium_L2\\testdata\\registeration.xlsx"));
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row  = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i =0; i<rowCount-1 ; i++)
		{
			row=sheet.getRow(i+1);
			for(int j =0 ; j< colCount; j++ )
			{
				XSSFCell cell = row.getCell(j+1);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		workbook.close();
		return data; 
	}
	
	public FileInputStream getFis(String path) throws IOException {
		fis= new FileInputStream(path);
		return fis;
	}
	
	public Object[][] readDatafromExceltc02(int sheetindex) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook(getFis("D:\\Selenium\\QET_CoE_Selenium_L2\\testdata\\Login.xlsx"));
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row  = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i =0; i<rowCount-1 ; i++)
		{
			row=sheet.getRow(i+1);
			for(int j =0 ; j< colCount; j++ )
			{
				XSSFCell cell = row.getCell(j+1);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		workbook.close();
		return data; 
	}
	
	public String getss(String testcasename,WebDriver Driver) throws IOException
    {
        TakesScreenshot ts= (TakesScreenshot) Driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String destinationfile="D:\\Selenium\\QET_CoE_Selenium_L2\\screenshots\\"+testcasename+".png";
        FileUtils.copyFile(source, new File(destinationfile));
        return destinationfile;
    }

}
