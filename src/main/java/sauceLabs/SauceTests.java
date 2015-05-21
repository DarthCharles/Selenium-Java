package sauceLabs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceTests {
	
	public WebDriver WindowsFirefoxDriver() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
		capabilities.setCapability("version", "17");
		capabilities.setCapability("platform", Platform.XP);
		capabilities.setCapability("name", "Prueba CS 2015");
		return new RemoteWebDriver(new URL("http://DarthCharles:fddc5aa3-5c0e-47a1-a941-48cc635665fe@ondemand.saucelabs.com:80/wd/hub"), 
				capabilities);
	}
	
	public WebDriver MacSafariDriver() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities().safari();
		capabilities.setCapability("version", "44.0.2403.9");
		capabilities.setCapability("platform", Platform.MAC);
		capabilities.setCapability("name", "Prueba CS 2015");
		return new RemoteWebDriver(new URL("http://DarthCharles:fddc5aa3-5c0e-47a1-a941-48cc635665fe@ondemand.saucelabs.com:80/wd/hub"), 
				capabilities);
	}

}
