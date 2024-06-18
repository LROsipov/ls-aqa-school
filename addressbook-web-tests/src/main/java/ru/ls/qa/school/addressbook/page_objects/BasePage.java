package ru.ls.qa.school.addressbook.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.editable;

abstract class BasePage {

    public void clearInput(SelenideElement input) {
        input.sendKeys(Keys.CONTROL + "A");
        input.sendKeys(Keys.BACK_SPACE);
    }

    public void setValueIntoInput(SelenideElement input, String value) {
        clearInput(input);
        input.shouldBe(editable).setValue(value);
    }
}
