package org.martinscademy.PageObjects;

import org.martinscademy.AbstractComponent.SearchFlightAvailability;
import org.martinscademy.AbstractComponent.StrategyFactor;
import org.martinscademy.PageComponents.FooterNav;
import org.martinscademy.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {

    By sectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFlightAvailability searchFlightAvailability;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver, headerNavSectionElement);
    }


    public FooterNav getFooterNav() {
        return new FooterNav(driver, sectionElement);
    }


    public void setBookingStrategy(String strategyType) {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvailability = strategyFactor.createStrategy(strategyType);

        this.searchFlightAvailability = searchFlightAvailability; // so that it can be accessible accross
    }

    public void checkAvail(HashMap<String, String> reservationDetails) {

        searchFlightAvailability.checkAvail(reservationDetails);
    }

    public String getTitle() {
        System.out.println("Hello Martins");
        return driver.getTitle();
    }

}
