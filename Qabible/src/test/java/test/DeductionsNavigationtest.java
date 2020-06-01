package test;

import org.testng.annotations.Test;

import pages.DeductionsNavigation;
import pages.LoginPage;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;



  public class DeductionsNavigationtest extends Base {
	  @Test//(dataProvider = "logintestdata")
	  public void opendedtab() {
		 LoginPage login=new LoginPage(driver);
		  login.setusername("carol");
		  login.setpassword("1q2w3e4r");
		  login.submitbuttonclick();
		  DeductionsNavigation ded=new DeductionsNavigation(driver);
		  ded.dedtabclick();
		  ded.verifyPageTitle();
			 ded.add_deds();
			
	  		ded.type();
	  		ded.amt();
	  		ded.date();
	  		 ded.addDeductionsWorker();
	  		ded.save();
	  		try {
				ded.view();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
}
