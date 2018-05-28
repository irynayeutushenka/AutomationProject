package tests.unitTests_task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubLongTest extends Configuration {

    @Test(description = "Subtraction of 5 and 3 is 2", groups = "smoke_test")
    public void subPositiveValues() {
        long actual = calculator.sub(5, 3);
        Assert.assertEquals(actual, 2, "Result of subtraction is incorrect");
    }

    @Test(description = "Subtraction of -5 and -3 is -2", groups = "smoke_test")
    public void subNegativeValues() {
        long actual = calculator.sub(-5, -3);
        Assert.assertEquals(actual, -2, "Result of subtraction is incorrect");
    }

    @Test(description = "Subtraction of -5 and 5 is 0")
    public void subMixedValues() {
        long actual = calculator.sub(-5, 5);
        Assert.assertEquals(actual, -10, "Result of subtraction is incorrect");
    }

}
