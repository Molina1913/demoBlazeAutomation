package test;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePageDemoblaze;

public class TC_login {
    WebDriver driver;
    HomePageDemoblaze homePageDemoblaze;
    Alert alert;
    @BeforeTest
    public void setUp(){
        String url="https://demoblaze.com/";
        String driverPath = "src/test/java/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        homePageDemoblaze=new HomePageDemoblaze(driver,url);
    }
    @Test
    @Parameters({"userName", "password"})
    public void demoblazeTest(String userName, String password){
        //Step 1. click on sign up
        homePageDemoblaze.clickOnSignUpButton();
        //Step 2. write username, password and click on sign up
        homePageDemoblaze.writeUserName(userName);
        homePageDemoblaze.writePassword(password);
        homePageDemoblaze.clickOnSignUp();
        //Step 3. validate that alert contains "This user already exists".
        alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equalsIgnoreCase("This user already exist."));
        alert.accept();
    }
    @AfterTest
    public void afterTest(){
        driver.close();
    }
}
