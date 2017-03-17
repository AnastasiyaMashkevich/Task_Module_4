package epam.com.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by anastasiya_mashkevic on 3/17/17.
 */
public class Config {

    private static Properties config = new Properties();

    private static InputStream is = Config.class.getResourceAsStream("/config.properties");

    static {

        try{
            config.load(is);
        } catch (Exception e){
            System.out.println("Error reading from property file");

        }
    }

    public static String getBrowser()
    {
        return config.getProperty("browserChrome");
    }
}
