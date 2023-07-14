package com.justforge359.tests;


import com.justforge359.pages.RegistrationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class HwPageObjectsRemoteTest extends TestBaseRemote {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    void fillFormTest() {
        String firstName = testDataGenerator.firstName;
        String lastName = testDataGenerator.lastName;
        String userEmail = testDataGenerator.userEmail;
        String userGender = testDataGenerator.userGender;
        String phoneNumber = testDataGenerator.phoneNumber;
        String rDay = testDataGenerator.rDay;
        String rMonth = testDataGenerator.rMonth;
        String rYear = testDataGenerator.rYear;
        String subjects = testDataGenerator.subjects;
        String hobbies = testDataGenerator.hobbies;
        String randomPic = testDataGenerator.randomPic;
        String currentAdd = testDataGenerator.currentAdd;
        String randomState = testDataGenerator.randomState;
        String randomCity = testDataGenerator.randomCity;

        step("Open page", () -> registrationPage.openPage());
        step("Fill form", () -> {
                    registrationPage.setFirstname(firstName)
                            .setLastname(lastName)
                            .setUserEmail(userEmail)
                            .setGender(userGender)
                            .userNumber(phoneNumber)
                            .setBirthDate(rDay, rMonth, rYear)
                            .setSubjectsInput(subjects)
                            .hobbiesInput(hobbies)
                            .uploadPic(randomPic)
                            .currentAdd(currentAdd)
                            .stateAndCityInput(randomState, randomCity)
                            .submitClick();
                });

        step("Check form", () -> {registrationPage.shouldHave("Thanks for submitting the form")
                .resultFormCheck("Student Name", firstName + " " + lastName)
                .resultFormCheck("Student Email", userEmail)
                .resultFormCheck("Gender", userGender)
                .resultFormCheck("Mobile", phoneNumber)
                .resultFormCheck("Date of Birth", rDay + " " + rMonth + "," + rYear)
                .resultFormCheck("Subjects", subjects)
                .resultFormCheck("Hobbies", hobbies)
                .resultFormCheck("Picture", randomPic)
                .resultFormCheck("Address", currentAdd)
                .resultFormCheck("State and City", randomState + " " + randomCity);
        });
    }
}
