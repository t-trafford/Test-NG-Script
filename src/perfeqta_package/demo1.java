package perfeqta_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/

import org.testng.annotations.Test;




public class demo1 {
	 private WebDriver browser;
	    private String baseUrl;
	    @Test
	    public void abcd() throws Exception {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Windows\\Automation\\chromedriver_2.26.exe");
			browser = new ChromeDriver();
	        baseUrl = "http://www.goal.com/en/match/barcelona-vs-valencia/2283184/report";
	        browser.get(baseUrl);
	        browser.manage().window().maximize();
	        Thread.sleep(3000);
	        browser.quit();

}

}
