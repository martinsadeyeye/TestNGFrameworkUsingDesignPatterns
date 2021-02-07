package org.martinscademy.AbstractComponent;

import org.martinscademy.PageComponents.MultiTrip;
import org.martinscademy.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {

    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvailability createStrategy(String strategyType) {
        if ( strategyType.equalsIgnoreCase("multitrip") ) {


            return new MultiTrip(driver, sectionElement);
        }
        if ( strategyType.equalsIgnoreCase("roundtrip") ) {
            return new RoundTrip(driver, sectionElement);

        }
        return null;
    }
}
