package test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import page.AlphaIndustriesPages.AlphaIndustriesHomePagePF;

public class AlphaIndustriesTest {
    private WebDriver driver;
    private String QuantityOfGoodsValue;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void AddItemsToCart() throws InterruptedException {
        int ExpectedNumberOfItemsInCart = new AlphaIndustriesHomePagePF(driver)
                .openPage()
                .openSearch()
                .searchForProducts("mjm21000c1")
                .selectProduct()
                .addProductToCart()
                .countItemsInCart();
        Assert.assertTrue(ExpectedNumberOfItemsInCart>0,"The item is not in the cart");
    }

    @Test
    public void IncreaseQuantityOfGoods() throws InterruptedException {
        QuantityOfGoodsValue = "2";
        String ExpectedQuantityOfGoods = new AlphaIndustriesHomePagePF(driver)
                .openPage()
                .openSearch()
                .searchForProducts("mjm21000c1")
                .selectProduct()
                .addProductToCart()
                .increaseQuantityOfGoods(QuantityOfGoodsValue)
                .countQuantityOfGoods();
        Assert.assertEquals(QuantityOfGoodsValue, ExpectedQuantityOfGoods);
    }

    @AfterMethod(alwaysRun = true)
    public void BrowserTearDown() {
        driver.quit();
    }
}