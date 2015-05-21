package editarPerfil;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import sauceLabs.SauceTests;
import SELENIUM.CS.CustomDriver;

public class EditarPerfilSauceWXP {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private CustomDriver fox = new CustomDriver();
	private SauceTests sauce = new SauceTests("Editar Perfil Windows XP");

	@Before
	public void setUp() throws Exception {
		driver = sauce.WindowsFirefoxDriver();
	    fox.initDriver(driver);
	}

	@Test
	public void testEditarPerfil() throws Exception {
		fox.getLogin(driver);
		driver.findElement(By.xpath("//html[@id='js']/body/div[4]/header/div/nav/ul[2]/li/a/span")).click();
	    driver.get(fox.getBaseUrl() + "/manage/settings/");
		driver.findElement(By.xpath("//*[@id='settings_left']/div[1]/div/div/table/tbody/tr[1]/td[2]/span[2]/a")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("pruebascalidad1");
	    driver.findElement(By.name("year")).clear();
	    driver.findElement(By.name("year")).sendKeys("1989");
	    driver.findElement(By.cssSelector("textarea[name=\"interests\"]")).clear();
	    driver.findElement(By.cssSelector("textarea[name=\"interests\"]")).sendKeys("Calidad del Software.");
	    driver.findElement(By.id("written_state")).clear();
	    driver.findElement(By.id("written_state")).sendKeys("Cádiz");
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("Puerto Real");
	    driver.findElement(By.cssSelector("button.b-flatbutton")).click();

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
