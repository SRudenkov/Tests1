package com.idacademy;

import com.idacademy.pages.TestHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
  * Прочитайте статью, что Влад сбросил, очень хорошая статья
 * https://habr.com/ru/companies/skyeng/articles/588282/
 */
public class ProductsTests extends Base {


    /**
     * Тест 1
     *  * 1. Найдите название первого продукта
     *  * 2. Добавьте в корзину первый продукт
     *  * 3. Сравните название продукта в корзине с названием продукта из первого пункта
     */
    @Test
    public void test1()throws InterruptedException
    {
        TestHomePage testHomePage = new TestHomePage(driver);
        testHomePage.openUrl();
        //wait.until(ExpectedConditions.titleIs("react-shopping-cart-67954"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement pageFirstElement = driver.findElement(By.xpath("//button[@class=\"sc-124al1g-0 jCsgpZ\"]"));
        WebElement firstElementPageName = driver.findElement(By.cssSelector(".sc-124al1g-4.eeXMBo"));
        Assert.assertTrue(pageFirstElement.isDisplayed(), "Add to cart isn't present");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pageFirstElement.click();

        WebElement pageFirstElementNameBasket = driver.findElement(By.cssSelector(".sc-11uohgb-2.elbkhN"));
        String firstElementPageNameToString = firstElementPageName.getText();
        String firstElementPageNameBasketToString = pageFirstElementNameBasket.getText();
        System.out.println(firstElementPageNameToString);
        System.out.println(firstElementPageNameBasketToString);
        if (firstElementPageNameToString.equals(firstElementPageNameBasketToString)) System.out.println("Items is equal");

    }

    /**
     * Тест 2.
     *  * 1. Получите названия всех продуктов(используйте List)
     *  * 2. Добавьте все продукты в корзину
     *  * 3. Сравните все названия продуктов в корзине с листом из первого пункта
     */
    @Test
    public void test2() throws InterruptedException{
        TestHomePage testHomePage = new TestHomePage(driver);
        testHomePage.openUrl();

        List<WebElement> pageAllWebElementsName = driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo"));

        List<String> pageAllWebElementsNameToString = pageAllWebElementsName.stream().map(x->x.getText()).collect(Collectors.toList());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // Thread.sleep(2000);
        List<WebElement> pageAddAllWebElements = driver.findElements((By.xpath("//*[text()='Add to cart']")));
        for(WebElement webElement: pageAddAllWebElements)
        {
          ((JavascriptExecutor)driver).executeScript("arguments[0].click();", webElement); // Исполняет click() по элементам скрытым другим окном
            Assert.assertTrue(webElement.isDisplayed(), "Add to cart isn't present");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //Thread.sleep(100);
        }
        List<WebElement> basketAllWebElementsName = driver.findElements(By.xpath("//*[@class='sc-11uohgb-2 elbkhN']"));
        List<String> basketAllWebElementsNameToString = basketAllWebElementsName.stream().map(x->x.getText()).collect(Collectors.toList());
        System.out.println(pageAllWebElementsNameToString);
        System.out.println(basketAllWebElementsNameToString);
        int a = pageAllWebElementsName.size();
        int b = basketAllWebElementsName.size();
        System.out.println(a);
        System.out.println(b);
        if (a==b)  System.out.println(" элементы на странице и в корзине равны");
        Thread.sleep(2500);
    }

    /**
     * Тест 3
     *  * 1. Получите названия всех продуктов(используйте List)
     *  * 2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
     *  * 3. Получите лист для текущих продуктов и сравните что его размер меньше листа из первого пункта     *
     */

    @Test
    public void test3() throws InterruptedException {
        TestHomePage testHomePage = new TestHomePage(driver);
        testHomePage.openUrl();
        List<WebElement> pageAllWebElementsName = driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo"));
        List<String> pageAllWebElementsNameToString = pageAllWebElementsName.stream().map(x->x.getText()).collect(Collectors.toList());
        WebElement buttonML= driver.findElement(By.xpath("//*[text()='ML']"));
         if (buttonML.isDisplayed())
         {buttonML.click();}
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(500);
         List<WebElement> pageWebElementListMLName = driver.findElements(By.xpath("//*[@class=\"sc-124al1g-4 eeXMBo\"]"));
         List<String> pageWebElementListMLToString = pageWebElementListMLName.stream().map(x->x.getText()).collect(Collectors.toList());
        System.out.println(pageAllWebElementsNameToString);
        System.out.println(pageWebElementListMLToString);
        int a = pageAllWebElementsNameToString.size();
        int b = pageWebElementListMLToString.size();
        if (a>b) {
            System.out.println("Список всех элементов страницы  "+ a + "  больше списка элементов ML  " + b);
            } else if (a==b) {
            System.out.println(" Списки равны ");
             } else if(a<b) {
            System.out.println(" какой то косяк в подсчетах, жизнь грустяка");
        }
    }

    /**
     * Тест 4
     *  * 1. Получите количество продуктов расспарсив сверху стрингу  16 Product(s) found
     *  * 2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
     *  * 3. Получите количество продуктов после фильтра  расспарсив сверху стрингу   Product(s) found и сравните с числом из первого пункта
     */
    @Test
    public void test4() throws InterruptedException {
        TestHomePage testHomePage = new TestHomePage(driver);
        testHomePage.openUrl();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(500);
        WebElement webElementNumber= driver.findElement(By.xpath("//*[@class='sc-ebmerl-4 iliWeY']"));
        String allItems = webElementNumber.getText();

        String[] stringsArrowAll = allItems.split(" ");
//        System.out.println(stringsArrowAll[0]);
        WebElement buttonML= driver.findElement(By.xpath("//*[text()='ML']"));
        if (buttonML.isDisplayed())
        {buttonML.click();}
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(500);
        WebElement webElementNumberML= driver.findElement(By.xpath("//*[@class='sc-ebmerl-4 iliWeY']"));
        String allItemsML = webElementNumberML.getText();
        String[] stringsArrowML = allItemsML.split(" ");
//        System.out.println(stringsArrowML[0]);
        int calculatAllItems = Integer.parseInt (stringsArrowAll[0]);
        int calculatAllML = Integer.parseInt (stringsArrowML[0]);
        if (stringsArrowAll[0].equals(stringsArrowML[0])) {
            System.out.println(" Количество товара на главной странице " + calculatAllItems + " равно количеству товара на странице с фильтром ML  " + calculatAllML);
        }else if (calculatAllItems > calculatAllML)
        {System.out.println(" Количество товара на главной странице " + calculatAllItems + " ,больше чем количество товара на странице с фильтром ML " + calculatAllML);
        }
   }
}
