package com.idacademy.pages;

import com.idacademy.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestHomePage extends BasePage {
    WebDriver driver;
    @FindBy (css = ".sc-124al1g-4.eeXMBo")
    private WebElement pageAllWebElementsName;


    public TestHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openUrl(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }


}
