package com.newtours.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passCount")
    private WebElement passengerCount;

    @FindBy(name = "fromPort")
    private WebElement sourcePort;

    @FindBy(name = "fromMonth")
    private WebElement fromMonth;

    @FindBy(name = "fromDay")
    private WebElement fromDay;

    @FindBy(name = "toPort")
    private WebElement toPort;

    @FindBy(name = "toMonth")
    private WebElement toMonth;

    @FindBy(name = "toDay")
    private WebElement toDay;

    @FindBy(name = "findFlights")
    private WebElement findFlights;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }
    
    public void selectPassengers(String noOfPassengers){
        this.wait.until(ExpectedConditions.visibilityOf(passengerCount));
        Select passengerSelect = new Select(this.passengerCount);
        passengerSelect.selectByValue(noOfPassengers);
    }

    public void goToFindFlightsPage(){
        this.findFlights.click();
    }
}
