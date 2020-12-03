package page.AlphaIndustriesPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBys;
import page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AlphaIndustriesCartPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='shopify-section-cart-template']/div/form/table/tbody/tr")
    List<WebElement> itemsInCart;
    @FindBy(className = "cart__qty-input")
    WebElement quantityOfGoodsInput;

    public AlphaIndustriesCartPage(WebDriver driver) {
        super(driver);
    }

    public int countItemsInCart(){
        return itemsInCart.size();
    }

    public AlphaIndustriesCartPage increaseQuantityOfGoods(String QuantityOfGoodsValue){
        quantityOfGoodsInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), QuantityOfGoodsValue);
        quantityOfGoodsInput.sendKeys(Keys.ENTER);
        return this;
    }

    public String countQuantityOfGoods(){
        return quantityOfGoodsInput.getAttribute("value");
    }
}
