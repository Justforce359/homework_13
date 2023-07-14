package com.justforge359.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.justforge359.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    SelenideElement
            firstnameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submit = $("#submit"),
            shouldHaveText = $("#example-modal-sizes-title-lg"),
            formCheck = $(".modal-body"),
            closeWindow = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstname(String value) {
        firstnameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastname(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage userNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage hobbiesInput(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPic(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage currentAdd(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage stateAndCityInput(String state, String city) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        cityInput.click();
        cityInput.$(byText(city)).click();

        return this;
    }

    public RegistrationPage submitClick() {
        submit.click();
        return this;
    }

    public RegistrationPage shouldHave(String value) {
        shouldHaveText.shouldHave(text(value));
        return this;
    }

    public RegistrationPage resultFormCheck(String fieldLabel, String fieldValue) {
        formCheck.$(byText(fieldLabel))
                .parent()
                .shouldHave(Condition.text(fieldValue));
        return this;
    }
    public RegistrationPage closeModalWindow() {
        closeWindow.click();
        return this;
    }
}
