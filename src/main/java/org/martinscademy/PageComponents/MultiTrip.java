package org.martinscademy.PageComponents;

import org.martinscademy.AbstractComponent.AbstractComponent;
import org.martinscademy.AbstractComponent.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvailability {

    private By multiRadioBtn = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By modalPopUp = By.id("MultiCityModelAlert");
    private By fromLocation1 = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By toLocation1 = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By fromLocation2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By toLocation2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    private By fromLocation3 = By.id("ctl00_mainContent_ddl_originStation3_CTXT");
    private By toLocation3 = By.id("ctl00_mainContent_ddl_destinationStation3_CTXT");
    private By checkbox = By.id("ctl00_mainContent_chk_IndArm");
    private By sumbit = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {

        makeStateReady(s -> selectFirstOriginCity(reservationDetails.get("origin")));
        selectFirstDestinationCity(reservationDetails.get("destination"));
        selectSecondOriginCity(reservationDetails.get("origin2"));
        selectSecondDestinationCity(reservationDetails.get("destination2"));
        selectThirdOriginCity(reservationDetails.get("origin3"));
        selectThirdDestinationCity(reservationDetails.get("destination3"));

    }

    public void selectFirstOriginCity(String origin) {
        findElement(fromLocation1).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectFirstDestinationCity(String destination) {
        findElement(toLocation1).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    public void selectSecondOriginCity(String origin2) {
        findElement(fromLocation2).click();
        findElement(By.xpath("(//a[@value='" + origin2 + "'])[3]")).click();
    }

    public void selectSecondDestinationCity(String destination2) {
        findElement(toLocation2).click();
        findElement(By.xpath("(//a[@value='" + destination2 + "'])[4]")).click();
    }

    public void selectThirdOriginCity(String origin3) {
        findElement(fromLocation3).click();
        findElement(By.xpath("(//a[@value='" + origin3 + "'])[5]")).click();
    }

    public void selectThirdDestinationCity(String destination3) {
        findElement(toLocation3).click();
        findElement(By.xpath("(//a[@value='" + destination3 + "'])[6]")).click();
    }


    public void makeStateReady(Consumer<MultiTrip> multiTripConsumer) {
        // ALL the common prequest code
        //executed before and after the business method.
        findElement(multiRadioBtn).click();
        findElement(modalPopUp).click();
        waitForElementToDisappear(modalPopUp);
        multiTripConsumer.accept(this); // it will execute any function

    }
}
