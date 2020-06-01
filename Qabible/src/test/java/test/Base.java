package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Base {
	public WebDriver driver;
	
	
	@BeforeClass
	  public void setup() {
		//  WebDriverManager.chromedriver().setup();
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	
		driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	  driver.get("https://www.qabible.in/payrollapp");
	  driver.manage().window().maximize();
	  }

	  @AfterClass
	  public void afterClass() {
	  }

	}
