package epam.com.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by anastasiya_mashkevic on 3/17/17.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

   private int counter = 0;
   private int retryLimit = 4;

    @Override
    public boolean retry(ITestResult result)
    {
        if(counter < retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}


