package SELENIUM.CS;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ConsultarTiempoReal {
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	Firefox fox = new Firefox();

	@Before
	public void setUp() throws Exception {
		driver = fox.getDriver();
	}

	@Test
	public void testConsultaTiempoReal() throws Exception {
		fox.login();
		driver.findElement(By.cssSelector("ul.nav.nav-sidebar > li > a")).click();
		driver.findElement(By.cssSelector("ul.list-inline.elemHistoricos > li > div.dropdown > #dropdownMenu1")).click();
		driver.findElement(By.id("allGroups")).click();
		driver.findElement(By.id("getTiempoReal")).click();

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
