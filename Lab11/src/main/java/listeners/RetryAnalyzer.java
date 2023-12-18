package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

import static utils.Screenshots.saveScreenshot;

public class RetryAnalyzer implements IRetryAnalyzer {

    @Override
    public boolean retry(ITestResult iTestResult) {
        try {
            saveScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        iTestResult.setStatus(ITestResult.FAILURE);
        return false;
    }
}