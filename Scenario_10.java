/*
 * Scenario 10: 
 * URL : http://demos.telerik.com/kendo-ui/grid/index
 * 1. Go URL
 * 2. Write code that export all the grid data in excel sheet as it is showing in grid.
 * 3. Calculate total column , row.
 * */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scenario_10 
{
	static WebDriver driver = new FirefoxDriver();
	public static void main(String args[]) throws Exception
	{
		Scenario_10 obj=new Scenario_10();
		obj.export();
		obj.writeXls();			
	}

	void export()
	{
		driver.get("http://demos.telerik.com/kendo-ui/grid/index");			
		//To print Grid data in console
		for(int rowNum=1;rowNum<=20;rowNum++)
		{
			for(int colNum=1;colNum<5;colNum++)
			{
				//driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr["+ rowNum +"]/td[" + colNum + "]")).getText();
				System.out.print("  " + driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr["+ rowNum +"]/td[" + colNum + "]")).getText());
			}	System.out.println();
		}	

	}

	void writeXls() throws Exception
	{
		InputStream inp = new FileInputStream("/Users/ishan/Desktop/TestAuto/AutoSheet.xls");
		HSSFWorkbook workBook = new HSSFWorkbook(inp);
		HSSFSheet sheet = workBook.getSheetAt(0);
		driver.manage().timeouts().implicitlyWait(5000L, TimeUnit.SECONDS);

		//Import the data into sheet	
		for(int rowNum=1;rowNum<=20;rowNum++)
		{
			Row row = sheet.createRow(rowNum);
			for(int colNum=1;colNum<5;colNum++)
			{	
				Cell cell = row.createCell(colNum);
				cell.setCellValue(driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr["+ rowNum +"]/td[" + colNum + "]")).getText());
				FileOutputStream fileOut = new FileOutputStream("//Users//ishan//Desktop//TestAuto//AutoSheet.xls");
				workBook.write(fileOut);
				fileOut.close();
			}	System.out.println();
		}

		//Print the No. of rows and columns
		System.out.println("No. of rows in a sheet is: " + sheet.getLastRowNum());
		Row row = sheet.getRow(1);
		System.out.println("No. of columns in a sheet is: " + row.getPhysicalNumberOfCells());
	}
}
