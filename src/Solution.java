
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class Solution {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","/Users/dishant/Desktop/geckodriver/geckodriver");
	  //System.setProperty("webdriver.chrome.driver","/Users/dishant/Desktop/chrome/chromedriver");
    driver = new FirefoxDriver();
	//driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   
  }

  @Test
  public void testSolution() throws Exception {
    driver.get("https://www.aircanada.com/ca/en/aco/home.html");

    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CANADA'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find Flights'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View Eligible Routes'])[1]/following::span[1]")).click();

    driver.findElement(By.id("origin_R_0")).sendKeys("YVR");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Vancouver'])[3]/following::span[2]")).click();
 
    driver.findElement(By.id("destination_R_0")).sendKeys("Tor");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='YYZ'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Departure DD/MM/YYYY'])[1]/following::span[1]")).click();


    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DEPART'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("/html/body/div[8]/div[1]/div[1]/table/tbody/tr[4]/td[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RETURN'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("/html/body/div[8]/div[1]/div[1]/table/tbody/tr[4]/td[7]/span[1]")).click();
    driver.findElement(By.id("calendarSelectActionBtn")).click();

    driver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[1]/div[2]/div[3]/div/div[2]/div[1]/div/form/fieldset/div[3]/div[3]/div[3]/input")).click();
    driver.findElement(By.xpath("/html/body/div[3]/div[2]/main/div[1]/div[4]/app-faredriven/div/div[1]/div/div/bound-grid/div/div[2]/div/ul/li[4]/flight-row/div/div/div/bound-cabin[2]/button/div/div/div[2]/div[2]")).click();
    
    
    
   driver.quit();
  }

  @AfterMethod
public void tearDown() throws Exception {
    
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}


