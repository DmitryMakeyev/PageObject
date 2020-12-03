package page.AlphaIndustriesPages;
import page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlphaIndustriesSearchResultPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"collectionsallproductsmjm21000c1-ma-1-bomber-jacket-heritage-m-1\"]/div/div[1]/a")
    WebElement productBlock;

    public AlphaIndustriesSearchResultPage(WebDriver driver) {
        super(driver);
    }
    public AlphaIndustriesProductPage selectProduct(){
        productBlock.click();
        return new AlphaIndustriesProductPage(driver);
    }
}
