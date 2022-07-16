package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    private By firstNameInputField = By.id("first-name");
    private By lastNameInputField = By.id("last-name");
    private By zipCodeInputField = By.id("postal-code");

    private By continueButton = By.id("continue");

    private By errorText = By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error");

    public WebElement getFirstNameInputField(){
        return driver.findElement(firstNameInputField);
    }
    public WebElement getLastNameInputField(){
        return driver.findElement(lastNameInputField);
    }
    public WebElement getZipCodeInputField(){
        return driver.findElement(zipCodeInputField);
    }
    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }

    public WebElement getErrorText(){
        return driver.findElement(errorText);
    }
}
