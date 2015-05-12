package SAUCELABS.CS;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SL_AgregarVehiculo {
    private WebDriver driver;
    private SauceLabs labs; 
    @Before
    public void setUp() throws Exception {
        // Choose the browser, version, and platform to test
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("name", "Agregar Vehiculo");
        capabilities.setCapability("version", "37");
        capabilities.setCapability("platform", Platform.WIN8_1);
        // Create the connection to Sauce Labs to run the tests
        this.labs = new SauceLabs(capabilities);
        this.driver = labs.getDriver();
    }

    @Test
    public void webDriver() throws Exception {
        // Make the browser get the page and check its title
    	labs.getLogin();
    	driver.findElement(By.partialLinkText("Vehículos")).click();
        driver.findElement(By.cssSelector("#listilla li:nth-child(3) a")).click();
        driver.findElement(By.id("serialTxt")).clear();
        driver.findElement(By.id("serialTxt")).sendKeys("1726152");
        driver.findElement(By.id("descripcionTxt")).clear();
        driver.findElement(By.id("descripcionTxt")).sendKeys("Nissan Tsuru");
        driver.findElement(By.id("CheckBox1")).click();
        driver.findElement(By.id("matriculaTxt")).clear();
        driver.findElement(By.id("matriculaTxt")).sendKeys("ah1g172");
        driver.findElement(By.id("comentariosTxt")).clear();
        driver.findElement(By.id("comentariosTxt")).sendKeys("Excelente Vehículo");
        driver.findElement(By.id("iColor")).click();
        driver.findElement(By.cssSelector("div.colpick_submit")).click();
        driver.findElement(By.id("odometroChk")).click();
        driver.findElement(By.id("matriculaETxt")).clear();
        driver.findElement(By.id("matriculaETxt")).sendKeys("ok");
        driver.findElement(By.id("insertBtn")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        driver.findElement(By.id("rb3")).click();
        driver.findElement(By.id("btnConsultGpo1")).click();
    
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
