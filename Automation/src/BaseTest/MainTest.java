package BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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


@SuppressWarnings("unused")
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
