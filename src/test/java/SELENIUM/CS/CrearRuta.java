package SELENIUM.CS;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CrearRuta {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  Firefox fox = new Firefox();

  @Before
  public void setUp() throws Exception {
		driver = new FirefoxDriver();
		fox.initDriver(driver);
  }

  @Test
  public void testCrearRuta() throws Exception {
	fox.getLogin(driver);
    driver.findElement(By.id("listRutas")).click();
    driver.findElement(By.cssSelector("#listilla33 li:nth-child(1) a")).click();
    driver.findElement(By.cssSelector("a[href='RutasAgregar.aspx']")).click();
    driver.findElement(By.cssSelector("i[class='fa fa-pencil fa-lg']")).click();
    driver.findElement(By.xpath("//div[@id='map']/div/div/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='map']/div/div/div[2]")).click();
    driver.findElement(By.id("guardarRuta")).click();
    driver.findElement(By.id("nuevaRutaNombre")).clear();
    driver.findElement(By.id("nuevaRutaNombre")).sendKeys("Prueba ruta 1");
    driver.findElement(By.id("descripcionRuta")).clear();
    driver.findElement(By.id("descripcionRuta")).sendKeys("Ruta");
    driver.findElement(By.id("nunca")).click();
    driver.findElement(By.id("botonGuardarRegla")).click();
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
