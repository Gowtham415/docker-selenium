package com.newtours.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[text()='Flight Itinerary Page']")
    private WebElement flightConfirmationHeader;

    @FindBy(css = "tbody tr:nth-child(3) td:nth-child(2) font:nth-child(1)")
    private WebElement orderAmount;

    @FindBy(id = "sign-on")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public String getFlightPrice(){
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(this.flightConfirmationHeader.getText());
        return this.orderAmount.getText();
    }
}
