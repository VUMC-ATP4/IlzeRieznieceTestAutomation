import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    //testam janorada anotacijas, rakstas virs metodes

    @BeforeTest // sis izpildisies pirms katra testa, var pielietot, lai noteiktu vienados objektus

    public void pirmTests() {
        System.out.println("There test starts");
    }
    @Test
    public void testSum(){
        System.out.println("This is my first TestNG testing");

        Calculator calculator = new Calculator(); // uztaisa kalkulatoru
        int actualResult = calculator.sum(13,25);
        int expectedResult = 38;
        //parbauda, vai ir patiess, izmanto esosu klasi
        Assert.assertEquals(actualResult, expectedResult);

}
    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(5,5), 25);
}
}
