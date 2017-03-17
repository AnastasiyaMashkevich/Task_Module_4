package epam.com;

import epam.com.steps.GoogleSearchSteps;
import epam.com.util.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by anastasiya_mashkevic on 3/17/17.
 */
public class GoogleSearchTest {

    private GoogleSearchSteps googleSearchSteps;

    @BeforeTest(description = "Init browser")
    public void setUp() {
        googleSearchSteps = new GoogleSearchSteps();
        googleSearchSteps.initBrowser();
    }

    @Test
    public void assertOneCanOpenMainPage () {
        Assert.assertTrue(googleSearchSteps.isOpenPage());
    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void assertOneCanTakeCorrectSearchResult () {
        Assert.assertTrue(googleSearchSteps.isCorrectSearch());
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser() {
        googleSearchSteps.closeDriver();
    }

}
