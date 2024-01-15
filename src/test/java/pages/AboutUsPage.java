package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage {
    @FindBy(css = ".vjs-big-play-button")
    private WebElement playButton;
    public AboutUsPage(WebDriver driver) {
        super(driver);
    }
    public void clickPlayButton(){
        this.isElementDisplayed(playButton);
        this.playButton.click();
    }
}
