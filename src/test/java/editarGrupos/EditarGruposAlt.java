package editarGrupos;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import SELENIUM.CS.CustomDriver;

public class EditarGruposAlt {
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
	public void testEditGroups() throws Exception {
		fox.getLogin(driver);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("li.s-nav-item:nth-child(2) > a:nth-child(1)"))).build().perform();
		driver.findElement(By.cssSelector(".s-nav-item-editgroups > a:nth-child(1)")).click();
		new Select(driver.findElement(By.id("list_groups"))).selectByVisibleText("Familia");
		// ERROR: Caught exception [ERROR: Unsupported command [answerOnNextPrompt | Familia | ]]
		driver.findElement(By.id("renameGroup")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [getPrompt |  | ]]
		driver.findElement(By.xpath("//button[@value='Guardar cambios']")).click();
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
