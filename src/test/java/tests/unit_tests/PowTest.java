package tests.unit_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PowTest extends Configuration {

    @Test(description = "Raise 5 to the 2 power will give 25")
    public void powTest() {
        double actual = calculator.pow(5.0, 2.0);
        Assert.assertEquals(actual, 25.0, "Result of raising to a power is incorrect");
    }

}
