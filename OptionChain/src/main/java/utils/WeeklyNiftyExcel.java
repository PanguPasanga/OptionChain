package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pages.NseWeeklyPage;

public class WeeklyNiftyExcel
{
	public static void writeToExcel(List <String> optionsValues,String strike) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\DataSheet\\Nifty_Weekly_17Oct.xlsx");
		//
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Weekly");
		//int rowCount = sheet.getPhysicalNumberOfRows();
		int rowCount = sheet.getLastRowNum();
		//System.out.println(rowCount);
		
		int cellCount = sheet.getRow(0).getLastCellNum();
		DayOfWeek day= LocalDate.now().getDayOfWeek();
		String dayWeek=day.toString();
		int index=0;
		int k=1;
		for(int i=k;i<rowCount; i++)
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
								//System.out.println(strike+"_"+dayWeek);
								//System.out.println(sheet.getRow(i).getCell(0).toString());
								//String celValue=sh.getRow(0).getCell(1).toString();
								if(sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(strike+"_"+dayWeek))
								{
									//System.out.println("Into the IF");
									System.out.println(optionsValues.get(index)+" Strike"+strike);
									rw.createCell(j).setCellValue(optionsValues.get(index++));
									//
									//break;
									
								}
								else
								{
									//System.out.println("In the continue statement");
									continue;
								}
							}
							else
							{
								//System.out.println(cw.getStringCellValue());	
								
							}
							
						}
						catch(NullPointerException e)
						{
							e.printStackTrace();
						}
					}
			}
			
			break;
		}
		FileOutputStream fos=new FileOutputStream(".\\DataSheet\\Nifty_Weekly_17Oct.xlsx");
		wb.write(fos);
		fos.close();
		wb.close();
		k++;
		//NseWeeklyPage.k++;
	}
	

}
