package test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import page.AlphaIndustriesHomePagePF;

public class AlphaIndustriesTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @AfterMethod(alwaysRun = true)
    public void BrowserTearDown() {
        driver.quit();
    }
}