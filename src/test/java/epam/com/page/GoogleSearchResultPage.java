package epam.com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by anastasiya_mashkevic on 3/17/17.
 */
public class GoogleSearchResultPage extends AbstractPage {

    private static final String BASE_URL = "https://www.google.by";
    private static final String QUERY = "WebDriver";

    public GoogleSearchResultPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy (xpath = "//input/[@id = 'lst-id]")
    private WebElement fieldSearch;

    @FindBy(xpath ="*//div[1][@class = 'g']//a")
    private WebElement linkOfResult;

    public boolean assertResultSearch ()
    {
        return linkOfResult.getText().contains(QUERY);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
