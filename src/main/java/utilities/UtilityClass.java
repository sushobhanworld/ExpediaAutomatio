package utilities;

import base.ProjectBaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityClass extends ProjectBaseClass {

    //Take screenshot
    public static String TakeScreeshotForFailedTestCases(String name, WebDriver driver) throws IOException
    {
        String date= new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
        File fileSRC= takesScreenshot.getScreenshotAs(OutputType.FILE);
        File fileDestination= new File(System.getProperty("user.dir")+"/FailedTest/"+name+date+".png");
        FileUtils.copyFile(fileSRC, fileDestination);
        return System.getProperty("user.dir")+"/FailedTest/"+name+date+".png";
    }

    //To Take Screenshot at End Of Test
    public static void TakeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
    }

    //To Take Screenshot before click on search button
    public static void TakeScreenshotBeforeClickOnSearchButton() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + "BeforeClickOnSearchButtonClick.png"));
    }

    //To Take Screenshot after click on search button
    public static void TakeScreenshotAfterClickOnSearchButton() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + "AfterClickOnSearchButtonClick.png"));
    }
}
