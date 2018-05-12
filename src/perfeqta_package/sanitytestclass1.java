
package perfeqta_package;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;

import jxl.Sheet;
import jxl.Workbook;

public class sanitytestclass1 {
	// ExtentReports extent;
	// ExtentTest Test;
	private WebDriver browser;
	private String baseurl;

	@BeforeClass
	public void beforeclass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dash\\chromedriver.exe");
		browser = new ChromeDriver();
		baseurl = "https://qa.beperfeqta.com/qa/#/";
		browser.get(baseurl);
		browser.manage().window().maximize();
		browser.findElement(By.name("username")).clear();
		browser.findElement(By.name("username")).sendKeys("raveena");
		browser.findElement(By.name("password")).sendKeys("Raveena@123");
		browser.findElement(By.xpath("/html/body/div/div/div/div/div[2]/button")).click();
		Thread.sleep(5000);
	}

	@Test(description = "Add Sets", priority = 1)
	public void sets() throws Exception {

		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.xpath("/html/body/div/div/ui-view/div/div/div[3]/div/a/img")).click();

		FileInputStream fi = new FileInputStream("D:\\data\\Automation\\QC3.0_Sanity\\Sets.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		for (int row = 0; row < s.getRows(); row++) {
			Thread.sleep(5000);
			browser.findElement(By.linkText("Add New")).click();
			Thread.sleep(5000);
			// Add Set Name
			String SetName = s.getCell(0, row).getContents();
			browser.findElement(By.name("setNameTextBox")).sendKeys(SetName);
			Thread.sleep(5000);
			// Add Set Value 1
			String SetValue1 = s.getCell(1, row).getContents();
			browser.findElement(By.name("addSetValueTextBox")).sendKeys(SetValue1);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/form/div[2]/div[1]/div[2]/button"))
					.click();
			Thread.sleep(5000);
			// Add Set Value 2
			String SetValue2 = s.getCell(2, row).getContents();
			browser.findElement(By.name("addSetValueTextBox")).sendKeys(SetValue2);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/form/div[2]/div[1]/div[2]/button"))
					.click();
			Thread.sleep(5000);
			// Add Set Value 3
			String SetValue3 = s.getCell(3, row).getContents();
			browser.findElement(By.name("addSetValueTextBox")).sendKeys(SetValue3);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/form/div[2]/div[1]/div[2]/button"))
					.click();
			Thread.sleep(5000);
			// Click on Save Button
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/form/div[4]/div/button")).click();

		}

	}

	@Test(description = "Add Questions", priority = 2)
	public void Questions() throws Exception {
		Thread.sleep(5000);
		browser.findElement(By.xpath("/html/body/div/div/ui-view/navbar/nav/div/div[1]/a/img")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Questions")).click();

		FileInputStream fi = new FileInputStream("D:\\data\\Automation\\QC3.0_Sanity\\Questions.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		for (int row = 0; row < s.getRows(); row++) {
			Thread.sleep(5000);

			browser.findElement(By.linkText("Add New")).click();
			Thread.sleep(5000);
			// Add Question Name
			String QuestionName = s.getCell(1, row).getContents();
			browser.findElement(By.name("questiontitle")).sendKeys(QuestionName);

			Thread.sleep(5000);
			// Add Tag Value
			String TagValue = s.getCell(1, row).getContents();
			browser.findElement(By.name("questiontag")).sendKeys(TagValue);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/form/div[2]/div[2]/div[1]/div[2]/button")).click();
			// Add Type from drop down

			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/form/div[2]/div[4]/type-selector/div/div[1]/select/option[2]"))
					.click();
			// Add Format from drop down
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/form/div[2]/div[4]/type-selector/div/div[2]/div/select/option[2]"))
					.click();
			Thread.sleep(5000);
			// Click on Save Button
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/form/div[3]/div/button")).click();
		}
	}

	@Test(description = "Add Entities", priority = 3)
	public void Entities() throws Exception {
		Thread.sleep(5000);
		browser.findElement(By.xpath("/html/body/div/div/ui-view/navbar/nav/div/div[1]/a/img")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Entities")).click();

		FileInputStream fi = new FileInputStream("D:\\data\\Automation\\QC3.0_Sanity\\Entities.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		for (int row = 0; row < s.getRows(); row++) {
			Thread.sleep(5000);

			browser.findElement(By.linkText("Add New")).click();
			Thread.sleep(5000);
			// Add Entity Name
			String EntityName = s.getCell(0, row).getContents();
			browser.findElement(By.name("entityName")).sendKeys(EntityName);
			Thread.sleep(5000);
			// Add Entity Tag Value
			String EntityTagValue = s.getCell(1, row).getContents();
			browser.findElement(By.name("entitytag")).sendKeys(EntityTagValue);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[2]/div[2]/div[1]/div[2]/button"))
					.click();
			// Add AttributeName1
			Thread.sleep(5000);
			String AttributeName1 = s.getCell(2, row).getContents();
			browser.findElement(By.name("questionSelection")).sendKeys(AttributeName1);
			// Add Type from drop down
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/div[2]/type-selector/div/div/select/option[2]"))
					.click();
			// Add Format from drop down
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/div[2]/type-selector/div/div[2]/div/select"))
					.click();
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/div[2]/type-selector/div/div[2]/div/select/option[3]"))
					.click();
			// Select unique attribute
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/label/input"))
					.click();
			// Click on Add Entity Button
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/div[5]/button"))
					.click();
			// Add AttributeName2
			Thread.sleep(5000);
			String AttributeName2 = s.getCell(3, row).getContents();
			browser.findElement(By.name("questionSelection")).sendKeys(AttributeName2);
			// Add Type from drop down
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/div[2]/type-selector/div/div/select/option[2]"))
					.click();
			// Add Format from drop down
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/div[2]/type-selector/div/div[2]/div/select"))
					.click();
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/div[2]/type-selector/div/div[2]/div/select/option[3]"))
					.click();
			// Add Validation
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/fieldset/div/div/fieldset[1]/fieldset/input"))
					.click();
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/fieldset/div/div/fieldset[1]/fieldset/div/div/div[1]/select/option[3]"))
					.click();
			Thread.sleep(5000);
			browser.findElement(By.name("setValidationMessage")).sendKeys("Invalid Value");
			// Click on Add Entity Button
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[4]/div[5]/button"))
					.click();
			Thread.sleep(5000);
			WebElement htmltable = browser.findElement(By.className("table-bordered"));
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
			for (int rnum = 0; rnum < rows.size(); rnum++) {
				int inum = 4;
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));

				for (int cnum = 0; cnum < columns.size(); cnum++) {
					if (cnum == 1) {
						String tb1value = s.getCell(inum++, row).getContents();
						WebElement tb1 = columns.get(cnum).findElement(By.tagName("input"));
						tb1.sendKeys(tb1value);

					}

				}
				browser.findElement(By
						.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[5]/div/div[4]/div/span[1]/button"))
						.click();
				Thread.sleep(5000);

			}

			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[7]/div[2]/button"))
					.click();

		}

	}

	@Test(description = "Add Procedure", priority = 4)
	public void Procedures() throws Exception

	{

		Thread.sleep(5000);
		browser.findElement(By.xpath("/html/body/div/div/ui-view/navbar/nav/div/div[1]/a/img")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Procedures")).click();

		FileInputStream fi = new FileInputStream("D:\\data\\Automation\\QC3.0_Sanity\\Procedures.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		for (int row = 0; row < s.getRows(); row++) {
			Thread.sleep(5000);

			browser.findElement(By.linkText("Add New")).click();
			Thread.sleep(5000);
			// Add Procedure Name
			String ProcedureName = s.getCell(0, row).getContents();
			browser.findElement(By.name("procedureName")).sendKeys(ProcedureName);

			Thread.sleep(5000);
			// Add Procedure Tag Value
			String ProcedureTagValue = s.getCell(1, row).getContents();
			browser.findElement(By.name("proceduretag")).sendKeys(ProcedureTagValue);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[2]/div[1]/div[2]/div[1]/div[2]/button"))
					.click();
			// Add Question1 from drop down
			Thread.sleep(5000);
			String Question1 = s.getCell(2, row).getContents().toString();

			WebElement loc = browser.findElement(By.xpath("id('questionSelection')"));

			Thread.sleep(5000);
			Actions a = new Actions(browser);
			a.click(loc).keyDown(Keys.SHIFT).sendKeys(Question1.substring(0, 3)).keyDown(Keys.SHIFT)
					.sendKeys(Question1.substring(3, Question1.length())).sendKeys(Keys.RETURN);
			a.perform();

			// Add Question2 from drop down
			Thread.sleep(5000);
			String Question2 = s.getCell(3, row).getContents().toString();

			a.click(loc).keyDown(Keys.SHIFT).sendKeys(Question2.substring(0, 3)).keyDown(Keys.SHIFT)
					.sendKeys(Question2.substring(3, Question2.length())).sendKeys(Keys.RETURN);
			a.perform();

			// Click on Save Button
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[5]/div/button"))
					.click();
		}
	}

	@Test(description = "QC Form Builder", priority = 5)
	public void QCFormBuilder() throws Exception {
		Thread.sleep(5000);
		browser.findElement(By.xpath("/html/body/div/div/ui-view/navbar/nav/div/div[1]/a/img")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("QC Form Builder")).click();

		FileInputStream fi = new FileInputStream("D:\\data\\Automation\\QC3.0_Sanity\\QCFormBuilder.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		for (int row = 0; row < s.getRows(); row++) {
			Thread.sleep(5000);

			browser.findElement(By.linkText("Add New")).click();
			Thread.sleep(5000);

			// Select Module Name - Blood
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[3]/div/div[1]/div[2]/div/select/option[3]"))
					.click();
			// Enter screen title
			Thread.sleep(5000);
			String TitleName = s.getCell(0, row).getContents();
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[3]/div/div[2]/input"))
					.sendKeys(TitleName);
			Thread.sleep(15000);
			System.out.println("QC Form Title" + TitleName);
			// Enter screen description
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[3]/div/div[3]/textarea"))
					.sendKeys("This field represents the description of QC Form");
			// Enter URL
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[3]/div/div[4]/div[1]/div/input"))
					.sendKeys("http://www.google.com");
			// Assign sites
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[6]/div/div/ul/li[1]/input"))
					.click();
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[6]/div/div/ul/li[2]/input"))
					.click();
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[6]/div/div/ul/li[3]/input"))
					.click();
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[6]/div/div/ul/li[4]/input"))
					.click();

			// Click on continue button 1
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div/div[11]/div/button[3]")).click();

			// Select DIN
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div[3]/div[1]/div/div[2]/div[1]/select/option[2]"))
					.click();
			// Click on ADD Button
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div[3]/div[1]/div/div[2]/div[2]/button"))
					.click();
			// Select Instrument type
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div[3]/div[1]/div/div[2]/div[1]/select/option[3]"))
					.click();
			// Click on ADD button
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div[3]/div[1]/div/div[2]/div[2]/button"))
					.click();
			// Click on Continue 2
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div[6]/div/button[3]"))
					.click();
					// Type Entity name

			// Type Procedure name
			Thread.sleep(5000);
			String ProcedureName = s.getCell(2, row).getContents();
			WebElement loc1 = browser.findElement(By.xpath("id('selectProcedure')"));

			Thread.sleep(5000);
			Actions b = new Actions(browser);
			b.click(loc1).keyDown(Keys.SHIFT).sendKeys(ProcedureName.substring(0, 3)).keyDown(Keys.SHIFT)
					.sendKeys(ProcedureName.substring(3, ProcedureName.length())).sendKeys(Keys.RETURN);
			b.perform();

			/*
			 * //Click on Show link Thread.sleep(5000);
			 * browser.findElement(By.linkText("Show")).click(); //Click on
			 * Acceptance Criteria button Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div[3]/div[5]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/a"
			 * )).click(); //Click on Add Condition Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div[2]/expression-builder/div/div/button[1]"
			 * )).click(); //Select Question Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div[2]/expression-builder/div/div[1]/div/div/select[1]/option[3]"
			 * )).click(); //Select Operator Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div[2]/expression-builder/div/div[1]/div/div/select[2]/option[3]"
			 * )).click(); //Enter value Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div[2]/expression-builder/div/div[1]/div/div/input"
			 * )).sendKeys("093016"); //Click on Add Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div[2]/button[1]"
			 * )).click(); //Select condition Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div[3]/div/div[1]/div/div[2]/div/fieldset/div/fieldset/fieldset[1]/div/select/option[6]"
			 * )).click();
			 *
			 * //Enter value Thread.sleep(5000); browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div[3]/div/div[1]/div/div[2]/div/fieldset/div/fieldset/fieldset[3]/fieldset/div/input"
			 * )).sendKeys("123"); //Click on Save Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div[4]/div/button[1]"
			 * )).click(); //Click on conditions button Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div[7]/div[3]/div/div/div[1]/div/div[1]/div[2]/a"
			 * )).click();
			 *
			 * //Select question Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div/div[2]/div/div[2]/select/option[4]"
			 * )).click();
			 *
			 * //Select PASS Thread.sleep(5000); browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div/div[2]/div/div[4]/select/option[2]"
			 * )).click();
			 *
			 * //Select Procedure Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div/div[3]/div[2]/select/option[93]"
			 * )).click();
			 *
			 * //Click on ADD button Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div/div[3]/div[3]/button[1]"
			 * )).click();
			 *
			 * //Click on SAVE button Thread.sleep(5000);
			 * browser.findElement(By.xpath(
			 * "/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div/div[6]/div/button[1]"
			 * )).click(); Thread.sleep(5000);
			 *
			 */

			String EntityName = s.getCell(1, row).getContents();
			WebElement loc = browser.findElement(By.xpath("id('selectEntity')"));
			Thread.sleep(5000);
			Actions a = new Actions(browser);
			a.click(loc).keyDown(Keys.SHIFT).sendKeys(EntityName.substring(0, 3)).keyDown(Keys.SHIFT)
					.sendKeys(EntityName.substring(3, EntityName.length())).sendKeys(Keys.RETURN);
			a.perform();

			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/ui-view/form/div/div[4]/div/button[3]"))
					.click();

			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[1]/div[3]/div/div[1]/div/div[2]/div[1]/select/option[2]"))
					.click();
			Thread.sleep(5000);
			browser.findElement(By
					.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[1]/div[3]/div/div[1]/div/div[2]/div[2]/button"))
					.click();
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/form/div[3]/div/button[3]"))
					.click();
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/div[2]/button[2]")).click();
			Thread.sleep(5000);

			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/div/div/table/tbody/tr/td[4]/input"))
					.click();
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/div/div/table/tbody/tr/td[5]/input"))
					.click();
			Thread.sleep(5000);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/div/div/table/tbody/tr/td[6]/input"))
					.click();
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/ui-view/div/div/div/button[1]"))
					.click();

		}
	}

	@AfterClass
	public void afterclass() throws Exception {
		Thread.sleep(5000);
		browser.findElement(By.linkText("Raveena")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Logout")).click();
	}

}
