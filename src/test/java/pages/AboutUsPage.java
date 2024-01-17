package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage {
    @FindBy(css = ".vjs-big-play-button")
    private WebElement playButton;
    @FindBy(css = "button.btn.btn-secondary")
    private WebElement closeButton;
    public AboutUsPage(WebDriver driver) {
        super(driver);
    }
    public void clickPlayButton(){
        this.isElementDisplayed(playButton);
        this.playButton.click();
    }
    public void clickOnCloseBtn(){
        this.isElementDisplayed(closeButton);
        this.closeButton.click();
    }
}
