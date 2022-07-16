package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
        public WebDriver driver;
        private By addToCartList = By.id("add-to-cart-sauce-labs-backpack");
        private By removeButton = By.id("remove-sauce-labs-backpack");
        private By shoppingCart = By.id("shopping_cart_container");
        private By cartPageTitle = By.cssSelector("div[id='header_container'] span[class='title']");

        public CartPage(WebDriver driver) {
            this.driver = driver;
        }


        public WebElement getAdCartList(){

            return driver.findElement(addToCartList);
        }
        public WebElement getRemoveButton(){
            return driver.findElement(removeButton);
        }
    public WebElement getShoppingCart(){
        return driver.findElement(shoppingCart);
    }
    public WebElement getCartPageTitle(){
        return driver.findElement(cartPageTitle);
    }
    }
