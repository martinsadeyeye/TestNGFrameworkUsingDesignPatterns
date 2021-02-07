package org.martinscademy;

import org.martinscademy.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {

    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp() {

        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());

        //travelHomePage.setBookingStrategy(new RoundTrip(driver,sectionElement));// Factory Design Patter solve this issue of creating object in a test class
        travelHomePage.setBookingStrategy("multitrip");//roundtrip //multitrip
    }

    @DataProvider
    //HashMap, DataProvider, Json, Jackson Library, List
    public Object[][] getData() throws IOException {
        /*HashMap<String, String> reservationDetails = new HashMap<String, String>();
        reservationDetails.put("origin", "MAA");
        reservationDetails.put("destination", "HYD");
        reservationDetails.put("origin2", "BLR");
        reservationDetails.put("destination2", "GOI");
        reservationDetails.put("origin3", "JLR");
        reservationDetails.put("destination3", "DEL");

        HashMap<String, String> reservationDetails1 = new HashMap<String, String>();
        reservationDetails1.put("origin", "MAA");
        reservationDetails1.put("destination", "HYD");
        reservationDetails1.put("origin2", "BLR");
        reservationDetails1.put("destination2", "GOI");
        reservationDetails1.put("origin3", "JLR");
        reservationDetails1.put("destination3", "DEL");

        List<HashMap<String, String>> l = new ArrayList();
        l.add(reservationDetails);
        l.add(reservationDetails1);
*/

        List<HashMap<String, String>> l = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//martinscademy//Dataloads//reservationDetails.json");
        return new Object[][]
                {
                        {l.get(0)}, {l.get(1)}
                };
    }

}
