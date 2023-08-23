package com.framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
    	 ChromeOptions options = new ChromeOptions();
         driver = new ChromeDriver(options);
    	
//   	 FirefoxOptions options = new FirefoxOptions();
//     driver = new FirefoxDriver(options);
    	
    	
         driver.manage().window().maximize();
         wait = new WebDriverWait(driver, Duration.ofSeconds(120));
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
