package com.justforge359.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitClick = $("#submit"),
            nameResult = $("#output #name"),
            emailResult = $("#output #email"),
            currentResult = $("#output #currentAddress"),
            permanentResult = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("text-box");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setClick() {
        submitClick.click();
        return this;
    }

    public TextBoxPage checkResult(String user, String email, String currentA, String permanentA) {
        nameResult.shouldHave(text(user));
        emailResult.shouldHave(text(email));
        currentResult.shouldHave(text(currentA));
        permanentResult.shouldHave(text(permanentA));
        return this;
    }

}
