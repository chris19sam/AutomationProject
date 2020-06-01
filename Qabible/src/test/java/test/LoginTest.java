package test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import jxl.read.biff.BiffException;
import pages.LoginPage;
import utility.ExcelData;


  public class LoginTest extends Base {

	  @Test(dataProvider = "logintestdata")
	  public void verifylogin(String username, String password) {
		  LoginPage login=new LoginPage(driver);
		  login.clearuser();
		  login.setusername(username);
		  login.setpassword(password);
		  login.submitbuttonclick();
		  login.verifyPageTitle();
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  driver.get("https://www.qabible.in/payrollapp/");
		  
	  }
	 
	  @DataProvider
	  public Object[][] logintestdata() throws BiffException, IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		  Object[][] data = ExcelData.getDataFromSheet("D:\\Java programs\\qabible.xlsx");
		  return data;
	  }
}

