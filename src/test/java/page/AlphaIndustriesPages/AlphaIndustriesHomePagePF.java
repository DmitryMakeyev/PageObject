package page.AlphaIndustriesPages;
import page.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class AlphaIndustriesHomePagePF extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.alphaindustries.com/";

    @FindBy(id = "geCloseBtn")
    WebElement closeAdvButton;

    @FindBy(xpath = "//*[@id='alpha-login-bar-right']/div[3]/div/a")
    WebElement searchButton;

    public AlphaIndustriesHomePagePF(WebDriver driver) {
        super(driver);
    }

    public AlphaIndustriesHomePagePF openPage(){
        driver.get(HOMEPAGE_URL);

        return this;
    }

    public AlphaIndustriesSearchPage openSearch(){
        closeAdvButton.click();
        searchButton.click();
        return new AlphaIndustriesSearchPage(driver);
    }

}
