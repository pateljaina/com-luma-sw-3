package testsuite;

import Utilities.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before//action before every method
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldAddProductsSuccessfullyToShoppingCart() throws InterruptedException {
        mouseHoverOnElement(By.cssSelector("a[id='ui-id-6'] span:nth-child(1)"));
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        Assert.assertEquals("Not directed to duffle bag page", getTextFromElement(By.xpath("//h1[@class='page-title']")), "Overnight Duffle");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='qty']"));
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys(Keys.CONTROL + "a");
        sendTextToElement(By.xpath("//input[@id='qty']]"), "3");
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        assertVerifyText(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"), "You added Overnight Duffle to your shopping cart.");
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        clickOnElement(By.xpath("//input[@id='qty']"));
        Actions action1 = new Actions(driver);
        driver.findElement(By.xpath("///input[@id='cart-106777-qty']")).sendKeys(Keys.CONTROL + "a");
        sendTextToElement(By.xpath("//input[@id='cart-106777-qty']"), "5");
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));
        assertVerifyText(By.xpath("//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]"), "$225.00");
    }
}
