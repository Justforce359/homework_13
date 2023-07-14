package com.justforge359.tests;

import com.justforge359.pages.TextBoxPage;
import org.junit.jupiter.api.Test;


public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTests() {
        textBoxPage.openPage()
                .setUserName(testDataGenerator.firstName + " " + testDataGenerator.lastName)
                .setEmail(testDataGenerator.userEmail)
                .setCurrentAddress(testDataGenerator.currentAdd)
                .setPermanentAddress(testDataGenerator.permAdd)
                .setClick();
                textBoxPage.checkResult(testDataGenerator.firstName + " " + testDataGenerator.lastName,
                        testDataGenerator.userEmail,
                        testDataGenerator.currentAdd,
                        testDataGenerator.permAdd);

    }

}
