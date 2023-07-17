package com.justforge359.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.justforge359.data.TestDataGenerator;
import com.justforge359.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.tests.SystemPropertiesTests;

import java.util.Map;

public class TestBaseRemote {
    TestDataGenerator testDataGenerator = new TestDataGenerator();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = SystemPropertiesTests.browserProperty;
        Configuration.browserSize = SystemPropertiesTests.browserSizeProperty;
        Configuration.browserVersion = SystemPropertiesTests.browserVersionProperty;
        Configuration.baseUrl = SystemPropertiesTests.baseUrlProperty;
        Configuration.remote = SystemPropertiesTests.remoteSelenoidProperty;
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
