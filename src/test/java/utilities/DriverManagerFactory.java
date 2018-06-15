package utilities;

public class DriverManagerFactory {
    public static DriverManager getManager(String browser) {
        DriverManager driverManager = null;
        if (browser.equalsIgnoreCase("chrome")) {
            driverManager = new ChromeDriverManager();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverManager = new FirefoxDriverManager();
        } else if (browser.equalsIgnoreCase("ie")) {
            driverManager = new IeDriverManager();
        }
        return driverManager;
    }
}
