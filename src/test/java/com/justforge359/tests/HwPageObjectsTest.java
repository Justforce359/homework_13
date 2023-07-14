package com.justforge359.tests;


import com.justforge359.data.TestDataGenerator;
import com.justforge359.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class HwPageObjectsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestDataGenerator testDataGenerator = new TestDataGenerator();

    @Test
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

        registrationPage.openPage()
                .setFirstname(firstName)
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

        registrationPage.shouldHave("Thanks for submitting the form")
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
    }
}
