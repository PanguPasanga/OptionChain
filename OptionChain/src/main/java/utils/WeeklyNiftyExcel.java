package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WeeklyNiftyExcel 
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream fis=new FileInputStream("F:\\Z\\OpenChain\\Nifty_Weekly_17Oct.xlsx");
		FileOutputStream fos=new FileOutputStream("");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Weekly");
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		for(int)
		
	}

}
