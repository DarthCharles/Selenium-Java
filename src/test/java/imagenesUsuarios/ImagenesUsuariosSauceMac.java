package imagenesUsuarios;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import sauceLabs.SauceTests;
import SELENIUM.CS.CustomDriver;;

public class ImagenesUsuariosSauceMac {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private CustomDriver fox = new CustomDriver();
  private SauceTests sauce = new SauceTests("Editar imagen OSX");


  @Before
  public void setUp() throws Exception {
	driver = sauce.MacSafariDriver();
    baseUrl = "http://www.livejournal.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    fox.initDriver(driver);

  }

  @Test
  public void testImagenesUsuariosMac() throws Exception {
	fox.getLogin(driver);
	driver.findElement(By.cssSelector("span.s-nav-rootlink-blog-title")).click();
	driver.findElement(By.cssSelector("a[href='http://www.livejournal.com/editpics.bml']")).click();
    driver.findElement(By.xpath("//*[@id='upload_wrapper']/div[2]/input[2]")).sendKeys("http://upload.wikimedia.org/wikipedia/en/5/5c/Seleniumlogo.png");
    driver.findElement(By.xpath("//p[@id='submit_wrapper']/button")).click();
    driver.findElement(By.id("createbtn")).click();
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
