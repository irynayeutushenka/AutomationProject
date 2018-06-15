package utilities;

import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class IeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
        webDriver = new EdgeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }
}
