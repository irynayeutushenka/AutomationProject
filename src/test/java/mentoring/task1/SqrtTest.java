package mentoring.task1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest extends Configuration{

    @DataProvider(name = "dataProviderForSqrt")
    public Object[][] dataProvider() {
        return new Object[][]{
                {4.0, 2.0},
                {9.0, 3.0},
                {16.0, 4.0}};
    }

    @Test(dataProvider = "dataProviderForSqrt")
    public void sqrtTest(double a, double expectedResult) {
        double actual = calculator.sqrt(a);
        Assert.assertEquals(actual, expectedResult, "Result of returning the square root is incorrect");
    }

    @Test (description = "Returning the square root from negative number will lead to an exception",
            expectedExceptions = ArithmeticException.class)
    public void sqrtExceptionTest(){
        calculator.sqrt(-25.0);
    }
}
