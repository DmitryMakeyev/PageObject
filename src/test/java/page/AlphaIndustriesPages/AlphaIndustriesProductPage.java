package page.AlphaIndustriesPages;
import page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlphaIndustriesProductPage extends AbstractPage {

    @FindBy(id = "AddToCart-product-template")
    WebElement addToCartButton;

    public AlphaIndustriesProductPage(WebDriver driver) {
        super(driver);
    }
    public AlphaIndustriesCartPage addProductToCart() {
        addToCartButton.click();
        return new AlphaIndustriesCartPage(driver);
    }
}
