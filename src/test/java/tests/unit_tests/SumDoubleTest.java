package tests.unit_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumDoubleTest extends Configuration {

    @Test(description = "Summary of 5.1 and 3.1 is 8.2")
    public void sumPositiveValues() {
        double actual = calculator.sum(5.1, 3.1);
        Assert.assertEquals(actual, 8.2, "Result of sum is incorrect");
    }

    @Test(description = "Summary of -5.1 and -3.1 is -8.2")
    public void sumNegativeValues() {
        double actual = calculator.sum(-5.1, -3.1);
        Assert.assertEquals(actual, -8.2, "Result of sum is incorrect");
    }

    @Test(description = "Summary of -5.1 and 5.1 is 0")
    public void sumMixedValues() {
        double actual = calculator.sum(-5.1, 5.1);
        Assert.assertEquals(actual, 0.0, "Result of sum is incorrect");
    }
}