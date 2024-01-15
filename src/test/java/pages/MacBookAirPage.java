package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacBookAirPage extends BasePage{
    @FindBy(css = ".btn-lg")
    private WebElement addToCartButton;
    public MacBookAirPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnAddToCart(){
        this.isElementDisplayed(addToCartButton);
        this.addToCartButton.click();
    }
}
