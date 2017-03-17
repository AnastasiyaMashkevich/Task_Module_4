package epam.com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by anastasiya_mashkevic on 3/17/17.
 */
public class GoogleMainPage extends AbstractPage {

    private static final String BASE_URL = "https://www.google.by";
    private static final String QUERY = "WebDriver";

    public GoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@value = 'Пошук Google']")
    private WebElement butonSearch;

    @FindBy (xpath = "//div[@id = 'gs_lc0']/input")
    private WebElement fieldForQuery;

    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public boolean isNeedPageOpen ()
    {
        return butonSearch.isDisplayed();

    }

    public GoogleSearchResultPage doSomeGoogleQuery ()
    {
        fieldForQuery.sendKeys(QUERY);
        butonSearch.click();
        return new  GoogleSearchResultPage (driver);
    }
}
