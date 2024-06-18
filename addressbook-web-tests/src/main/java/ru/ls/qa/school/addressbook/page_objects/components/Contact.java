package ru.ls.qa.school.addressbook.page_objects.components;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ru.ls.qa.school.addressbook.page_objects.ContactPage;

import static com.codeborne.selenide.Condition.visible;

@Getter
public class Contact {
    private final SelenideElement root;
    private final SelenideElement checkbox;
    private final SelenideElement lastName;
    private final SelenideElement fistName;
    private final SelenideElement address;
    private final SelenideElement allEmail;
    private final SelenideElement allPhones;
    private final SelenideElement buttonDetails;
    private final SelenideElement buttonEdit;

    public Contact(SelenideElement root) {
        this.root = root;
        this.checkbox = root.$x(".//td[1]")
                            .as("Чекбокс");
        this.lastName = root.$x(".//td[2]")
                            .as("Lastname");
        this.fistName = root.$x(".//td[3]")
                            .as("Firstname");
        this.address = root.$x(".//td[4]")
                           .as("Address");
        this.allEmail = root.$x(".//td[5]")
                            .as("All e-mail");
        this.allPhones = root.$x(".//td[6]")
                             .as("All phones");
        this.buttonDetails = root.$x(".//td[7]")
                                 .as("Кнопка [Details]");
        this.buttonEdit = root.$x(".//td[8]/a")
                              .as("Кнопка [Edit]");
    }

    public ContactPage clickButtonEdit() {
        buttonEdit.shouldBe(visible)
                .click();
        return new ContactPage();
    }

    public Contact clickCheckbox() {
        checkbox.shouldBe(visible)
                  .click();
        return this;
    }
}
