package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlphaIndustriesCartPage extends AbstractPage{
    @FindBy(xpath = "//*[@id='shopify-section-cart-template']/div/form/table/tbody/tr")
    List<WebElement> itemsInCart;

    public AlphaIndustriesCartPage(WebDriver driver) {
        super(driver);
    }

    public int countItemsInCart(){
        return itemsInCart.size();
    }
}
