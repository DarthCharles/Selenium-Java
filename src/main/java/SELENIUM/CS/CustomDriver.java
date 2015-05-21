package SELENIUM.CS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomDriver {


	private String baseUrl = "http://www.livejournal.com/";


	public void getLogin(WebDriver driver) {
		  driver.get(baseUrl);
		    driver.findElement(By.cssSelector("span.i-iconus.s-ljvideo-close")).click();
		    driver.findElement(By.cssSelector("a[href='http://www.livejournal.com/login.bml']")).click();
		    driver.findElement(By.id("user")).clear();
		    driver.findElement(By.id("user")).sendKeys("pruebascalidad");
		    driver.findElement(By.id("lj_loginwidget_password")).clear();
		    driver.findElement(By.id("lj_loginwidget_password")).sendKeys("Calidad123");
		    driver.findElement(By.name("action:login")).click();
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void initDriver(WebDriver driver){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


}

