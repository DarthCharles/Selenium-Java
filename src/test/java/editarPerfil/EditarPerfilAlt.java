package editarPerfil;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import SELENIUM.CS.Firefox;

public class EditarPerfilAlt {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private Firefox fox = new Firefox();


	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		fox.initDriver(driver);
	}

	@Test
	public void testEditarPerfil() throws Exception {
		fox.getLogin(driver);
		driver.findElement(By.xpath("//html[@id='js']/body/div[4]/header/div/nav/ul[2]/li/a/span")).click();
		driver.findElement(By.cssSelector(".w-cs-menu--primary")).click();
		driver.findElement(By.linkText("Account")).click();
	    driver.findElement(By.linkText("Edit profile")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("");
	    driver.findElement(By.name("year")).clear();
	    driver.findElement(By.name("year")).sendKeys("");
	    driver.findElement(By.cssSelector("textarea[name=\"interests\"]")).clear();
	    driver.findElement(By.cssSelector("textarea[name=\"interests\"]")).sendKeys("");
	    driver.findElement(By.id("written_state")).clear();
	    driver.findElement(By.id("written_state")).sendKeys("");
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("");
	    driver.findElement(By.cssSelector("button.b-flatbutton")).click();

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
