package test;

import org.testng.annotations.Test;

import pages.DeductionsNavigation;
import pages.DeductionsPage;
import pages.LoginPage;

public class DeductionPageTest extends Base {
	
  @Test
  public void opended() {
	  LoginPage login=new LoginPage(driver);
	  login.setusername("carol");
	  login.setpassword("1q2w3e4r");
	  login.submitbuttonclick();
	  DeductionsNavigation ded=new DeductionsNavigation(driver);
	  ded.dedtabclick();
	  DeductionsPage page=new DeductionsPage(driver);
	  page.deductionTab();
	  try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  page.view();
	  page.edit();
	  
  }
}
