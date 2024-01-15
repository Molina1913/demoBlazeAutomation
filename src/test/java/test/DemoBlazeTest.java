package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

public class DemoBlazeTest {
    WebDriver driver;
    HomePageDemoblaze homePageDemoblaze;
    AboutUsPage aboutUsPage;
    LaptopsPage laptopsPage;
    MacBookAirPage macBookAirPage;
    CartPage cartPage;
    Alert alert;
    WebDriverWait wait;


    @BeforeTest
    public void beforeTest() {
        String url="https://demoblaze.com/";
        String driverPath = "src/test/java/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        homePageDemoblaze=new HomePageDemoblaze(driver,url);
        driver.manage().window().maximize();
        aboutUsPage=new AboutUsPage(driver);
        laptopsPage=new LaptopsPage(driver);
        macBookAirPage=new MacBookAirPage(driver);
        cartPage=new CartPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    /*
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
     */


    @Test
    @Parameters({"name","country","city","number","month", "year"})
    public void buyingAnyLaptop(@Optional("NA")String name, String country, String city, String number, String month, String year){
        //Step 1. click on laptops
        homePageDemoblaze.clickOnLaptops();
        //Step 2. select the laptop to buy
        laptopsPage.clickOnLaptop();
        //Step 3. add to cart the laptop
        macBookAirPage.clickOnAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        alert=driver.switchTo().alert();
        alert.accept();
        //Step 4. click on cart
        homePageDemoblaze.clickOnCart();
        //Step 5. go to cart page and place order
        cartPage.clickOnPlaceOrder();
        //Step 6. filling place order form
        wait.until(ExpectedConditions.visibilityOf(cartPage.getNameInput()));
        cartPage.writeName(name);
        cartPage.writeCountry(country);
        cartPage.writeCity(city);
        cartPage.writeCreditCard(number);
        cartPage.writeMonth(month);
        cartPage.writeYear(year);
        cartPage.clickOnPurchaseBtn();

        String actualValue=driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText();
        String expectedValue="Thank you for your purchase!";

        Assert.assertEquals(actualValue, expectedValue);
    }
    @AfterTest
    public void afterTest(){
        driver.close();
    }
}
