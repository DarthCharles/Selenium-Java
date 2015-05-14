package SELENIUM.CS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {


	private String baseUrl = "https://mural.ly/";


	public void getLogin(WebDriver driver) {
		  driver.get(baseUrl);
		    driver.findElement(By.cssSelector("a.login:nth-child(5)")).click();   
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("cds.pruebas@gmail.com");
		    driver.findElement(By.xpath("//button")).click();
		    driver.findElement(By.id("Passwd")).clear();
		    driver.findElement(By.id("Passwd")).sendKeys("calidad123");
		    driver.findElement(By.id("signIn")).click();
	}
	public void initDriver(WebDriver driver){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


}

