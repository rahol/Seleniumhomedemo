package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test {
	static WebDriver driver;

	public static void main(String[] args) {
		try {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dev\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
  WebDriverWait w  = new WebDriverWait(driver, 50);
	driver.get("https://magento.fmv.cc/goldenaromatherapy/");
	driver.manage().window().maximize();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions act= new Actions(driver);
	
w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='inspiring_energy_section']/div[2]/div/ol/div/div/div/div[@class='owl-item active']/li/div/a/span/span/img[@alt='Ananda Spray']")));	

WebElement e =	driver.findElement(By.xpath("//*[@class='inspiring_energy_section']/div[2]/div/ol/div/div/div/div[@class='owl-item active']/li/div/a/span/span/img[@alt='Ananda Spray']"));

WebElement e1 =	driver.findElement(By.xpath("//*[@class='inspiring_energy_section']/div[2]/div/ol/div/div/div/div[@class='owl-item active']/li/div/a/span/span/img[@alt='Ananda Spray']/following::div[3]/div/div/form/button"));

js.executeScript("arguments[0].scrollIntoView();", e);
act.moveToElement(e).build().perform();
e1.click();
System.out.println("clicked on product");

w.until(ExpectedConditions.presenceOfElementLocated(By.id("attribute155")));

Select s = new Select(driver.findElement(By.id("attribute155")));
s.selectByIndex(1);

WebElement e2 = driver.findElement(By.id("product-addtocart-button"));

js.executeScript("arguments[0].scrollIntoView();",e2 );

e2.click();

WebElement e3 = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[1]/div[3]/div[3]/a/div/div[1]/span[1]"));

js.executeScript("arguments[0].scrollIntoView();",e3 );

act.moveToElement(e3).build().perform();

System.out.println("Moved to Add Cart");

w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='top-cart-btn-checkout']/span")));


driver.findElement(By.xpath("//*[@id='top-cart-btn-checkout']/span")).click();

w.until(ExpectedConditions.presenceOfElementLocated(By.id("customer-email")));

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
break;
}
catch (StaleElementReferenceException se) {
	System.out.println(se.getMessage());
	// TODO: handle exception
}

}

//---------click on NEXT button on Check out Page---

driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/div/button/span/span")).click();

//--------Select Payment Method -----------

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
		catch(Exception e){
			e.printStackTrace();
			
		}

		


//driver.quit();





	}

}
