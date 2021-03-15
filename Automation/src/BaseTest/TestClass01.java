package BaseTest;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import BaseTest.Utility;
import BaseTest.MainTest;
@SuppressWarnings("unused")
public class TestClass01 extends MainTest{
	
	@Test(priority=1,enabled=true)
	@Parameters({"searchKey"})
	public void Initialization(String searchKey) throws Exception
	{
		test = report.createTest("Test Case 1 :Enter into Google webpage");
		test.assignAuthor("Rahul");
		test.createNode("Test Case Step 1");
		
		try
		{			
			test.createNode("Test Case Step 2 : Google enter search key");
			driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")).sendKeys(searchKey);			

			if (driver.getTitle().equals("Google"))
			{			
				test.createNode("Test Case Step 3 :Verify Google Title");
				String screenshotpath=Utility.takeScreenShot(" Verify title");		
				test.addScreenCaptureFromPath(screenshotpath, "Passed Test Cased screenshot");
				
				
			
			} 
		
		}
		catch (Exception e) 
		{		
			test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filescreenshot).build());
			
		}

	}
}
