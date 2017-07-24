package epam.com.steps;


import epam.com.driver.DriverFactory;
import epam.com.page.GoogleMainPage;
import epam.com.page.GoogleSearchResultPage;

import epam.com.util.Config;
import org.openqa.selenium.WebDriver;

public class GoogleSearchSteps {

    private WebDriver driver;

    public void initBrowser()
    {
        driver = DriverFactory.getDriver(Config.getBrowser());
    }

    public void closeDriver()
    {
        driver.quit();
    }

    public boolean isOpenPage ()
    {
        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        googleMainPage.openPage();
        return googleMainPage.isNeedPageOpen();
    }


    public boolean isCorrectSearch ()
    {
        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);
        googleMainPage.openPage();
        googleMainPage.doSomeGoogleQuery();
        return googleSearchResultPage.assertResultSearch();
    }
}
