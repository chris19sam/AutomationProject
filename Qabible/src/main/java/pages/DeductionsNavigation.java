package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DeductionsNavigation {
	SoftAssert s = new SoftAssert();
	WebDriver driver;

	public DeductionsNavigation(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Deduction")
	private WebElement dedtab;
	@FindBy(linkText = "Add Deduction")
	private WebElement add_ded;

	@FindBy(xpath = "//span[@id='select2-deduction-worker_id-container']")
	private WebElement clickk;

	@FindBy(xpath = "//li[@id='select2-deduction-worker_id-result-dhpt-1' or text()='George  Panait' ]")
	private WebElement wrker;
	@FindBy(name = "Deduction[type]")
	private WebElement type;
	@FindBy(name = "Deduction[amount]")
	private WebElement amt;
	@FindBy(id = "deduction-effective_from")
	private WebElement companydate;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement save;

	public void dedtabclick() {
		dedtab.click();
	}

	public void add_deds() {
		add_ded.click();
	}

	public void verifyPageTitle() {
		try {
			Thread.sleep(300);
			String actualTitle = driver.getTitle();
			String expectedTitle = "Deductions";
			s.assertEquals(actualTitle, expectedTitle);
			s.assertAll();
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = driver.getCurrentUrl();
		System.out.println(url);

	}

	public void addDeductionsWorker() {
		clickk.click();

		WebDriverWait wait = new WebDriverWait(driver, 60);

		WebElement worker = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//li[@id='select2-deduction-worker_id-result-dhpt-1' or text()='George  Panait' ]")));
		worker.click();

	}

	public void type() {
		Select drop1 = new Select(type);
		drop1.selectByIndex(1);
	}

	public void amt() {
		amt.sendKeys("350000");
	}

	public void date() {
		// date.sendKeys("02-05-2020");
		String date = "27-05-2020";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", companydate);

	}

	public void save() {
		save.click();
	}

	public void view() throws IOException {

		WebElement element = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered detail-view']//tbody//tr[1]//td[1]"));
		System.out.println("element is "+ element.getText());
		String actualText = element.getText();
		String expectedText = "George";
		Assert.assertEquals(actualText, expectedText, "failed");
		System.out.println();
		driver.navigate().back();
	}
	}

