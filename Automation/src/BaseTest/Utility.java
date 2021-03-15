package BaseTest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@SuppressWarnings("unused")
public class Utility extends MainTest {
	FileInputStream input;
	FileOutputStream webdata;
	HSSFWorkbook wb;
	HSSFSheet sh;
	HSSFRow Row;
	HSSFCell Cell;

	public String readDataFromExcel(int rowcount, int columncount, String filepath, String Sheetname) {
		String data = null;
		try {
			input = new FileInputStream(filepath);
			wb = new HSSFWorkbook(input);
			sh = wb.getSheet(Sheetname);
			row = sh.getRow(rowcount);
			data = row.getCell(columncount).getStringCellValue();
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}

	public void writeDataFromExcel(int rowcount, int columncount, String filepath, String Sheetname, String value) {
		try {
			input = new FileInputStream(filepath);
			wb = new HSSFWorkbook(input);
			sh = wb.getSheet(Sheetname);
			row = sh.getRow(rowcount);
			webdata = new FileOutputStream(filepath);
			row.createCell(columncount).setCellValue(value);
			wb.write(webdata);

		} catch (Exception e) {

		}
	}

	public  static String takeScreenShot(String ScreenShotName) throws Exception
	{
		
		
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			
			File scrFile=screenshot.getScreenshotAs(OutputType.FILE);
			
			 String destination = System.getProperty("user.dir") + "/FailedTestScreenShots/"+ScreenShotName+dateName+".png";
			
			File DestFile=new File(destination);
			
			FileUtils.copyFile(scrFile, DestFile);
			

	
		return destination;
		
		
		
		
		
		
		
	}
}
