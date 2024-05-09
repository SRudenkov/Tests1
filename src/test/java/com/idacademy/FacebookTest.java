package com.idacademy;

import com.idacademy.utils.ScreenshotUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class FacebookTest extends Base {

    @Test
    public void googleTest() throws InterruptedException, IOException {
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        driver.findElement(By.name("q"));
        driver.findElement(By.className("gLFyf"));
        driver.findElement(By.id("APjFqb"));
        driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        driver.findElement(By.xpath("//textarea[@aria-controls='Alh6id']"));
        driver.findElement(By.cssSelector(".gLFyf"));
        element.sendKeys("Selenium");
        ScreenshotUtils.takeScreenshot(driver);
        element.submit();

        Thread.sleep(5000);
    }

}
