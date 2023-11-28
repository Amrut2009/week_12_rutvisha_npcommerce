package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;

import javax.swing.*;
import java.util.List;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // This method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // This method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method will accept to alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // this method will dismiss to alert
    public void dismiss() {
        driver.switchTo().alert().dismiss();
    }

    //this method will getText to alert
    public String getTextFromElement() {
        return driver.switchTo().alert().getText();
    }

    //this method will sendTxt to alert
    public void sendText(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //select class Methods
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //create the object of the select class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    public void selectByVisibleText(By by, String text) {
        WebElement visibleText = driver.findElement(by);
        //Create the object of Select class
        Select select = new Select(visibleText);
        select.selectByVisibleText(text);
    }

    public void containsTextFromDropdown(By by, String text) {
        WebElement containsText = driver.findElement(by);
        //Create the object of Select class
        Select select = new Select(containsText);
        select.selectByValue(text);
    }

    public void indexFromDropDown(By by, int number) {
        WebElement index = driver.findElement(by);
        //Create the object of Select class
        Select select = new Select(index);
        select.selectByIndex(number);
    }

    //this method will use to hover mouse on element

    public void mouseHoverToElements(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    //Assert Method
    public void verifyText(By by, String text) {
        String expectedMessage = text;
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);


    }
    public void selectMenu(String menu) {
        WebElement menu1 = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().perform();
    }
}


