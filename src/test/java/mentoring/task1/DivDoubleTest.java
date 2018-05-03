package mentoring.task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivDoubleTest extends Configuration{

    @Test(description = "Division of 10.2 and 5.1 is 2")
    public void divPositiveValues() {
        double actual = calculator.div(10.2, 5.1);
        Assert.assertEquals(actual, 2.0, "Result of division is incorrect");
    }

    @Test(description = "Division of -10.2 and -5.1 is 2")
    public void divNegativeValues() {
        double actual = calculator.div(-10.2, -5.1);
        Assert.assertEquals(actual, 2.0, "Result of division is incorrect");
    }

    @Test(description = "Division of -10.2 and 5.1 is -2")
    public void divMixedValues() {
        double actual = calculator.div(-10.2, 5.1);
        Assert.assertEquals(actual, -2.0, "Result of division is incorrect");
    }

    @Test (description = "Division of number on zero will lead to an exception",
            expectedExceptions = NumberFormatException.class)
    public void divExceptionTest(){
        calculator.div(10.2, 0.0);
    }
}
