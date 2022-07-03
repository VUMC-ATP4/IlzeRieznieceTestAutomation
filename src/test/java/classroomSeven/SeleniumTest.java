package classroomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    WebDriver driver; // vares izmantot katra metode, jo definets pirms visam metodem
    public final String SAUCELABS_URL = "https://www.saucedemo.com/"; //nav jaraksta adrese katra testa
    public final String DELFI_URL = "https://www.delfi.lv/";
    WebDriverWait wait;

    @BeforeMethod
    public void setUpBrowser() {
        System.out.println("Pirms testa");
        driver = new ChromeDriver(); // atvers web pirms katra testa
        driver.manage().window().maximize(); // atver web pilna loga
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // tiesha gaidisana
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// gaidis 10 sek uz katru elementu; netiesa gaidisana
    }

    @AfterMethod
    public void tearDownBrowser() {
        System.out.println("Pec testa");
        driver.close(); // aizvers web pec katra testa
    }

    @Test

    //ja ID ir unikals, tad labak to izmantot
    public void errorMessageTestUsernameEmpty() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        System.out.println("Tests username nav ievadits");
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("querty1234");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualText = errorText.getText();
        String expectedText = " Epic sadface: Username is required";
        Assert.assertEquals(actualText, expectedText);


        Thread.sleep(5000); //web pagaidis 5000 milisekundes (5 sek), parasti testos neizmanto
    }

    @Test
    public void errorMessageTestPasswordEmpty() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        System.out.println("Tests parole nav ievadita");
        WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
        System.out.println(acceptedUsernamesText.getText()); // izprinte, kas atrodas starp h4
        WebElement usernameInputField = driver.findElement(By.id("user-name")); //nodefine mainigo un pieskir vertibu pec ID
        usernameInputField.sendKeys("Ilze"); // lietotajs bus Ilze
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys(""); // paroles lauks bus tukss
        WebElement loginButton = driver.findElement(By.className("submit-button")); // mekle pec klases nosaukuma
        loginButton.click(); //nospiest pogu
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']")); // mekle pec css selectora
        String actualText = errorText.getText();
        String expectedText = "Epic sadface: Password is required";
        Assert.assertEquals(actualText, expectedText);


        Thread.sleep(5000);
    }

        @Test

        public void errorMessageTestPasswordUsernameEmpty() throws InterruptedException {
            driver.get(SAUCELABS_URL);
            System.out.println("Tests nekas nav ievadits");
            WebElement usernameInputField = driver.findElement(By.id("user-name"));
            usernameInputField.sendKeys(" ");
            WebElement passwordInputField = driver.findElement(By.id("password"));
            passwordInputField.sendKeys("");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
            String actualText = errorText.getText();
            String expectedText = "Epic sadface: Username is required";
            Assert.assertEquals(actualText, expectedText);


            Thread.sleep(5000);
        }

        @Test
        //sablons main-java-pageObjects-LoginPage
        public void errorMessagePasswordEmptyObjectPage() throws InterruptedException {
            driver.get(SAUCELABS_URL);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.getUsernameInputField().sendKeys("Ilze");
            loginPage.getPasswordInputField().sendKeys("");
            loginPage.getLoginButton().click();
            Assert.assertEquals(loginPage.getErrorText().getText(), "Epic sadface: Password is required");


        }

        @Test
        // sablons main-java-pageObjects-InventoryPage
        public void successLoginPageObject() throws InterruptedException {
            driver.get(SAUCELABS_URL);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.getUsernameInputField().sendKeys("standard_user");
            loginPage.getPasswordInputField().sendKeys("secret_sauce ");
            loginPage.getLoginButton().click();
            InventoryPage inventoryPage = new InventoryPage(driver);
            Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
            inventoryPage.getLinkedinLink().click();
            Thread.sleep(5000);
        }

        @Test
        // izmanto datus no LoginPage pedejas metyodes, kur ielogojas lapa automatiski
        public void errorMessageUsernameEmpthyPageObject() {
            driver.get(SAUCELABS_URL);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("", "quart1234");
            Assert.assertEquals(loginPage.getErrorText().getText(), "Epic sadface: Username is required");
    // Assert liek tikai testos (@Test), ne testa objektos!!!
    }

        @Test
        public void successfullLoginTest() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        System.out.println("Tests LogIn veiksmigs");
        WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
        System.out.println(acceptedUsernamesText.getText());
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        loginButton.click();
        // augsup esosais ielogo lapa
        // Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
        Assert.assertEquals(pageTitleText.getText(),"PRODUCTS"); // parbauda, vai tiesam ir log in, salidzina esosos tekstus pec logIn
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        // augseja rinda, ja HTML ir Select, to atrod pec select, ja ir 1 unikals
        sortDropdown.selectByValue("hilo"); //karto pec cenas no augstakas uz zemako
        Thread.sleep(5000);
        sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));// janorada no jauna, jo lapu parlade
        sortDropdown.selectByIndex(1); //karto pec alfabeta
        Thread.sleep(5000);
        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
        linkedInLink.click(); // nospiez uz LinkedIn pogu, kas ir web lapa
        Thread.sleep(5000);
    }


    @Test
    public void myTest2() {
        driver.get(DELFI_URL);
        System.out.println("Tests 2");
    }

    @Test
    public void localHTMLExerciseTest() throws InterruptedException {
        driver.get("file://C:\\Users\\ilzer\\OneDrive\\Desktop\\JAVA\\IlzeRieznieceTestAutomation\\src\\test\\resources\\elements.html");
        Thread.sleep(5000);
        WebElement descriptionTextArea = driver.findElement(By.name("description"));
        descriptionTextArea.clear(); // notira tekstu, kas ir default, pec tam nosuta savu tekstu
        descriptionTextArea.sendKeys("Sis ir teksts par mani, hello hello"); //aizpilda konkreto lauku
        WebElement linkElements = driver.findElement(By.linkText("Link Text"));//mekle tekstu HTML pec a href - links
        linkElements.click();
        WebElement isStudentCheckbox = driver.findElement(By.id("studentID"));
        Assert.assertEquals(isStudentCheckbox.isSelected(),false); // is selected darbojas tikai checkbox and radio button
        isStudentCheckbox.click();// si un ieprieks 2 linijas norada, ka checkbox jabut keksim
        Assert.assertEquals(isStudentCheckbox.isSelected(),true); //parbauda, vai tiesam ir keksis
        Select milakaKrasa = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasa.selectByIndex(0);// pirma no saraksta
        milakaKrasa.selectByIndex(3); // 4. no saraksta

        String [] asdas  = {"asdasdas","asdasdas"};
        List<WebElement> sarakstsArKrasam =  milakaKrasa.getOptions(); //ir lists ar elementiem define masivu = atgriez sarakstu ar krasam

        for (int i = 0; i < sarakstsArKrasam.size(); i++) {
            System.out.println(sarakstsArKrasam.get(i).getText()); // ja nepieliek getText, izprintes tikai web elementus
        }

        WebElement nospiedManiPoga = driver.findElement(By.id("checkDataID"));
        nospiedManiPoga.click(); // nospiez
        WebElement vissIrLabiTeksts = driver.findElement(By.id("checkDataResultID"));
        wait.until(ExpectedConditions.elementToBeClickable(vissIrLabiTeksts));// sagaida, kad teksts bus klikskinams
        vissIrLabiTeksts.click();
    }


}
