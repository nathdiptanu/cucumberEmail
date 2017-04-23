package cucumberTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
 
public class SeleniumTest {
		private static WebDriver driver = null;
	public static void main(String[] args) {
		
        driver = new HtmlUnitDriver();
 
      
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
       
        driver.get("https://www.google.co.in");
        System.out.println("Opened Browser");
        
 
        driver.findElement(By.xpath("//*[@id='lst-ib']")).click();
        System.out.println("Opened Browser and clicked");
 
        driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("testuser_1"); 
        System.out.println("Opened Browser and clicked and send keys");
        
        System.out.println("Test Successfully");
 
       
       
        driver.quit();
 
	}
 
}