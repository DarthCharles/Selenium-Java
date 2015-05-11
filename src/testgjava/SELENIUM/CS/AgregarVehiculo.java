package SELENIUM.CS;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AgregarVehiculo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  Firefox fox = new Firefox();


  @Before
  public void setUp() throws Exception {
		driver = fox.getDriver();
  }

  @Test
  public void testAgregarVehiculo() throws Exception {
    fox.login();
    driver.findElement(By.id("listVehiculos")).click();
    driver.findElement(By.cssSelector("#listilla li:nth-child(3) a")).click();
    driver.findElement(By.id("serialTxt")).clear();
    driver.findElement(By.id("serialTxt")).sendKeys("1726152");
    driver.findElement(By.id("descripcionTxt")).clear();
    driver.findElement(By.id("descripcionTxt")).sendKeys("Nissan Tsuru");
    driver.findElement(By.id("CheckBox1")).click();
    driver.findElement(By.id("matriculaTxt")).clear();
    driver.findElement(By.id("matriculaTxt")).sendKeys("ah1g172");
    driver.findElement(By.id("comentariosTxt")).clear();
    driver.findElement(By.id("comentariosTxt")).sendKeys("Excelente Vehículo");
    driver.findElement(By.id("iColor")).click();
    driver.findElement(By.cssSelector("div.colpick_submit")).click();
    driver.findElement(By.id("odometroChk")).click();
    driver.findElement(By.id("matriculaETxt")).clear();
    driver.findElement(By.id("matriculaETxt")).sendKeys("ok");
    driver.findElement(By.id("insertBtn")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
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
