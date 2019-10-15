package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WeeklyNiftyExcel 
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream fis=new FileInputStream("F:\\Z\\OpenChain\\Nifty_Weekly_17Oct.xlsx");
		//
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Weekly");
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		int cellCount = sheet.getRow(0).getLastCellNum();
		DayOfWeek day= LocalDate.now().getDayOfWeek();
		String dayWeek=day.toString();
		for(int i=0;i<rowCount; i++)
		{
			XSSFRow rw=sheet.getRow(i);
			if(rw==null)
			{
				continue;
			}
			else
			{
			for(int j=1;j<cellCount;j++)
					{
						XSSFCell cw=rw.getCell(j);
						try
						{
							if(cw==null)
							{
								//String celValue=sh.getRow(0).getCell(1).toString();
								if(sheet.getRow(i).getCell(0).toString().equals("10800_Friday"))
								{
									
									rw.createCell(j).setCellValue("Naga");
									break;
									
								}
								else
								{
									continue;
								}
							}
							else
							{
								System.out.println(cw.getStringCellValue());	
								
							}
							
						}
						catch(NullPointerException e)
						{
							e.printStackTrace();
						}
					}
			}
		}
		FileOutputStream fos=new FileOutputStream("F:\\\\Z\\\\OpenChain\\\\Nifty_Weekly_17Oct.xlsx");
		wb.write(fos);
		fos.close();
		wb.close();
		
		
	}

}
