package com.ai.framework.utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    private ScreenshotUtils() {

    }

    public static String captureScreenshot(WebDriver driver, String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        // Create Screenshots folder if it doesn't exist
        File folder = new File("Screenshots");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String destination = "Screenshots/" + testName + ".png";

        File target = new File(destination);

        try {

            Files.copy(
                    source.toPath(),
                    target.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return destination;
    }

}