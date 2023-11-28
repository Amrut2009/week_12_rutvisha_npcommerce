package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //click oncomputermenu
        clickOnElement(By.linkText("Computers"));
        //2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //Select Sort By position "Name: Z to A
        selectByValueFromDropDown(By.id("products-orderby"), "6");
        // Verify the Product will arrange in Descending order
        String expectedText = "Product will arrange in Descending order";
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        // Click on Desktop
        clickOnElement(By.linkText("Desktops"));

        //Select Sort By position "Name: A to Z
        selectByValueFromDropDown(By.id("products-orderby"), "6");

        //4 Click on "Add To Cart
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //Verify the Text "Build your own computer
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
        Assert.assertEquals(expectedText, actualText);
        //6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropDown(By.id("product_attribute_1"), "1");
        //Select "8GB [+$60.00]" using Select class.
        selectByValueFromDropDown(By.id("product_attribute_2"), "1");
        //8 Select HDD radio "400 GB [+$100.00]"
        selectByValueFromDropDown(By.xpath("//input[@id=product_attribute_3_7"), "1");
        //9 Select OS radio "Vista Premium [+$60.00]
        selectByValueFromDropDown(By.xpath("//input[@id='product_attribute_4_9']"), "9");
        //.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        selectByValueFromDropDown(By.xpath("//input[@id='product_attribute_5_10']"), "10");
        //1 Verify the price "$1,475.00
        String expectedprice = "$1,475.00";
        String actualprice = getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]"));
        Assert.assertEquals(expectedprice, actualprice);
        //Click on "ADD TO CARD" Button
        clickOnElement(By.cssSelector("//button[@id='add-to-cart-button-1']"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedmsg = "The product has been added to your shopping cart";
        String actualmsg = getTextFromElement(By.xpath("Rel XPath //body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals(expectedmsg, actualmsg);
        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //4 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElements(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //Verify the message "Shopping cart"
        String expectedcart = "Shopping cart";
        String actualcart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedcart, actualcart);
        //Change the Qty to "2" and Click on "Update shopping cart
        WebElement changeqty = driver.findElement(By.xpath("//input[@id='itemquantity11219']"));
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //7 Verify the Total"$2,950.00"
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals(expectedTotal, actualTotal);
        //8 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("terms-of-service"));
        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //0 Verify the Text “Welcome, Please Sign In!”
        String expectedTextMsg = "Welcome, Please Sign In!";
        String actualTextMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedTextMsg, actualTextMsg);
        //Click on “CHECKOUT AS GUEST” Tab

        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.21Click on “CHECKOUT AS GUEST” Tab

        sendTextToElement(By.id("BillingNewAddress_FirstName"), "John");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Smith");
        sendTextToElement(By.id("BillingNewAddress_Email"), "SmithJohn@hotmail.co.uk");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        selectByValueFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "0");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Heamsted Heath");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "N2 3PU");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "99887765432");




        //2 Fill the all mandatory field
        sendTextToElement(By.id("First name:"), "John");
        sendTextToElement(By.id("Last name:"), "Smith");
        sendTextToElement(By.id("Gender:"), "male");
        // selectByValueFromDropDown(By.id("Date of birth:"),);
        sendTextToElement(By.id("Email:"), "SmithJohn@hotmail.com");
        sendTextToElement(By.id("Password:"), "Smith12345@");
        sendTextToElement(By.id("Confirm password:"), "Smith12345@");
        //3 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));


        //4 Click on Radio Button “Next Day Air($0.00)
        clickOnElement(By.cssSelector("#shippingoption_1"));
        //5 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //Select Radio Button “Credit Card
        clickOnElement(By.cssSelector("#paymentmethod_1"));
        clickOnElement(By.xpath("//ol[1]/li[4]/div[2]/div[1]/button[1]")); //for continue


        //Select “Master card” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "MasterCard");

        //8 Fill all the details
        sendTextToElement(By.id("CardholderName"), "John Smith"); //Enter name
        sendTextToElement(By.name("CardNumber"), "5555555555554444");//enter card number
        selectByValueFromDropDown(By.id("ExpireMonth"), "5"); //enter month
        selectByValueFromDropDown(By.id("ExpireYear"), "2024");//enter year
        sendTextToElement(By.cssSelector("#CardCode"), "3101");


        //9 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //Verify “Payment Method” is “Credit Card
        verifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        //2 Verify “Shipping Method” is “Next Day air"
        verifyText(By.xpath("//div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "Next Day Air");

        //3 Verify Total is “$2,950.00”
        verifyText(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"), "$2,950.00");

        //4 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //Verify the Text “Thank You”
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //6 Verify the message “Your order has been successfully processed!
        verifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        //7 Click on “CONTINUE
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));


        //7 Verify the text “Welcome to our store”


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
