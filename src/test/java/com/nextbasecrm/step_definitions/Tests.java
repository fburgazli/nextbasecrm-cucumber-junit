package com.nextbasecrm.step_definitions;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tests {

    @Test
    public void test() {
        Driver.getDriver().get("https://www.amazon.com/");
        Driver.getDriver().findElement(By.xpath("//img[@alt='Sandals']")).click();

        Driver.getDriver().findElement(By.xpath("//section[@aria-label='4 Stars & Up']")).click();

    }
    /*
    http://demo.guru99.com/test/web-table-element.php
    click group B
    Bharat Petroleum name is displayed
    also print all group A's company names.
     */

    @Test
    public void testGuru() {
        Driver.getDriver().get("http://demo.guru99.com/test/web-table-element.php");
        Driver.getDriver().findElement(By.linkText("Group B")).click();

        List<WebElement> listOfAllCompanies = Driver.getDriver().findElements(By.xpath("//tbody//td[1]//a"));
        System.out.println("BrowserUtils.getElementsText(listOfAllCompanies) = " + BrowserUtils.getElementsText(listOfAllCompanies));

    }
}
