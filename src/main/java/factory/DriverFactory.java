package factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private DriverFactory()
    {
        System.out.println("Inside private constructor of driver factory class");
    }

    private static DriverFactory driverFactory= new DriverFactory();
    public static DriverFactory getInstance()
    {
        return driverFactory;
    }

    public static ThreadLocal<WebDriver> driverThreadLocal= new ThreadLocal<>();
    //setter and getter
    public static void setDriver(WebDriver driver)
    {
        driverThreadLocal.set(driver);
    }
    public static WebDriver getDriver()
    {
        return driverThreadLocal.get();
    }
}
