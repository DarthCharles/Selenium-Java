package nuevaEntrada;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import sauceLabs.SauceTests;
import SELENIUM.CS.Firefox;



public class NuevaEntradaSauceWXP {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private Firefox fox = new Firefox();
	private SauceTests sauce = new SauceTests("Nueva Entrada");



	@Before
	public void setUp() throws Exception {
		driver = sauce.WindowsFirefoxDriver();
	    fox.initDriver(driver);
	}

	@Test
	public void testAgregarEntrada() throws Exception {
		fox.getLogin(driver);
		driver.findElement(By.xpath("//html[@id='js']/body/div[4]/header/div/nav/ul[2]/li/a/span")).click();
        driver.get(fox.getBaseUrl() + "/update.bml");
		driver.findElement(By.id("subject")).clear();
		driver.findElement(By.id("subject")).sendKeys("Nueva Entrada6");
		driver.findElement(By.id("body")).clear();
		driver.findElement(By.id("body")).sendKeys("Hola esta es una nueva!!!");
		driver.findElement(By.name("action:update")).click();
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
