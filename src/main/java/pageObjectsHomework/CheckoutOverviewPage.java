package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    private By inventoryItem = By.cssSelector("#item_4_title_link > div");
    private By paymentInformation = By.cssSelector("#checkout_summary_container > div > div.summary_info > div:nth-child(2)");
    private By shippingInformation = By.cssSelector("#checkout_summary_container > div > div.summary_info > div:nth-child(4)");
    private By itemTotal = By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label");
    private By tax = By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_tax_label");
    private By total = By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_total_label");
    private By finishButton = By.id("finish");

    public WebElement getInventoryItem(){
        return driver.findElement(inventoryItem);
    }
    public WebElement getPaymentInformation(){
        return driver.findElement(paymentInformation);
    }
    public WebElement getShippingInformation(){
        return driver.findElement(shippingInformation);
    }
    public WebElement getItemTotal(){
        return driver.findElement(itemTotal);
    }
    public WebElement getTax(){
        return driver.findElement(tax);
    }
    public WebElement getTotal(){
        return driver.findElement(total);
    }
    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }
}
