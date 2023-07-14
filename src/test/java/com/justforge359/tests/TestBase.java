package com.justforge359.tests;

import com.codeborne.selenide.Configuration;
import com.justforge359.data.TestDataGenerator;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    TestDataGenerator testDataGenerator = new TestDataGenerator();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

}
