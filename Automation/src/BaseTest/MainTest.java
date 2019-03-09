package BaseTest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;


@Listeners(BaseTest.TestNGListener.class)
public class MainTest {

	WebDriver driver;
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	HSSFWorkbook workbook;
	HSSFSheet Sheet;
	HSSFRow row;
	HSSFCell Cell;
	String sheetname = "Test";
	String path = "F:\\Data.xls";
	String filescreenshot="C:\\Users\\dev\\eclipse-workspace\\Automation\\Reports\\image.png";
	ExcelMethods excel;
	static ExtentTest test;
	static ExtentReports report;
	static ExtentHtmlReporter htmlreporter;
	String filepath = System.getProperty("user.dir") + "\\Reports\\extendreports.html";

	@BeforeMethod
	public void beforeMethod()  {
		htmlreporter = new ExtentHtmlReporter(filepath);
		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		htmlreporter.config().setDocumentTitle("HTML Reporting");
		htmlreporter.config().setTheme(Theme.DARK);
	}

	@Test
	public void Initialization() throws Exception {
		

		test = report.createTest("Test Case 1 :Enter into Google webpage");
		try {
			driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input"))
					.sendKeys(excel.readDataFromExcel(1, 1, path, sheetname));
			excel.writeDataFromExcel(1, 0, path, sheetname, sheetname);
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}

		if (driver.getTitle().equals("Google")) {
			
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("F:\\imagess.png"));
			
			test.log(Status.PASS, "Navigated to the specified URL");
		} else {
			test.log(Status.FAIL, "Test Failed");
		}

		report.flush();

	}

	@BeforeTest
	public void beforeTest() throws Exception {
		excel = new ExcelMethods();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dev\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void aftertest() {
		 driver.close();
	}

}
