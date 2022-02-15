package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        // BROWSER => CHROME/ FIREFOX
        // HUB_HOST => localhost/ 10.01.2.3 / hostname

        String host = "localhost";
        DesiredCapabilities desiredCapabilities;

        if(System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("CHROME")){
            desiredCapabilities = DesiredCapabilities.chrome();
        }else{
            desiredCapabilities = DesiredCapabilities.firefox();
        }

        if(System.getProperty("HUB_HOST")!=null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host +":4444/wd/hub";

        this.driver = new RemoteWebDriver(new URL(completeUrl),desiredCapabilities);

//        WebDriverManager.chromedriver().setup();
//        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
