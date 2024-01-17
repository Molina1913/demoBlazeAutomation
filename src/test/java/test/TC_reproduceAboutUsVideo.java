package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.HomePageDemoblaze;

public class TC_reproduceAboutUsVideo {
    WebDriver driver;
    HomePageDemoblaze homePageDemoblaze;
    AboutUsPage aboutUsPage;

    @BeforeTest
    public void setUp() {
        String url = "https://demoblaze.com/";
        String driverPath = "src/test/java/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        homePageDemoblaze = new HomePageDemoblaze(driver, url);
        driver.manage().window().maximize();
        aboutUsPage = new AboutUsPage(driver);
    }

    @Test
    public void reproduceAboutUsVideo() {
        //Step 1. Click on About us
        homePageDemoblaze.clickOnAboutUs();
        //Step 2. Click on play button
        aboutUsPage.clickPlayButton();
        //Step 3. Click on close button
        aboutUsPage.clickOnCloseBtn();
    }
    @AfterTest
    public void afterTest(){
        driver.close();
    }
}
