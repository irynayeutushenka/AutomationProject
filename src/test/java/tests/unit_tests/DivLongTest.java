package tests.unit_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivLongTest extends Configuration {

    @Test(description = "Division of 10 and 5 is 2", groups = "smoke_test")
    public void divPositiveValues() {
        long actual = calculator.div(10, 5);
        Assert.assertEquals(actual, 2, "Result of division is incorrect");
    }

    @Test(description = "Division of -10 and -5 is 2", groups = "smoke_test")
    public void divNegativeValues() {
        long actual = calculator.div(-10, -5);
        Assert.assertEquals(actual, 2, "Result of division is incorrect");
    }

    @Test(description = "Division of -10 and 5 is -2")
    public void divMixedValues() {
        long actual = calculator.div(-10, 5);
        Assert.assertEquals(actual, -2, "Result of division is incorrect");
    }

    @Test(description = "Division of 10 and 6 is 1")
    public void divWithRemainder() {
        long actual = calculator.div(10, 6);
        Assert.assertEquals(actual, 1, "Result of division is incorrect");
    }

    @Test(description = "Division of number on zero will lead to an exception",
            expectedExceptions = NumberFormatException.class)
    public void divExceptionTest() {
        calculator.div(5, 0);
    }
}
