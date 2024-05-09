package com.idacademy;

import com.idacademy.enums.Capability;
import com.idacademy.utils.DriverFactory;
import com.idacademy.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Base {
   protected WebDriver driver;
   protected Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public FluentWait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

    @BeforeTest
    public void preTest()
    {
        driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterTest
    public void endOfTest(){
        driver.quit();
    }

}
