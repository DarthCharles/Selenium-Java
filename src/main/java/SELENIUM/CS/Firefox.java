package SELENIUM.CS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	  private WebDriver driver;
	  private String baseUrl;

	public Firefox() {
		super();
	    this.driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    this.baseUrl = "http://csipro.isi.uson.mx/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void login() {
		driver.get(baseUrl + "/login.aspx");
		driver.findElement(By.id("txtemail")).clear();
		driver.findElement(By.id("txtemail")).sendKeys("Csipro.dev@gmail.com");
		driver.findElement(By.id("txtpass")).clear();
		driver.findElement(By.id("txtpass")).sendKeys("csipro");
		driver.findElement(By.id("Button1")).click();
	}
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
}

