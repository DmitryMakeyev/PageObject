package page.AlphaIndustriesPages;
import page.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlphaIndustriesSearchPage extends AbstractPage {

    @FindBy(id = "bc-sf-search-box-0")
    WebElement searchInput;

    public AlphaIndustriesSearchPage(WebDriver driver) {
        super(driver);
    }

    public AlphaIndustriesSearchResultPage searchForProducts(String productCode) {
        searchInput.sendKeys(productCode);
        searchInput.sendKeys(Keys.ENTER);
        return new AlphaIndustriesSearchResultPage(driver);
    }
}
