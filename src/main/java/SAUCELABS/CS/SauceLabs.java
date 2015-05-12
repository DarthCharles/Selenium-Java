package SAUCELABS.CS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs {
	private WebDriver driver;
	  private String baseUrl;

	public SauceLabs(DesiredCapabilities capabilities) {
		super();
		try {
		    this.baseUrl = "http://csipro.isi.uson.mx/";
			this.driver =  new RemoteWebDriver(
			        new URL("http://DarthCharles:fddc5aa3-5c0e-47a1-a941-48cc635665fe@ondemand.saucelabs.com:80/wd/hub"),
			        capabilities);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getLogin() {
		driver.get(baseUrl + "/login.aspx");
		driver.findElement(By.id("txtemail")).clear();
		driver.findElement(By.id("txtemail")).sendKeys("admin");
		driver.findElement(By.id("txtpass")).clear();
		driver.findElement(By.id("txtpass")).sendKeys("admin");
		driver.findElement(By.id("Button1")).click();
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
}
