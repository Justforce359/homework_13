package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    public static String browserProperty = System.getProperty("browser", "chrome"),
            browserSizeProperty = System.getProperty("browserSize", "1920x1080"),
            browserVersionProperty = System.getProperty("browserVersion", "100"),
            baseUrlProperty = System.getProperty("baseUrl", "https://demoqa.com"),
            remoteSelenoidProperty = System.getProperty("remoteSelenoidUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
}
