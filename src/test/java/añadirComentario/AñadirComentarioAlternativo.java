package añadirComentario;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import SELENIUM.CS.CustomDriver;

public class AñadirComentarioAlternativo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private CustomDriver fox = new CustomDriver();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.livejournal.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    fox.initDriver(driver);

  }

  @Test
  public void testAnAdirComentario() throws Exception {
		fox.getLogin(driver);

    driver.findElement(By.xpath("//html[@id='js']/body/div[4]/header/div/nav/ul[2]/li/a/span")).click();
    driver.findElement(By.xpath("//*[@id='entry-pruebascalidad-1600']/footer/div[1]/ul/li[2]/a/span")).click();
    driver.findElement(By.xpath("//button[@name='submitpost']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
