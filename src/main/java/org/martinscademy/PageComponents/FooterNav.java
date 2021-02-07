package org.martinscademy.PageComponents;

import org.martinscademy.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {

    WebDriver driver;
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        // when you inherit parent class, you should invoke parent class
        // constructor in your own child classs

    }

    public String getFlightAttribute() {
        return findElement(flights).getAttribute("class");
        //driver.findElement(flights).click();
    }

    public int getLinkCount() {
        return findElements(links).size();
    }
}