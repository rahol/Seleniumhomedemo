package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

public class ExcelMethods extends MainTest {
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

	public void takeScreenShot(String filescreenshot)
	{
		/*TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		File scrFile=screenshot.getScreenshotAs(OutputType.FILE);
		
		File DestFile=new File(filescreenshot);
		
		Files.copy(scrFile, DestFile);*/
		
		try {
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		

		
		
	}
}
