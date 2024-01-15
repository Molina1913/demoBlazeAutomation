package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(css = ".btn-success")
    private WebElement placeOrderBtn;
    @FindBy(id = "name")
    private WebElement nameInput;
    @FindBy(id = "country")
    private WebElement countryInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "card")
    private WebElement creditCardInput;
    @FindBy(id = "month")
    private WebElement monthInput;
    @FindBy(id = "year")
    private WebElement yearInput;
    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseBtn;
    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okBtn;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPlaceOrder(){
        isElementDisplayed(placeOrderBtn);
        this.placeOrderBtn.click();
    }
    public void writeName(String name){
        this.nameInput.sendKeys(name);
    }
    public void writeCountry(String country){
        this.countryInput.sendKeys(country);
    }
    public void writeCity(String city){
        this.cityInput.sendKeys(city);
    }
    public void writeCreditCard(String number){
        this.creditCardInput.sendKeys(number);
    }
    public void writeMonth(String month){
        this.monthInput.sendKeys(month);
    }
    public void writeYear(String year){
        this.yearInput.sendKeys(year);
    }
    public void clickOnPurchaseBtn(){
        this.purchaseBtn.click();
    }

    public WebElement getPlaceOrderBtn() {
        return placeOrderBtn;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getCountryInput() {
        return countryInput;
    }

    public WebElement getCityInput() {
        return cityInput;
    }

    public WebElement getCreditCardInput() {
        return creditCardInput;
    }

    public WebElement getMonthInput() {
        return monthInput;
    }

    public WebElement getYearInput() {
        return yearInput;
    }

    public WebElement getPurchaseBtn() {
        return purchaseBtn;
    }

}
