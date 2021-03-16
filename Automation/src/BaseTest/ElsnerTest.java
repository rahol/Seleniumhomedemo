package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

public class ElsnerTest extends MainTest{
		
	@Test(enabled=true)
	public void Initialization() throws Exception

	{
		test = report.createTest("Check Out Feature Test without Login");
		test.assignAuthor("Rahul Raghuwanshi");
		test.createNode("Test Case Step 1 : Launch the Application ");	
		
		
		try
		{					
			driver.get("https://magento.fmv.cc/goldenaromatherapy/");
			driver.manage().window().maximize();
		}
		catch (Exception e) 
		{		
			test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filescreenshot).build());
			
		}

	}
	
	@Test(dependsOnMethods = "Initialization")
	public void selectingProduct() throws Exception

	{
		test.createNode("Test Case Step 2 : Select Product on Home Page ");		
		try
		{					
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='inspiring_energy_section']/div[2]/div/ol/div/div/div/div[@class='owl-item active']/li/div/a/span/span/img[@alt='Ananda Spray']")));	

			WebElement e =	driver.findElement(By.xpath("//*[@class='inspiring_energy_section']/div[2]/div/ol/div/div/div/div[@class='owl-item active']/li/div/a/span/span/img[@alt='Ananda Spray']"));

			WebElement e1 =	driver.findElement(By.xpath("//*[@class='inspiring_energy_section']/div[2]/div/ol/div/div/div/div[@class='owl-item active']/li/div/a/span/span/img[@alt='Ananda Spray']/following::div[3]/div/div/form/button"));

			js.executeScript("arguments[0].scrollIntoView();", e);
			
			act.moveToElement(e).build().perform();
			
			e1.click();
			
			System.out.println("clicked on product");
		}
		catch (Exception e) 
		{		
			test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filescreenshot).build());
			
		}

	}
	
	@Test(dependsOnMethods = "selectingProduct")
	public void selectSizeOfTheProduct() throws Exception

	{
		test.createNode("Test Case Step 3 : Select size of the Product ");		
		try
		{		
			System.out.println("On Product Page");
			
			w.until(ExpectedConditions.presenceOfElementLocated(By.id("attribute155")));
			
			System.out.println("selecting size");

			Select s = new Select(driver.findElement(By.id("attribute155")));
			
			s.selectByIndex(1);
			
			System.out.println("Size selected");
			
			System.out.println("Moving to Add to Cart");

			WebElement e2 = driver.findElement(By.id("product-addtocart-button"));

			js.executeScript("arguments[0].scrollIntoView();",e2 );

			e2.click();
					
		}
		catch (Exception e) 
		{		
			test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filescreenshot).build());
			
		}

	}
	
	@Test(dependsOnMethods = "selectSizeOfTheProduct")
	public void addTOCart() throws Exception

	{
		test.createNode("Test Case Step 4 : Add to cart ");		
		try
		{		
			System.out.println("Adding to cart");
			
			WebElement e3 = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[1]/div[3]/div[3]/a/div/div[1]/span[1]"));

			js.executeScript("arguments[0].scrollIntoView();",e3 );

			act.moveToElement(e3).build().perform();

			System.out.println("Moved to Add Cart");
			
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='top-cart-btn-checkout']/span")));


			driver.findElement(By.xpath("//*[@id='top-cart-btn-checkout']/span")).click();
			
			System.out.println("clicked on Check Out button");
					
		}
		catch (Exception e) 
		{		
			test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filescreenshot).build());
			
		}

	}
	
	@Test(dependsOnMethods = "addTOCart")
	public void enterAddress() throws Exception

	{
		test.createNode("Test Case Step 5 : Enter Address details ");		
		try
		{		
			w.until(ExpectedConditions.presenceOfElementLocated(By.id("customer-email")));
			
			System.out.println("Enter user information for address");

			driver.findElement(By.id("customer-email")).sendKeys("abc@adc.com");

			driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("TestFN");

			driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("TestLN");

			driver.findElement(By.xpath("//*[@name='street[0]']")).sendKeys("TestLN");

			Select s1 = new Select(driver.findElement(By.xpath("//*[@name='country_id']")));
				
			s1.selectByValue("IN");

			Select s2 = new Select(driver.findElement(By.xpath("//*[@name='region_id']")));

			s2.selectByValue("544");

			driver.findElement(By.xpath("//*[@name='city']")).sendKeys("surat");

			driver.findElement(By.xpath("//*[@name='postcode']")).sendKeys("394150");

			driver.findElement(By.xpath("//*[@name='telephone']")).sendKeys("394343150");

			System.out.println("Entered user information for address");
			
			//---------select shiping method---


			WebElement e4 = driver.findElement(By.xpath("//*[@id='s_method_freeshipping_freeshipping']"));

			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='s_method_freeshipping_freeshipping']")));

			js.executeScript("arguments[0].scrollIntoView();",e4 );

			w.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(e4)));

			for(int i=0;i<=4;i++)
			{
			try
			{
			driver.findElement(By.xpath("//*[@id='s_method_freeshipping_freeshipping']")).click();
			System.out.println("Payment Method : COD selected");
			break;
			}
			catch (StaleElementReferenceException se) {
				System.out.println(se.getMessage());
				// TODO: handle exception
			}

			}

			//---------click on NEXT button on Check out Page---

			driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/div/button/span/span")).click();

					
		}
		catch (Exception e) 
		{		
			test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filescreenshot).build());
			
		}

	}
	
	@Test(dependsOnMethods = "enterAddress")
	public void checkOut() throws Exception

	{
		test.createNode("Test Case Step 6 : check Out Page ");		
		try
		{		
			w.until(ExpectedConditions.presenceOfElementLocated(By.id("checkmo")));

			WebElement e5 = driver.findElement(By.id("checkmo"));

			js.executeScript("arguments[0].scrollIntoView();",e5);

			driver.findElement(By.id("checkmo")).click();

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button/span")).click();

			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/h1")));

			System.out.println(driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/h1")).getText());
			Assert.assertEquals("Success", driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/h1")).getText());
					
		}
		catch (Exception e) 
		{		
			test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filescreenshot).build());
			
		}

	}
}
