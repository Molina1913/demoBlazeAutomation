package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageDemoblaze extends BasePage {
    @FindBy(id = "signin2")
    private WebElement signUpButton;
    @FindBy(id = "sign-username")
    private WebElement signUserName;
    @FindBy(id = "sign-password")
    private WebElement signPassword;
    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUp;
    @FindBy(xpath = "//a[text()='About us']")
    private WebElement aboutUsButton;
    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptopsButton;
    @FindBy(xpath = "//a[text()='Cart']")
    private WebElement cartButton;


    public HomePageDemoblaze(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public void clickOnSignUpButton(){
        this.signUpButton.click();
    }
    public void writeUserName(String userName){
        this.isElementDisplayed(signUserName);
        this.signUserName.sendKeys(userName);
    }
    public void writePassword(String password){
        this.signPassword.sendKeys(password);
    }
    public void clickOnSignUp(){
        this.signUp.click();
    }
    public void clickOnAboutUs(){
        this.aboutUsButton.click();
    }
    public void clickOnLaptops(){
        this.laptopsButton.click();
    }
    public void clickOnCart(){
        this.cartButton.click();
    }
}
