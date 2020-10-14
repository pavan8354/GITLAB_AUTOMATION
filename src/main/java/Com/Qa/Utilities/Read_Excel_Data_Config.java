package Com.Qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel_Data_Config {

	XSSFWorkbook wb;
	XSSFSheet sh1;
	
	
	public Read_Excel_Data_Config(String excelpath) {
		
		try {
			File src = new File(excelpath);	
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	public String getdata(int sheetnumber,int row,int column) {
		
		sh1 = wb.getSheetAt(sheetnumber);
		String data = sh1.getRow(row).getCell(column).getStringCellValue();
		return data;
			
	}
	
	public int getrowcount(int sheetindex) {
		
		int row = wb.getSheetAt(sheetindex).getLastRowNum();	
		row =row+1;	
		return row;
			
	}

}


