package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before//action before every method
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        mouseHoverOnElement(By.cssSelector("#ui-id-4"));//mouse hover on Women menu
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));//mouse hover on tops
        mouseHoverOnElementAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));//Click on jackets
        clickOnElement(By.cssSelector("#sorter"));//select sort option
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]/option[3]"));//select filter product name
        assertProduct("Adrienne Trek Jacket", 1);//verify products displayed in alphabetical order
        assertProduct("Augusta Pullover Jacket ", 2);
        assertProduct("Inez Full Zip Jacket ", 3);
        assertProduct("Ingrid Running Jacket ", 4);
        assertProduct("Jade Yoga Jacket ", 5);
        assertProduct("Josie Yoga Jacket ", 6);
        assertProduct(" Juno Jacket ", 7);
        assertProduct(" Juno Jacket ", 8);
        assertProduct("Neve Studio Dance Jacket ", 9);
        assertProduct("Augusta Pullover Jacket ", 10);
        assertProduct("Inez Full Zip Jacket ", 11);
        assertProduct("Ingrid Running Jacket ", 12);
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        mouseHoverOnElement(By.cssSelector("#ui-id-4"));//mouse hover on Women menu
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));//mouse hover on tops
        mouseHoverOnElementAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));//Click on jackets
        clickOnElement(By.cssSelector("#sorter"));//select filter option
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]/option[3]"));//select filter price
        assertPrice("$32.00", 1);//verify products price displayed low to high
        assertPrice("$56.25", 2);
        assertPrice("$57.00", 3);
        assertPrice("$57.00", 4);
        assertPrice("$59.00", 5);
        assertPrice("$60.00", 6);
        assertPrice("$69.00", 7);
        assertPrice("$69.00", 8);
        assertPrice("$77.00", 9);
        assertPrice("$77.00", 10);
        assertPrice("$77.00", 11);
        assertPrice("$84.00", 12);


    }

    @After
    public void tearDown() {
        close();
    }
}
