package tests.unit_tests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class Configuration {
    Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void initiateCalculator() {
        calculator = new Calculator();
    }

}
