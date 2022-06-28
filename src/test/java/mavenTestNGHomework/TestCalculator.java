package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestCalculator {
    Calculator calculator = new Calculator();

    @BeforeClass
    public void sakums() {
        System.out.println("Mājasdarbs sākas!");
    }

    @BeforeMethod
    public void pirmsTesta() {
        System.out.println("Tests ir sācies!");
    }

    @AfterMethod
    public void pecTesta() {
        System.out.println("Pārbaude veikta!");
    }

    @AfterClass
    public void testaBeigas () {
        System.out.println("Viss ir pārbaudīts, testi ir pabeigti! Rezultātu skatīt zemāk!");
    }

    @Test
    public void add() {
        System.out.println("Pārbaudām saskaitīšanu");
        int actualResult = calculator.add(15,30);
        int expectedResult = 45;
        //parbauda, vai ir patiess, izmanto esošu klasi
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void substract() {
        System.out.println("Pārbaudām atņemšanu");
        int actualResult = calculator.substract(50,30);
        int expectedResult = 20;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiply() {
        System.out.println("Pārbaudām reizināšanu");
        int actualResult = calculator.multiply(2,30);
        int expectedResult = 60;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divide() {
        System.out.println("Pārbaudām dalīšanu");
        float actualResult = calculator.divide(40,10);
        float expectedResult = 4;
        Assert.assertEquals(actualResult, expectedResult);
    }

}
