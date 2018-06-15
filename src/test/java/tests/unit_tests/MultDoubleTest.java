package tests.unit_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultDoubleTest extends Configuration {

    @Test(description = "Multiplication of 5.2 and 2.0 is 10.4")
    public void multPositiveValues() {
        double actual = calculator.mult(5.2, 2.0);
        Assert.assertEquals(actual, 10.4, "Result of multiplication is incorrect");
    }

    @Test(description = "Multiplication of -5.2 and -2.0 is 10.4")
    public void multNegativeValues() {
        double actual = calculator.mult(-5.2, -2.0);
        Assert.assertEquals(actual, 10.4, "Result of multiplication is incorrect");
    }

    @Test(description = "Multiplication of -5.2 and 2.0 is -10.4")
    public void multMixedValues() {
        double actual = calculator.mult(-5.2, 2.0);
        Assert.assertEquals(actual, -10.4, "Result of multiplication is incorrect");
    }
}
