package Com.Qa.RegistrationPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import okhttp3.CacheControl.Builder;

public class RegistrationPage_Test {

	WebDriver driver;
	Action action;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\JAVALEARN\\filewriting\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gitlab.com/users/sign_in#register-pane");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
			}

	@Test()

	public void Registration_Page_Test() {

		driver.findElement(By.xpath("//input[@id='new_user_first_name']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='new_user_last_name']")).sendKeys("12345987456");
		driver.findElement(By.xpath("//input[@id='new_user_username']")).sendKeys("Test12345987456");
		//driver.findElement(By.id("user_remember_me")).click();
		driver.findElement(By.xpath("//input[@id='new_user_email']")).sendKeys("rocky123654789@you-spam.com");
		driver.findElement(By.xpath("//input[@id='new_user_password']")).sendKeys("654321789");
		driver.findElement(By.xpath("//input[@id='new_user_email_opted_in']")).click();
		
		
		//------> we cannot automate the Robot captcha in selenium so we need to take help of development person to solve this issues 		
		//driver.switchTo().frame("rc-anchor-alert");
		driver.findElement(By.xpath("//div[@class='submit-container mt-3']")).click();
		String Regtitle = driver.getTitle();
		System.out.println("The Registration Page Title is:::::::"+Regtitle);
		Assert.assertEquals(Regtitle, "Sign up · GitLab");

	}	
//------> we cannot automate the Robot captcha in selenium so we need to take help of development person to solve this issues 
	@AfterMethod 

	public void teardown() {

		driver.close();
		driver.quit();


	}

}
