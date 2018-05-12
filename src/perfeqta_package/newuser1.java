

package perfeqta_package;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.openqa.selenium.By;
/*import org.openqa.selenium.NoSuchElementException;*/
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class newuser1 {
	private WebDriver browser;
	private String baseUrl;
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dash\\Desktop\\chromedriver.exe");
		browser = new ChromeDriver();
	    baseUrl = "https://qa.beperfeqta.com/v30221/#/login";
		browser.get(baseUrl);
		browser.manage().window().maximize();
		browser.findElement(By.name("username")).clear();
		browser.findElement(By.name("username"))
				.sendKeys("raveena");
		browser.findElement(By.name("password"))
				.sendKeys("Raveena@123");
		browser.findElement(By.xpath("/html/body/div/div/div/div/div[2]/button"))
		.click();

		Thread.sleep(6000);
		 browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(6000);
		browser.findElement(By.linkText("Users")).click();

		Thread.sleep(6000);
	}

		@Test
		public void testImportexport1() throws Exception {
			// Read data from excel sheet
			FileInputStream fi = new FileInputStream(
					"D:\\data\\Automation\\Users.xls");
			Workbook w = Workbook.getWorkbook(fi);
			Sheet s = w.getSheet(0);
			// Write the input data into another excel file
			FileOutputStream fo = new FileOutputStream(
					"D:\\data\\Automation\\Users_Result.xls");
			WritableWorkbook wwb = Workbook.createWorkbook(fo);
			WritableSheet ws = wwb.createSheet("Username", 0);
			Label Username = new Label(0, 0, "Username");
			ws.addCell(Username);


			for (int row = 1; row < s.getRows(); row++) {
				/*WebDriverWait wait5 = new WebDriverWait(browser, 1000);
				wait5.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_cphMain_txtDIN")));*/
				String User_name = s.getCell(0, row).getContents();
				Label l = new Label(0, row, User_name);
				ws.addCell(l);
				Thread.sleep(6000);
				browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/div/div[1]/div/a")).click();

				Thread.sleep(6000);
				browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[1]/div/div[1]/input")).sendKeys(User_name);
				System.out.println("Username : " + User_name);

				 Thread.sleep(6000);
				 browser.findElement(By
							.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[1]/div/div[2]/input"))
							.sendKeys("Firstname");

				 Thread.sleep(6000);
				 browser.findElement(By
							.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[1]/div/div[3]/input"))
							.sendKeys("Lastname");

				 Thread.sleep(6000);
				 String Email = s.getCell(1, row).getContents();
					Label l1 = new Label(1, row, Email);
					ws.addCell(l1);
					Thread.sleep(6000);
					 browser.findElement(By
								.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[1]/div/div[4]/div[1]/input"))
								.sendKeys(Email);

					Thread.sleep(6000);
					browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[2]/div/div[13]/input")).click();

					Thread.sleep(6000);
					browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[4]/div/ul/li[1]/input")).click();

					Thread.sleep(6000);
					browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[4]/div/ul/li[2]/input")).click();

					Thread.sleep(6000);
					browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[4]/div/ul/li[3]/input")).click();

					Thread.sleep(6000);
					browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[5]/div/button[1]")).click();


			}
			wwb.write();
			wwb.close();

		}
		@AfterClass
		public void setupAfterSuite() {
			// close the browser
			browser.findElement(By.linkText("raveena")).click();
			browser.findElement(By.linkText("Logout")).click();
			// browser.quit();
		}
	}
