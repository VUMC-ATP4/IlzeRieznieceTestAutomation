package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutComplete = By.cssSelector("#header_container > div.header_secondary_container > span");
    private By backHomeButton = By.id("back-to-products");

    public WebElement getCheckoutComplete(){
        return driver.findElement(checkoutComplete);
    }

    public WebElement getBackHomeButton(){
        return driver.findElement(backHomeButton);
    }

}
