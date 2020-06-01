package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DeductionsPage {

	WebDriver driver;
	SoftAssert s = new SoftAssert();
	public DeductionsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-eye-open']")
	private WebElement view;
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-pencil']")
	private WebElement pencilbutt;
	@FindBy(xpath = "//span[@id='select2-deduction-worker_id-container']")
	private WebElement ewrk;
	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement save;
	@FindBy(id="deduction-amount")
	private WebElement amt;	
	@FindBy(xpath ="//li[text()='Corina Elena  Slujitoru']")
	private WebElement Ram ;			
	public void deductionTab() {

		WebElement ded = driver.findElement(By.linkText("Deductions"));
		ded.click();
	}
	public void verifyPageTitle() {
		try {
			Thread.sleep(300);
			String actualTitle = driver.getTitle();
			String expectedTitle = "Deductions";
			s.assertEquals(actualTitle, expectedTitle);
			s.assertAll();}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void view() {

		view.click();
		WebElement element = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered detail-view']//tbody//tr[1]//td[1]"));
		System.out.println("element is "+ element.getText());
		String actualText = element.getText();
		String expectedText = "George";
		Assert.assertEquals(actualText, expectedText, "failed");
		System.out.println();
		driver.navigate().back();
	}

	public void edit() {
		pencilbutt.click();
		ewrk.click();
		Ram.click();
		amt.click();
		amt.clear();
		amt.sendKeys("5556231");
		save.click(); 
		WebElement element1 = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered detail-view']//tbody//tr[1]//td[1]"));
		System.out.println("element1 is "+ element1.getText());
		String actualText = element1.getText();
		String expectedText = "Corina Elena";
		Assert.assertEquals(actualText, expectedText, "failed");
		System.out.println();
		driver.navigate().back();
	}

}
