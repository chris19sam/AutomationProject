package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	SoftAssert s=new SoftAssert();
	WebDriver driver;
	@FindBy(id="loginform-username")
	private WebElement user;
    
    @FindBy(id="loginform-password")
	private WebElement pass;
	
	@FindBy(name="login-button") 
	private WebElement submit;
   
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
      public void setenableuser()
      {
    	  boolean uname=user.isEnabled();
    	  boolean actualvalue= uname;
    	  s.assertTrue(uname);
    	  s.assertAll();
    	  
      }
      public void  setenablepass()
      {
    	  boolean upass=user.isEnabled();
    	  boolean actualvalue= upass;
    	  s.assertTrue(upass);
    	  s.assertAll();
      }
      
      
	public void setusername(String username) {
		
		user.sendKeys(username);
		
	}
	public void setpassword(String password) {
		
		pass.sendKeys(password);
	}
	public void submitbuttonclick() {
		
		submit.submit();
    }

	public void clearuser()
	{
		user.clear();
		pass.clear();
	}
	public void verifyPageTitle() {
  	  try {
			Thread.sleep(300);
	String actualTitle=driver.getTitle();
	  String expectedTitle="Payroll Application";
	  s.assertEquals(actualTitle, expectedTitle);
	  s.assertAll();	} 
  	  
  	  catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  String url =driver.getCurrentUrl();
  	  System.out.println(url);
	  
	  }
    
	}


