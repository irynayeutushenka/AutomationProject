package tests.unit_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumLongTest extends Configuration {

    @Test(description = "Summary of 5 and 3 is 8", groups = "smoke_test")
    public void sumPositiveValues() {
        long actual = calculator.sum(5, 3);
        Assert.assertEquals(actual, 8, "Result of sum is incorrect");
    }

    @Test(description = "Summary of -5 and -3 is -8", groups = "smoke_test")
    public void sumNegativeValues() {
        long actual = calculator.sum(-5, -3);
        Assert.assertEquals(actual, -8, "Result of sum is incorrect");
    }

    @Test(description = "Summary of -5 and 5 is 0")
    public void sumMixedValues() {
        long actual = calculator.sum(-5, 5);
        Assert.assertEquals(actual, 0, "Result of sum is incorrect");
    }
}
