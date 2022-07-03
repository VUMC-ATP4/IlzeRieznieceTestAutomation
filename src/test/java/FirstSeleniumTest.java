import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void checkPageTitle () {
        String url = "https://www.saucedemo.com/"; // nodefine lapas adresi
        WebDriver browser = new ChromeDriver(); // atver browseri, brovseris ir objekts, var darit jebko
        browser.get(url); //atver noradito linku, var ari iekopet url adresi, ar pedinam
        String expectedTitle = "Swag Labs"; // panemts no weblapas
        String actualTitle = browser.getTitle(); // automatiski samekle nosaukumu
        Assert.assertEquals(actualTitle, expectedTitle);
        browser.quit(); // aizver browseri = tests beidzies ( ja ir kluda, tests apstajas un brovseris neaizveras)

    }

}
