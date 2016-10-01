/*
 * Scenario 36:
 * 1. Create an excel file and enter your details in the sheet.
 * 2. Read the sheet using excel poi library.
 * 3. Print the details in the console.
 * 
 * */



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

/*---Use full links--*/
//https://poi.apache.org/download.html
//https://poi.apache.org/spreadsheet/quick-guide.html

/*-----info------
You'd use HSSF if you needed to read or write an Excel file using Java (XLS). 
You'd use XSSF if you need to read or write an OOXML Excel file using Java (XLSX). 
The combined SS interface allows you to easily read and write all kinds of Excel files (XLS and XLSX) using Java. 
Additionally there is a specialized SXSSF implementation which allows to write very large Excel (XLSX) files in a memory optimized way.
*/

public class Scenario_36 
{
	
	public static void main(String args []) throws Exception
	{
		// Define Filename and its path
		File filePath = new File("//Users//ishan//Desktop//TestAuto//text.xlsx");
		FileOutputStream fileNew = new FileOutputStream(filePath);
		
		//Create Workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("TestSHEET1");
		
		// Enter data in 1st row of workbook
		Row row=sheet.createRow(0);
		Cell cell0 = row.createCell(1);
		cell0.setCellValue("Name");
		Cell cell1=row.createCell(2);
		cell1.setCellValue("Designation");
		Cell cell2=row.createCell(3);
		cell2.setCellValue("Organization");
		
		// Enter data in 2ndt row of workbook
		Row row1=sheet.createRow(1);
		Cell cell01 = row1.createCell(1);
		cell01.setCellValue("Ishan");
		Cell cell02=row1.createCell(2);
		cell02.setCellValue("SET II");
		Cell cell03=row1.createCell(3);
		cell03.setCellValue("Mindfire Solutions");
		
		//Write all the data in the workbook created
		workbook.write(fileNew);
		//fileNew.flush();
		fileNew.close();
		
		//Read from above file
		 InputStream inp = new FileInputStream(filePath);
		 
		 XSSFWorkbook workbookRead = new XSSFWorkbook(inp);
		 XSSFSheet sheetRead = workbookRead.getSheetAt(0);
		 System.out.println(sheet.getSheetName());
		 
		//Iterate through each rows one by one
         Iterator<Row> rowIterator = sheet.iterator();
         
		 while (rowIterator.hasNext())
         {
             Row rowRead = rowIterator.next();
             //For each row, iterate through all the columns
             Iterator<Cell> cellIterator = rowRead.cellIterator();
              
             while (cellIterator.hasNext())
             {
                 Cell cell = cellIterator.next();
                 //Check the cell type and format accordingly
                 switch (cell.getCellType())
                 {
                     case Cell.CELL_TYPE_NUMERIC:
                         System.out.print(cell.getNumericCellValue() + "t");
                         break;
                     case Cell.CELL_TYPE_STRING:
                         System.out.print(cell.getStringCellValue() + "t");
                         break;
                 }
             }
             System.out.println("");
         }
         fileNew.close();
	
	}

}
