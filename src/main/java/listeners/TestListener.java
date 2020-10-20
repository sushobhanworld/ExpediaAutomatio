package listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReporting;
import utilities.UtilityClass;

import java.io.IOException;

public class TestListener extends ExtentReporting implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result) {
        extentTest= extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test case passed is ::: "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test case failed is ::: "+result.getMethod().getMethodName());
        extentTest.log(Status.FAIL, result.getThrowable());
        try {
            extentTest.addScreenCaptureFromPath(UtilityClass.TakeScreeshotForFailedTestCases(result.getMethod().getMethodName(), driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
