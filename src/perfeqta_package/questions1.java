

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

public class questions1 {
	private WebDriver browser;
	private String baseurl;
	@BeforeClass
	public void beforeclass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\data\\Automation\\chromedriver_2.26.exe");
		browser = new ChromeDriver();
		baseurl = "https://qa.beperfeqta.com/v30229A/#/";
		browser.get(baseurl);
		browser.manage().window().maximize();
		browser.findElement(By.name("username")).clear();
		browser.findElement(By.name("username")).sendKeys("raveena");
		browser.findElement(By.name("password")).clear();
		browser.findElement(By.name("password")).sendKeys("Test@1234");
		browser.findElement(By.xpath("/html/body/div/div/div/div/div[2]/button")).click();
		Thread.sleep(5000);
	}

	@Test(description = "Add Questions", priority = 2)
	public void Question() throws Exception {
		Thread.sleep(5000);
		browser.findElement(By.xpath("/html/body/div/div/navbar/nav/div/div[1]/a/img")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Questions")).click();

		FileInputStream fi = new FileInputStream("D:\\data\\Automation\\Perfeqta_Sanity\\Questions.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		for (int row = 1; row < s.getRows(); row++) {
			Thread.sleep(5000);
			browser.findElement(By.linkText("Add New")).click();
			Thread.sleep(5000);

			// Add Question Name
			String QuestionName = s.getCell(0, row).getContents();
			browser.findElement(By.name("questiontitle")).sendKeys(QuestionName);
			Thread.sleep(5000);

			// Add Tag Value
			String TagValue = s.getCell(1, row).getContents();
			browser.findElement(By.name("questiontag")).sendKeys(TagValue);
			browser.findElement(
					By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[2]/div[2]/div[1]/div[2]/button")).click();

			// Add Type from drop down
						Thread.sleep(5000);
						WebElement TypeElement = browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[2]/div[4]/type-selector/div/div[1]/select"));
						Select dropdown= new Select(TypeElement);
						String AttributeType = s.getCell(2, row).getContents();
						dropdown.selectByVisibleText(AttributeType);
						if(row == 3)
						{
							Thread.sleep(5000);
							browser.findElement(By.name("regeRadio")).click();
							WebElement SetElement = browser.findElement(By.name("existingSet"));
							Select dropdownformat = new Select(SetElement);
							String SetName = s.getCell(4, row).getContents();
							dropdownformat.selectByVisibleText(SetName);
							Thread.sleep(5000);
						}

						if(row == 4)
						{
							Thread.sleep(5000);
							browser.findElement(By.name("regeRadio")).click();
							WebElement SetElement = browser.findElement(By.name("existingSet"));
							Select dropdownformat = new Select(SetElement);
							String SetName = s.getCell(4, row).getContents();
							dropdownformat.selectByVisibleText(SetName);
							Thread.sleep(5000);
							String Minvalue = s.getCell(5, row).getContents();
							browser.findElement(By.xpath("id('validationArea')/div/div/fieldset/div/div/fieldset/div[1]/input")).sendKeys(Minvalue);
							Thread.sleep(5000);
							String Maxvalue = s.getCell(6, row).getContents();
							browser.findElement(By.xpath("id('validationArea')/div/div/fieldset/div/div/fieldset/div[2]/input")).sendKeys(Maxvalue);
							Thread.sleep(5000);
							String ValdiationMsg = s.getCell(7, row).getContents();
							browser.findElement(By.xpath("id('validationArea')/div/div/fieldset/div/div/div[2]/textarea")).sendKeys(ValdiationMsg);
						}

				// Add Format from drop down
						if(row > 4)
						{
							Thread.sleep(5000);
							WebElement FormatElement = browser.findElement(By.name("formatSelect"));
							Select dropdownformat = new Select(FormatElement);
							String AttributeFormat = s.getCell(3, row).getContents();
							dropdownformat.selectByVisibleText(AttributeFormat);
							Thread.sleep(5000);
						}
						//For Exponential Question
						if(row == 7)
						{
							Thread.sleep(5000);
							String Exponum = s.getCell(8, row).getContents();
							browser.findElement(By.name("txtpower")).sendKeys(Exponum);
						}
						if(row == 13)
						{
							Thread.sleep(5000);
							String Exponum = s.getCell(8, row).getContents();
							browser.findElement(By.name("txtpower")).sendKeys(Exponum);
						}



						//Save the Question
						Thread.sleep(5000);
						browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[4]/div/button"))
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
