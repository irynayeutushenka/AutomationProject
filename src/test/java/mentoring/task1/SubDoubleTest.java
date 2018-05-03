package mentoring.task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubDoubleTest extends Configuration {

    @Test(description = "Subtraction of 5.2 and 3.1 is 2.1")
    public void subPositiveValues() {
        double actual = calculator.sub(5.2, 3.1);
        Assert.assertEquals(actual, 2.1, "Result of subtraction is incorrect");
    }

    @Test(description = "Subtraction of -5.2 and -3.1 is -2.1")
    public void subNegativeValues() {
        double actual = calculator.sub(-5.2, -3.1);
        Assert.assertEquals(actual, -2.1, "Result of subtraction is incorrect");
    }

    @Test(description = "Subtraction of -5.2 and 5.2 is -10.4")
    public void subMixedValues() {
        double actual = calculator.sub(-5.2, 5.2);
        Assert.assertEquals(actual, -10.4, "Result of subtraction is incorrect");
    }
}
