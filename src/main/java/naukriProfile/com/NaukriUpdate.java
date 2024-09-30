package naukriProfile.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NaukriUpdate 
{
	WebDriver driver=null;
	
	@BeforeClass()
	
	public void applicationLaunch()
	{
		driver=new ChromeDriver();
		driver.get("https://www.naukri.com/mnjuser/profile");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
				
	}
	
	@Test(priority = 1)
	
	public void loginToApplication()
	{
		driver.findElement(By.xpath("//input[@id='usernameField']")).sendKeys("shantat.dey@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='passwordField']")).sendKeys("Naukri@1994");
		
		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	
	@Test(priority = 2)
	
	public void updateProfile() 
	{
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,1000);");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.findElement(By.xpath("//span[@class='edit icon'][1]")).click();
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
		
		String msg=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='msg']"))).getText();
		
		Assert.assertTrue(msg.equalsIgnoreCase("Resume Headline has been successfully saved."), "Profile doesnot updated");
		
	}
	
	@Test(priority = 3)
	
	public void logout()
	{
		driver.findElement(By.xpath("//div[@class='nI-gNb-bar2']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
				
	}
	
	@AfterClass()
	
	public void teardown()
	{
		driver.quit();
		
	}
	
	
	
	
	
}
	
	
