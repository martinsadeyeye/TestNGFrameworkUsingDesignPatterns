package org.martinscademy.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {
    //abstract -  may have method implemented or not
    WebElement sectionElement;
    WebDriver driver;


    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.driver = driver;
        this.sectionElement = driver.findElement(sectionElement);
    }


    public WebElement findElement(By findElement) {

        return sectionElement.findElement(findElement);
    }

    public List<WebElement> findElements(By findElement) {

        return sectionElement.findElements(findElement);
    }

    public void waitForElementToDisappear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
}
