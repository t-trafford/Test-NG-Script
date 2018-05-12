package perfeqta_package;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/




public class smartalert {
	  private WebDriver browser;
      private String baseUrl;
      @Test
      public void abcd() throws Exception {
          System.setProperty("webdriver.chrome.driver", "/Users/Tanaybhatt/Documents/TEST NG for Mac/chromedriver");
          browser = new ChromeDriver();
          baseUrl = "http://www.goal.com/en/match/barcelona-vs-valencia/2283184/report";
          browser.get(baseUrl);
          Thread.sleep(3000);
          browser.manage().window().maximize();
          Thread.sleep(3000);
          browser.quit();
}


}










