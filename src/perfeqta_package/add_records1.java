


package perfeqta_package;
import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;


public class add_records1 {
	private WebDriver browser;
	private String baseUrl;
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Dash\\Desktop\\chromedriver.exe");
		browser = new ChromeDriver();
	    baseUrl = "https://test.beperfeqta.com";
		browser.get(baseUrl);
		browser.manage().window().maximize();
		browser.findElement(By.name("username")).clear();
		browser.findElement(By.name("username"))
				.sendKeys("test_qa1");
		browser.findElement(By.name("password"))
				.sendKeys("Test@123");
		browser.findElement(By.xpath("/html/body/div/div/div/div/div[2]/button"))
		.click();


	}

	@Test(description = "Add Entity Records")
	public void AddEntity() throws Exception {


		 Thread.sleep(7000);
		 browser.findElement(By.linkText("Entity Records")).click();
		 Thread.sleep(7000);
		browser.findElement(By.xpath("id('entityValueForm')/div/div[1]/div[2]/div[3]/div/div/select")).click();
		 Thread.sleep(5000);
			browser.findElement(By.xpath("id('entityValueForm')/div/div[1]/div[2]/div[3]/div/div/select/option[2]")).click();


		FileInputStream fi = new FileInputStream("D:\\data\\Automation\\Entity_Records.xls");
		Workbook w = Workbook.getWorkbook(fi);
		Sheet s = w.getSheet(0);
		int i;
	/*	int j;
		int key = 0;*/
		for (i=0;i<=s.getRows();i++)
		{
			/*Thread.sleep(7000);
			 browser.findElement(By.xpath("/html/body/div/div/navbar/nav/div/div[1]/a/img")).click();

			 Thread.sleep(7000);
			 browser.findElement(By.linkText("Entity Records")).click();
			 Thread.sleep(7000);
			browser.findElement(By.xpath("id('entityValueForm')/div/div[1]/div[2]/div[3]/div/div/select")).click();
			 Thread.sleep(5000);
				browser.findElement(By.xpath("id('entityValueForm')/div/div[1]/div[2]/div[3]/div/div/select/option[2]")).click();
					*/

	/*	for (j = key; j < key+3; j++) {
			*/
			Thread.sleep(10000);
			browser.findElement(By.className("btn")).click();
			//Enter first value
			Thread.sleep(5000);
			  String FirstValue = s.getCell(0, i).getContents();
	            Thread.sleep(2000);
	            browser.findElement(By.name("1488792554646")).sendKeys(FirstValue);

	          //Enter second value
				Thread.sleep(5000);
				 /* String SecondValue = s.getCell(0, row).getContents();
		            Thread.sleep(2000);*/
		            browser.findElement(By.name("1488792564110")).sendKeys("10");

			          //Enter third value
					Thread.sleep(5000);
					 /* String ThirdValue = s.getCell(0, row).getContents();
			            Thread.sleep(2000);*/
			            browser.findElement(By.name("1488792574196")).sendKeys("10");


			            //Enter fourth value
						Thread.sleep(5000);
						/*  String FourthValue = s.getCell(0, row).getContents();
				            Thread.sleep(2000);*/
				            browser.findElement(By.name("1488792584652")).sendKeys("10");

				            //Enter fifth value
							/*Thread.sleep(5000);
							  String FifthValue = s.getCell(0, row).getContents();*/
					            Thread.sleep(2000);
					            browser.findElement(By.name("1488792596108")).sendKeys("10");

					          //Enter sixth value
								Thread.sleep(5000);
								 /* String SixthValue = s.getCell(0, row).getContents();
						            Thread.sleep(2000);*/
						            browser.findElement(By.name("1488792609564")).sendKeys("10");

						            //Enter seventh value
									Thread.sleep(5000);
									/*  String SeventhValue = s.getCell(0, row).getContents();
							            Thread.sleep(2000);*/
							            browser.findElement(By.name("1488792621652")).sendKeys("10");

							          //Enter eighth value
										Thread.sleep(5000);
									 /* String EighthValue = s.getCell(0, row).getContents();
								            Thread.sleep(2000);*/
						            browser.findElement(By.name("1488792630612")).sendKeys("10");

								            //Enter ninth value
											Thread.sleep(5000);
											 /* String NinthValue = s.getCell(0, row).getContents();
									            Thread.sleep(2000);*/
									            browser.findElement(By.name("1488792642123")).sendKeys("10");

									            //Enter tenth value
												Thread.sleep(5000);
												/*  String TenthValue = s.getCell(0, row).getContents();
										            Thread.sleep(2000);*/
										            browser.findElement(By.name("1488792654299")).sendKeys("10");

										            Thread.sleep(5000);
										   		 browser.findElement(By.xpath("id('entityValueForm')/div/div[2]/button[2]")).click();


	/*	}
		key = key+3;*/
		}
	}
	@AfterClass
	public void afterclass() throws Exception {
		Thread.sleep(5000);
		browser.findElement(By.linkText("test")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Logout")).click();
	}
}
