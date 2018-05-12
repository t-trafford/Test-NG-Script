
package perfeqta_package;
import java.io.FileInputStream;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;

public class Entity1 {

	private WebDriver browser;


	@BeforeClass
	public void beforeclass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\Automation\\chromedriver_2.26.exe");
		browser = new ChromeDriver();

		FileInputStream fi = new FileInputStream("C:\\Windows\\Automation\\urlusersetup.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		int row = 0;
			Thread.sleep(5000);
		String baseurl = s.getCell(0, row).getContents();

		browser.get(baseurl);
		browser.manage().window().maximize();
		browser.findElement(By.name("username")).clear();
		String username = s.getCell(1, row).getContents();
		browser.findElement(By.name("username")).sendKeys(username);
		String password = s.getCell(2, row).getContents();
		browser.findElement(By.name("password")).sendKeys(password);
		browser.findElement(By.xpath("/html/body/div/div/div/div/div[2]/button")).click();
		Thread.sleep(5000);
	}


	@Test(description = "Add Entities")
	public void AddEntity() throws Exception {
		Thread.sleep(5000);
		browser.findElement(By.xpath("/html/body/div/div/navbar/nav/div/div[1]/a/img")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Entities")).click();



		FileInputStream fi = new FileInputStream("C:\\Windows\\Automation\\Entities.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		for (int row = 0; row < s.getRows(); row++) {

			Thread.sleep(5000);
			browser.findElement(By.linkText("Add New")).click();
			//Select Module name
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[2]/fieldset/div/div/div/div[1]/div/button")).click();
			  String module = s.getCell(0, row).getContents();
	            Thread.sleep(2000);
	            browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[2]/fieldset/div/div/div/div[1]/div/ul/li[4]/div/input")).sendKeys(module);
	            Thread.sleep(2000);
	            browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[2]/fieldset/div/div/div/div[1]/div/ul/li[6]/a/div/label/input")).click();

			// Add Entity Name
			String EntityName = s.getCell(1, row).getContents();
			browser.findElement(By.name("entityName")).sendKeys(EntityName);
			Thread.sleep(5000);

			// Add Entity Tag Value
			String EntityTagValue = s.getCell(2, row).getContents();
			browser.findElement(By.name("entitytag")).sendKeys(EntityTagValue);
			Thread.sleep(3000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[2]/div[2]/div[1]/div[2]/button"))
					.click();

			for (int j = 0; j < s.getRows(); j++)
			{
			// Add AttributeName1
			Thread.sleep(5000);
			String AttributeName1 = s.getCell(3, j).getContents();
			browser.findElement(By.name("questionSelection")).sendKeys(AttributeName1);


			// Add Type from drop down
			Thread.sleep(5000);
			WebElement TypeElement = browser.findElement(By.name("typeSelect"));
			Select dropdown= new Select(TypeElement);
			String AttributeType = s.getCell(4, j).getContents();
			dropdown.selectByVisibleText(AttributeType);

			if(j == 1)
			{
				Thread.sleep(5000);
				browser.findElement(By.name("regeRadio")).click();
				WebElement SetElement = browser.findElement(By.name("existingSet"));
				Select dropdownformat = new Select(SetElement);
				String SetName = s.getCell(7, j).getContents();
				dropdownformat.selectByVisibleText(SetName);
				Thread.sleep(5000);


			}

			// Add Format from drop down
			if(j > 1)
			{

				Thread.sleep(5000);
				WebElement FormatElement = browser.findElement(By.name("formatSelect"));
				Select dropdownformat = new Select(FormatElement);
				String AttributeFormat = s.getCell(5, j).getContents();
				dropdownformat.selectByVisibleText(AttributeFormat);
				Thread.sleep(5000);




			}


			//For Exponential Attribute
			if(j == 4)
			{
				Thread.sleep(5000);
				String Exponum = s.getCell(6, j).getContents();
				browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[4]/div[2]/type-selector/div/div[2]/div[2]/div[1]/control/form/div/input")).sendKeys(Exponum);


			}

			if(j == 2)
			{
				// Select unique attribute
				Thread.sleep(5000);
				browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[4]/label/input"))
						.click();
				// Click on Add Entity Button
				Thread.sleep(5000);
				browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[4]/div[6]/button"))
						.click();


			}


			// Click on Add Entity Button
						Thread.sleep(5000);
						browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[4]/div[5]/button"))
								.click();



		}
			//Save the Entity
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/fieldset/form/div[7]/div[2]/button"))
					.click();
}




	}
	@AfterClass
	public void afterclass() throws Exception {
		Thread.sleep(5000);
		browser.findElement(By.linkText("tanay3038")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Logout")).click();
	}


}
