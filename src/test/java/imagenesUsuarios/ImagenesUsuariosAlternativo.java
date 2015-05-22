package imagenesUsuarios;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import SELENIUM.CS.CustomDriver;

public class ImagenesUsuariosAlternativo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private CustomDriver fox = new CustomDriver();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    fox.initDriver(driver);

  }

  @Test
  public void testImagenesUsuariosNormal() throws Exception {
	fox.getLogin(driver);
	driver.findElement(By.cssSelector("span.s-nav-rootlink-blog-title")).click();
	driver.findElement(By.cssSelector("a[href='http://www.livejournal.com/editpics.bml']")).click();
    driver.findElement(By.xpath("//*[@id='upload_wrapper']/div[2]/input[2]")).sendKeys("prueba");
    driver.findElement(By.xpath("//p[@id='submit_wrapper']/button")).click();
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
