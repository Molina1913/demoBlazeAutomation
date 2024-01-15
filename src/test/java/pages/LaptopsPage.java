package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaptopsPage extends BasePage{
    @FindBy(xpath = "//a[text()='MacBook air']")
    private WebElement macBookAirButton;

    public LaptopsPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnLaptop(){
        this.isElementDisplayed(macBookAirButton);
        this.macBookAirButton.click();
    }
}
