package enviarMensaje;

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

public class EnviarMensajeSauceWXP {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private CustomDriver fox = new CustomDriver();
  private SauceTests sauce = new SauceTests("Enviar mensaje Windows XP");


  @Before
  public void setUp() throws Exception {
    driver = sauce.WindowsFirefoxDriver();
    fox.initDriver(driver);

  }

  @Test
  public void testEnviarMensajeWXP() throws Exception {
		fox.getLogin(driver);

    driver.get("http://www.livejournal.com/inbox/");
    driver.findElement(By.xpath("//input[@value='New Message']")).click();
    driver.findElement(By.xpath("//input[@id='msg_to']")).clear();
    driver.findElement(By.xpath("//input[@id='msg_to']")).sendKeys("DarthCharles");
    driver.findElement(By.xpath("//input[@name='msg_subject']")).clear();
    driver.findElement(By.xpath("//input[@name='msg_subject']")).sendKeys("Prueba");
    driver.findElement(By.xpath("//textarea[@name='msg_body']")).clear();
    driver.findElement(By.xpath("//textarea[@name='msg_body']")).sendKeys("Prueba");
    driver.findElement(By.xpath("//button[@value='Send']")).click();
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
