package BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentXReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Time;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

@SuppressWarnings("unused")
@Listeners(BaseTest.TestNGListener.class)
public class MainTest {

	protected static WebDriver driver;
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
	Utility excel;
	static ExtentTest test,child;
	static ExtentReports report;
	static ExtentHtmlReporter htmlreporter;
	String filepath = System.getProperty("user.dir") + "\\Reports\\extendreports.html";
	static Markup m ;
	 Actions act;
	WebDriverWait w;
	JavascriptExecutor js;

	

	@BeforeMethod
	public void beforeMethod()  {
		htmlreporter = new ExtentHtmlReporter(filepath);
		report = new ExtentReports();
		htmlreporter.setAppendExisting(true);
		report.attachReporter(htmlreporter);
		htmlreporter.config().setDocumentTitle("HTML Reporting");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setCSS("Red");
		htmlreporter.config().setReportName("Test Automation Report 1.1");
		String text = "PASS";
		m = MarkupHelper.createLabel(text, ExtentColor.GREEN);

	}


	@BeforeTest
	@Parameters({"Browser"})
	public void beforeTest(String Browser) throws Exception {

		excel = new Utility();
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (Browser.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		 act= new Actions(driver);
		 w  = new WebDriverWait(driver, 50);
		 js = (JavascriptExecutor) driver;

	}

	@AfterTest
	public void aftertest() {
		
		report.flush();	
		driver.close();
	}	

}
