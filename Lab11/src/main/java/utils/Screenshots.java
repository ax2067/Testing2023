package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import webdriver.Browser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {

    public static void saveScreenshot() throws IOException {
        File screenshotsDirectory = new File("src/test/logs/screenshots");

        if (!screenshotsDirectory.exists()) {
            screenshotsDirectory.mkdirs();
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-SS--a");
        String formattedDate = simpleDateFormat.format(date);

        String fileName =  formattedDate + "_screenshot.png";

        if (Browser.getDriver() instanceof TakesScreenshot) {

            byte[] scrFile = ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.BYTES);
            Files.write(new File(screenshotsDirectory + "/" + fileName).toPath(),
                    scrFile, StandardOpenOption.CREATE);
        } else {
            System.out.println("Can't take a screenshot");
        }
    }
}