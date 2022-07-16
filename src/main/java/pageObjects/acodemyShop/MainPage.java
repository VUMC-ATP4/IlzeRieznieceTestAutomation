package pageObjects.acodemyShop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage {
   public WebDriver driver; // obligati jabut katra page objekta, pec tam uzgenere konstruktoru

    public MainPage(WebDriver driver) {
        this.driver = driver; // konstruktors
    }
    private By searchInputField = By.id("woocommerce-product-search-field-0"); // jauzraksta geteris, lai var stradat testa
    private By searchResults = By.className("product");

    public WebElement getSearchInputField() {
        return driver.findElement(searchInputField);
    }

    public List<WebElement> getSearchResults () {
        return driver.findElements(searchResults);
    }

    public void searchProduct(String searchParameter) {
        getSearchInputField().clear(); // jebkura laika pirms meklesanas visus tekstus iztiris no meklesanas lauka
        getSearchInputField().sendKeys(searchParameter); // ieraksta tekstu meklesanas lauka
        new Actions(driver).sendKeys(Keys.ENTER).perform();

    }

}
