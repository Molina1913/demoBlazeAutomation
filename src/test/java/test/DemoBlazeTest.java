package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.HomePageDemoblaze;
import pages.LaptopsPage;
import pages.MacBookAirPage;

public class DemoBlazeTest {
    WebDriver driver;
    HomePageDemoblaze homePageDemoblaze;
    AboutUsPage aboutUsPage;
    LaptopsPage laptopsPage;
    MacBookAirPage macBookAirPage;

    @BeforeTest
    public void beforeTest() {
        String driverPath = "src/test/java/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        homePageDemoblaze=new HomePageDemoblaze(driver,"https://demoblaze.com/");
        driver.manage().window().maximize();
        aboutUsPage=new AboutUsPage(driver);
        laptopsPage=new LaptopsPage(driver);
        macBookAirPage=new MacBookAirPage(driver);

    }
    @Test
    public void demoblazeTest(){
        homePageDemoblaze.clickOnSignUpButton();
        homePageDemoblaze.writeUserName("LuchoM");
        homePageDemoblaze.writePassword("12345");
        homePageDemoblaze.clickOnSignUp();
    }
    @Test
    public void reproduceAboutUsVideo(){
        homePageDemoblaze.clickOnAboutUs();
        aboutUsPage.clickPlayButton();
    }
    @Test
    public void buyingAnyLaptop(){
        homePageDemoblaze.clickOnLaptops();
        laptopsPage.clickOnLaptop();
        macBookAirPage.clickOnAddToCart();

    }
    @AfterTest
    public void afterTest(){
        driver.close();
    }
}
