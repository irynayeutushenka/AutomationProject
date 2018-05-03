package mentoring.task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultLongTest extends Configuration{

    @Test(description = "Multiplication of 5 and 3 is 15", groups = "smoke_test")
    public void multPositiveValues() {
        long actual = calculator.mult(5, 3);
        Assert.assertEquals(actual, 15, "Result of multiplication is incorrect");
    }

    @Test(description = "Multiplication of -5 and -3 is 15", groups = "smoke_test")
    public void multNegativeValues() {
        long actual = calculator.mult(-5, -3);
        Assert.assertEquals(actual, 15, "Result of multiplication is incorrect");
    }

    @Test(description = "Multiplication of -5 and 3 is -15")
    public void multMixedValues() {
        long actual = calculator.mult(-5, 3);
        Assert.assertEquals(actual, -15, "Result of multiplication is incorrect");
    }
}
