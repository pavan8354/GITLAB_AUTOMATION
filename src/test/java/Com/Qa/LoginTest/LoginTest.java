package Com.Qa.LoginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
		public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\JAVALEARN\\filewriting\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gitlab.com/users/sign_in");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}
	
	@Test(priority=1)
	
	public void Login_Page_Test() {
		
		driver.findElement(By.xpath("//button[@id='oauth-login-github']")).click();
		driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys("pavan8354");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("@Bail123");
		//driver.findElement(By.id("user_remember_me")).click();
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		String title = driver.getTitle();
		System.out.println("The Login Page Title is:::::::"+title);
		Assert.assertEquals(title, "Projects · Dashboard · GitLab");

	}	
	
@Test(priority=2)
	
	public void Login_Page_Negative_Test() {
		
		driver.findElement(By.xpath("//button[@id='oauth-login-github']")).click();
		driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys("pavan83541");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("@Bail123");
		//driver.findElement(By.id("user_remember_me")).click();
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		String title = driver.getTitle();
		System.out.println("The Login Page Title is:::::::"+title);
		Assert.assertEquals(title, "Projects · Dashboard · GitLab");

	}	
@Test(priority=3)

public void Login_Page_Email_ID_Test() {
	
//	driver.findElement(By.xpath("//button[@id='oauth-login-google_oauth2']//span")).click();
//	driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("pavanggowda28@gmail.com");
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("@Bail123");
	driver.findElement(By.id("user_remember_me")).click();
	driver.findElement(By.xpath("//input[@value='Sign in']")).click();
	
	String title = driver.getTitle();
	System.out.println("The Login Page Title is:::::::"+title);
	Assert.assertEquals(title, "Projects · Dashboard · GitLab");

}	
@Test(priority=4)

public void Login_Page_Email_ID_Negative_Test() {
	
//	driver.findElement(By.xpath("//button[@id='oauth-login-google_oauth2']//span")).click();
//	driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("pavanggowda2815@gmail.com");
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("@Bail123");
	driver.findElement(By.id("user_remember_me")).click();
	driver.findElement(By.xpath("//input[@value='Sign in']")).click();
	
	String title = driver.getTitle();
	System.out.println("The Login Page Title is:::::::"+title);
	Assert.assertEquals(title, "Projects · Dashboard · GitLab");
	
	/*driver.findElement(By.xpath("//a[@class='header-user-dropdown-toggle']//*[local-name()='svg']")).click();
	driver.findElement(By.xpath("//a[@class='sign-out-link']")).click();
	
	String logouttitle = driver.getTitle();
	System.out.println("The Logout Page Title is:::::::"+logouttitle);
	Assert.assertEquals(logouttitle, "Sign in · GitLab");*/
}	

@Test(priority=5)

public void Logout_Page_Email_ID_Test() {
	
//	driver.findElement(By.xpath("//button[@id='oauth-login-google_oauth2']//span")).click();
//	driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("pavanggowda28@gmail.com");
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("@Bail123");
	driver.findElement(By.id("user_remember_me")).click();
	driver.findElement(By.xpath("//input[@value='Sign in']")).click();
	
	String title = driver.getTitle();
	System.out.println("The Login Page Title is:::::::"+title);
	Assert.assertEquals(title, "Projects · Dashboard · GitLab");
	
	driver.findElement(By.xpath("//a[@class='header-user-dropdown-toggle']//*[local-name()='svg']")).click();
	driver.findElement(By.xpath("//a[@class='sign-out-link']")).click();
	
	String logouttitle = driver.getTitle();
	System.out.println("The Logout Page Title is:::::::"+logouttitle);
	Assert.assertEquals(logouttitle, "Sign in · GitLab");

}	
	@AfterMethod
	
	public void teardown() {
		
		driver.close();
		driver.quit();
	}
}
	



	
	

