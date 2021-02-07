package org.martinscademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

    File classpathRoot;
    File driverPath;

    public WebDriver initializeDriver() {

        classpathRoot = new File(System.getProperty("user.dir"));
        driverPath = new File(classpathRoot, "/BrowserDriver/");
        System.out.println("launching chrome browser");
        //declare the chrome driver from the project location
        System.setProperty("webdriver.chrome.driver", driverPath + "/" + "chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\MARTINS\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;

        /*     //create object of chrome options
        ChromeOptions options = new ChromeOptions();
        //add the headless argument
        options.addArguments("headless");
        //pass the options parameter in the Chrome driver declaration
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();*/

     /*   //set the path of the Gecko driver as per the location on local machine
         System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        //Set Firefox Headless mode as TRUE
         FirefoxOptions options = new FirefoxOptions();
         options.setHeadless(true);

        //pass the options parameter in the Firefox driver declaration
        WebDriver driver = new FirefoxDriver(options);*/
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        // Convert the Json File to Json String
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }
}
