package SELENIUM.CS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {


	private String baseUrl = "http://csipro.isi.uson.mx/";


	public void getLogin(WebDriver driver) {
		driver.get(baseUrl + "/login.aspx");
		driver.findElement(By.id("txtemail")).clear();
		driver.findElement(By.id("txtemail")).sendKeys("Csipro.dev@gmail.com");
		driver.findElement(By.id("txtpass")).clear();
		driver.findElement(By.id("txtpass")).sendKeys("csipro");
		driver.findElement(By.id("Button1")).click();
	}
	public void initDriver(WebDriver driver){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


}

