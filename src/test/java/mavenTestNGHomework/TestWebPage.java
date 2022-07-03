package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWebPage {

    @Test

    public void checkPageTitle () {
        String url = "https://www.inbox.lv/"; // nodefine lapas adresi
        WebDriver browser = new ChromeDriver(); // atver browseri
        browser.get(url); //atver noradito linku, var ari iekopet url adresi, ar pedinam
        String expectedTitle = "Inbox.lv - vienot savējos lielām lietām! -"; // panemts no weblapas
        String actualTitle = browser.getTitle(); // automatiski samekle nosaukumu
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Expected Title is " + expectedTitle);
        System.out.println("Actual Title is " + actualTitle);
        browser.quit(); // aizver browseri
    }

    @Test

    public void checkPageTitle2 () {
        String url;
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.1188.lv/en/transport");
        String expectedTitle = "1188 transport";
        String actualTitle = browser.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Expected Title is " + expectedTitle);
        System.out.println("Actual Title is " + actualTitle);
        browser.quit();
    }
}
