package org.martinscademy;

import org.martinscademy.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DemoTest {

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MARTINS\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());

        //travelHomePage.setBookingStrategy(new RoundTrip(driver,sectionElement));// Factory Design Patter solve this issue of creating object in a test class
        travelHomePage.setBookingStrategy("roundtrip");//roundtrip //multitrip

    }

    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> reservationDetails = new HashMap<String, String>();
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

        return new Object[][]
                {
                        {reservationDetails}, {reservationDetails}
                };
    }

}
