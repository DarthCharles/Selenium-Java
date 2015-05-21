package sauceLabs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceTests {

	DesiredCapabilities capabilities;
	URL url;
	String name;

	public SauceTests(String name){
		try{
			this.url = new URL("http://DarthCharles:fddc5aa3-5c0e-47a1-a941-48cc635665fe@ondemand.saucelabs.com:80/wd/hub");
			this.name = name;
		}catch(MalformedURLException e){
			System.out.println(e.getCause());
		}
	}
	public void setCapabilities(DesiredCapabilities navegador, 
			String version, 
			Platform platform,
			String name){
		capabilities = navegador;
		capabilities.setCapability("version", version);
		capabilities.setCapability("platform", platform);
		capabilities.setCapability("name", this.name );
	}

	public WebDriver WindowsFirefoxDriver() throws MalformedURLException{
		this.setCapabilities(DesiredCapabilities.firefox(), "17", Platform.XP, this.name);
		return new RemoteWebDriver(url, capabilities);
	}

	public WebDriver MacSafariDriver() throws MalformedURLException{
		this.setCapabilities(DesiredCapabilities.safari(), "8", Platform.YOSEMITE, this.name);
		return new RemoteWebDriver(url, capabilities);
	}

}
