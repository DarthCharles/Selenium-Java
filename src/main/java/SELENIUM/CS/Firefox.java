package SELENIUM.CS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {


	private String baseUrl = "https://mural.ly/";


	public void getLogin(WebDriver driver) {
		  driver.get(baseUrl);

	}

	public void initDriver(WebDriver driver){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


}

