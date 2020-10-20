package base;

import factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.EventCapture;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ProjectBaseClass
{
    private final String path= System.getProperty("user.dir")+"/src/main/resources/application.properties";
    public static Properties properties;
    public static FileInputStream fileInputStream;
    public static WebDriver driver;  //get the thread safe driver here
    public static DriverFactory driverFactory;
    public static EventFiringWebDriver eventFiringWebDriver;
    public static EventCapture eventCapture;
    public static Logger logger;

    public ProjectBaseClass()
    {
        properties= new Properties();
        try
        {
            fileInputStream= new FileInputStream(path);
            properties.load(fileInputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //all the drivers should be replaced by thread safe drivers
    public static void Initialize()
    {
        String b= properties.getProperty("browser");
        if (b.equals("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            DriverFactory.setDriver(new ChromeDriver());
            driver= DriverFactory.getDriver();
            //driver= new ChromeDriver();
        }
        else if (b.equals("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            DriverFactory.setDriver(new FirefoxDriver());
            driver= DriverFactory.getDriver();
        }
        eventFiringWebDriver= new EventFiringWebDriver(driver);
        eventCapture= new EventCapture();
        eventFiringWebDriver.register(eventCapture);
        driver= eventFiringWebDriver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(properties.getProperty("baseURL"));
    }

}
