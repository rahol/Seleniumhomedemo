package BaseTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TestClass01 extends MainTest{
	
	@Test(priority=0,enabled=true)
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
			FileUtils.copyFile(screenshotFile, new File("F:\\imagesffs.png"));
			
			test.log(Status.PASS, "Navigated to the specified URL");
		} else {
			test.log(Status.FAIL, "Test Failed");
		}

		report.flush();

	}

	

}
