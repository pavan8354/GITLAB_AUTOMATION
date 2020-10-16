package Com.Qa.CreateProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewProject {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\JAVALEARN\\filewriting\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gitlab.com/users/sign_in");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	@Test()

	public void New_Project() {

		//		driver.findElement(By.xpath("//button[@id='oauth-login-google_oauth2']//span")).click();
		//		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("pavanggowda28@gmail.com");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("@Bail123");
		driver.findElement(By.id("user_remember_me")).click();
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();

		String title = driver.getTitle();
		System.out.println("The Login Page Title is:::::::"+title);
		Assert.assertEquals(title, "Projects · Dashboard · GitLab");
		
		driver.findElement(By.xpath("//button[contains(normalize-space(),'Projects')]//*[local-name()='svg']")).click();
		driver.findElement(By.xpath("//a[@class='qa-your-projects-link']")).click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//div[@id='blank-project-name']//input[@id='project_path']")).sendKeys("my-gitlab-project27");
		driver.findElement(By.xpath("//div[@id='blank-project-pane']//input[@value='Create project']")).click();

		String Newprojecttitle = driver.getTitle();
		System.out.println("The Login Page Title is:::::::"+Newprojecttitle);
//		Assert.assertEquals(Newprojecttitle , "Details · Test 123 / My Gitlab Project26 · GitLab · GitLab");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='flash-notice mb-2']//span")).isDisplayed(), "successfully vaidated");
	}
	@AfterMethod

	public void teardown() {

		driver.close();
		driver.quit();
	}


}


