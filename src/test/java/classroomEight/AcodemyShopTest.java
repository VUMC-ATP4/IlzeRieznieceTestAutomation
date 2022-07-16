package classroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.acodemyShop.MainPage;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AcodemyShopTest {
    WebDriver driver;
    WebDriverWait wait;
    public final String ACODEMY_SHOP_URL = "https://shop.acodemy.lv/";

    @BeforeMethod
    public void setUpBrowser() {
        System.out.println("Pirms testa");
        //driver = new ChromeDriver(); // atvers web pirms katra testa, tests notiek lokali uz Chromedriver
        ChromeOptions chromeOptions = new ChromeOptions(); // pievieno testu remote, tests notiks serveri
//     chromeOptions.setCapability("browserVersion", "103");
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("se:name", "My simple test");
       // driver = new RemoteWebDriver(new URL("http://192.168.10.10:4444"), chromeOptions);
        driver.manage().window().maximize(); // atver web pilna loga
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // tiesha gaidisana
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// gaidis 10 sek uz katru elementu; netiesa gaidisana
    }

    @AfterMethod
    public void tearDownBrowser() {
        System.out.println("Pec testa");
        driver.close(); // aizvers web pec katra testa
    }

    @Test
    public void searchForItemTest() {
        driver.get(ACODEMY_SHOP_URL);
        System.out.println("DEBUG LINE"); // ja paradas sarkanais punkts, var uzspiest nevis run testu bet debug
        MainPage mainPage = new MainPage(driver);//izveido objektu, datus nemot no page objekt lapas
        //nakamas linijas var aizvietot, vienreiz uzrakstot page objekt lapa metodi
        //mainPage.getSearchInputField().sendKeys("Beanie"); // ieraksta tekstu meklesanas lauka
       // new Actions(driver).sendKeys(Keys.ENTER).perform(); // jauna darbiba, spiest enter; perform nozime, ka izpildis. darbibas var but vairakas
        mainPage.searchProduct("Beanie"); // ja ir metode objektpage lapa, var rakstit vienu liniju
       // mainPage.searchProduct("Tshirt");
        System.out.println("Search results count: " + mainPage.getSearchResults().size()); // parbauda, cik atrasto rezultatu lapa
        Assert.assertEquals(mainPage.getSearchResults().size(), 2);// ari parbauda aktualo ar atrasto rezultatu
        List<WebElement> searchResults = mainPage.getSearchResults(); //dabun sarakstu ar atrastiem objektiem
        for (WebElement element : searchResults) {
            System.out.println(element.findElement(By.cssSelector("h2")).getText()); // atrod elementus, ieks ta mekle citus elementus
        } // for cikls veic noraditas darbibas ar visam atrastajam precem

                System.out.println("DEBUG LINE");

    }

    @Test
    public void searchForItemTest2() {
        driver.get(ACODEMY_SHOP_URL);
        System.out.println("DEBUG LINE");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Hoodie");
        System.out.println("Search results count: " + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(), 3);
        System.out.println("DEBUG LINE");

    }

    @Test
    public void switchTabTest() {
       driver.get("https://www.w3schools.com/"); // atver lapu
        System.out.println(driver.getWindowHandles().size());
       driver.findElement(By.id("accept-choices")).click(); // apstiprina cookies
       driver.findElement(By.cssSelector("a[title='W3Schools on LinkedIn']")).click(); // nospiez uz LinkedIn
        //ka parslegties no Tabiem
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // saraksts ar tabiem
        driver.switchTo().window(tabs.get(1)); // liek parslegties uz otro Tab
        System.out.println(driver.getTitle()); // nolasa title no otra Tab
        driver.close();
        driver.switchTo().window(tabs.get(0)); // parsledzas uz pirmo Tab
        System.out.println(driver.getTitle());
        driver.close();
        System.out.println(driver.getWindowHandles().size()); // windowhandles ir Tabi, parada cik atverti tabi
        System.out.println();

    }

        @Test
        public void javaScriptExecutorExampleTest() throws InterruptedException { //  ka izpildit Javscript kodu
            driver.get("https://www.lu.lv/");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("button[id='ccm__footer__consent-bar-submit']")).click();
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)"); // noskrulle uz lapas apaksu
            Thread.sleep(2000);
            driver.findElement(By.className("footer__up")).click();// nodkrulle uz lapas augsu

            WebElement element = driver.findElement(By.linkText("Kontakti")); // atrod sadalu kontakti
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(2000);
            WebElement menu = driver.findElement(By.className("menuContainer")); // atrod menu konteineri
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", menu); // nodzes menu konteineri
            Thread.sleep(2000);

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        }

        @Test
    public void hoverTest() {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        WebElement hoverButton = driver.findElement(By.cssSelector("div.dropdown2 button"));

        driver.findElement(By.linkText("Link")).click();
        }


    @Test
    public void keyboardClickTest() throws InterruptedException {
        driver.get("https://www.microsoft.com/applied-sciences/projects/anti-ghosting-demo");
        driver.findElement(By.id("clickToUseButton")).click();
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.ALT)
                .perform(); // nospiez un tur Control+Alt

        Thread.sleep(5000);

        new Actions(driver)
                .keyUp(Keys.ALT) // atlaiz Alt
                .perform();

        Thread.sleep(5000);
    }

    @Test
    public void seleniumDocTest() throws InterruptedException { // parbauda, vai search var atrast ar CTRL+K
        driver.get("https://www.selenium.dev/documentation/");
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();
        Thread.sleep(5000);
    }
    }
