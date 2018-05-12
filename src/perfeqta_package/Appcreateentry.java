package perfeqta_package;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;




public class Appcreateentry {
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

	//



	@Test(description = "Add Questions", priority = 2)


	public void Question() throws Exception {
		Thread.sleep(5000);
	//	browser.findElement(By.xpath("/html/body/div/div/ui-view/navbar/nav/div/div[1]/a/img")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Questions")).click();

		FileInputStream fi = new FileInputStream("C:\\Windows\\Automation\\Questions.xls");
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
						WebElement TypeElement = browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[2]/div[4]/type-selector/div/div/select"));
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
						if(row == 14)
						{
							Thread.sleep(5000);
							String Exponum = s.getCell(8, row).getContents();
							browser.findElement(By.name("txtpower")).sendKeys(Exponum);
						}



						//Save the Question
						Thread.sleep(5000);
						browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/form/div[4]/div/button")).click();
			}
	}




	@Test(description = "Add Procedure", priority = 3)
	public void Procedures() throws Exception

	{

		Thread.sleep(5000);
		browser.findElement(By.xpath("/html/body/div/div/ui-view/navbar/nav/div/div[1]/a/img")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Administration")).click();
		Thread.sleep(5000);
		browser.findElement(By.linkText("Procedures")).click();

		FileInputStream fi = new FileInputStream("C:\\Windows\\Automation\\Procedures.xls");
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
			Thread.sleep(3000);
			browser.findElement(By.className("btn")).click();
			// Add Question1 from drop down
			Thread.sleep(5000);
			String Question1 = s.getCell(2, row).getContents().toString();

			 browser.findElement(By.name("questionSelection")).sendKeys(Question1);

			Thread.sleep(5000);

			 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

			 Thread.sleep(5000);
			 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

				Thread.sleep(5000);
				String Question2 = s.getCell(3, row).getContents().toString();

				 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question2);

				Thread.sleep(5000);
				 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

				 Thread.sleep(5000);
				 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

					Thread.sleep(5000);
					String Question3 = s.getCell(4, row).getContents().toString();

					 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question3);

					Thread.sleep(5000);
					 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

					 Thread.sleep(5000);
					 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

					 Thread.sleep(5000);
						String Question4 = s.getCell(5, row).getContents().toString();

						 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question4);

						Thread.sleep(5000);
						 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

						 Thread.sleep(5000);
						 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

						 Thread.sleep(5000);
							String Question5 = s.getCell(6, row).getContents().toString();

							 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question5);

							Thread.sleep(5000);
							 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

							 Thread.sleep(5000);
							 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

							 Thread.sleep(5000);
								String Question6 = s.getCell(7, row).getContents().toString();

								 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question6);

								Thread.sleep(5000);
								 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

								 Thread.sleep(5000);
								 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

								 Thread.sleep(5000);
									String Question7 = s.getCell(8, row).getContents().toString();

									 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question7);

									Thread.sleep(5000);
									 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

									 Thread.sleep(5000);
									 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

									 Thread.sleep(5000);
										String Question8 = s.getCell(9, row).getContents().toString();

										 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question8);

										Thread.sleep(5000);
										 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

										 Thread.sleep(5000);
										 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

										 Thread.sleep(5000);
											String Question9 = s.getCell(10, row).getContents().toString();

											 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question9);

											Thread.sleep(5000);
											 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

											 Thread.sleep(5000);
											 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

											 Thread.sleep(5000);
												String Question10 = s.getCell(11, row).getContents().toString();

												 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question10);

												Thread.sleep(5000);
												 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

												 Thread.sleep(5000);
												 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

												 Thread.sleep(5000);
													String Question11 = s.getCell(12, row).getContents().toString();

													 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question11);

													Thread.sleep(5000);
													 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

													 Thread.sleep(5000);
													 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

													 Thread.sleep(5000);
														String Question12 = s.getCell(13, row).getContents().toString();

														 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question12);

														Thread.sleep(5000);
														 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

														 Thread.sleep(5000);
														 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

														 Thread.sleep(5000);
															String Question13 = s.getCell(14, row).getContents().toString();

															 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question13);

															Thread.sleep(5000);
															 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

															 Thread.sleep(5000);
															 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

															 Thread.sleep(5000);
																String Question14 = s.getCell(15, row).getContents().toString();

																 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question14);

																Thread.sleep(5000);
																 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

																 Thread.sleep(5000);
																 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

																 Thread.sleep(5000);
																	String Question15 = s.getCell(16, row).getContents().toString();

																	 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question15);

																	Thread.sleep(5000);
																	 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

																	 Thread.sleep(5000);
																	 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

																	 Thread.sleep(5000);
																		String Question16 = s.getCell(17, row).getContents().toString();

																		 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question16);

																		Thread.sleep(5000);
																		 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

																		 Thread.sleep(5000);
																		 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

																		 Thread.sleep(5000);
																			String Question17 = s.getCell(18, row).getContents().toString();

																			 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question17);

																			Thread.sleep(5000);
																			 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

																			 Thread.sleep(5000);
																			 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

																			 Thread.sleep(5000);
																				String Question18 = s.getCell(19, row).getContents().toString();

																				 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question18);

																				Thread.sleep(5000);
																				 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

																				 Thread.sleep(5000);
																				 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();

																				 Thread.sleep(5000);
																					String Question19 = s.getCell(20, row).getContents().toString();

																					 browser.findElement(By.xpath("id('questionSelection')")).sendKeys(Question19);

																					Thread.sleep(5000);
																					 browser.findElement(By.xpath("id('typeahead-1285-9208-option-0')/x:a")).click();

																					 Thread.sleep(5000);
																					 browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[4]/div[2]/div/div[2]/button")).click();



		//	Actions a = new Actions(browser);
			 //	a.click(loc).keyDown(Keys.SHIFT).sendKeys(Question1.substring(0, 3)).keyDown(Keys.SHIFT)
			 //			.sendKeys(Question1.substring(3, Question1.length())).sendKeys(Keys.RETURN);
			 //		a.perform();
			//
			// Add Question2 from drop down
			 //		Thread.sleep(5000);
			 //	String Question2 = s.getCell(3, row).getContents().toString();

			 //	a.click(loc).keyDown(Keys.SHIFT).sendKeys(Question2.substring(0, 3)).keyDown(Keys.SHIFT)
			 //			.sendKeys(Question2.substring(3, Question2.length())).sendKeys(Keys.RETURN);
			 //		a.perform();




			// Click on Save Button
			Thread.sleep(5000);
			browser.findElement(By.xpath("/html/body/div/div/ui-view/ui-view/fieldset/div/ui-view/form/div[6]/div/button"))
					.click();
		}
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





















	/*tgrhtrhrhttrhrthr */
	}
	
}
