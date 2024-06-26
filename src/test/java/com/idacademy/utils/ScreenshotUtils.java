package com.idacademy.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class ScreenshotUtils {

    public static void  takeScreenshot(WebDriver driver) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        File screenshot = new  File("screenshot" + date.getTime() +".png");
        try {
            FileUtils.copyFile(file, screenshot);
        } catch (IOException e) {
            System.out.println("Screenshot  is not save...");;
        }
    }
}
